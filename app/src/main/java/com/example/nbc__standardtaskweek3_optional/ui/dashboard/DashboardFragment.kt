package com.example.nbc__standardtaskweek3_optional.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import com.example.nbc__standardtaskweek3_optional.databinding.FragmentDashboardBinding
import com.example.nbc__standardtaskweek3_optional.ui.home.HomeViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //1. setFragmentResultListener로 데이터 받기
//        setFragmentResultListener("requestKey") { _, result ->
//            val name = result.getString("name")
//            val description = result.getString("description")
//            binding.tvName.text = "이름 : $name"
//            binding.tvDes.text = "설명 : $description"
//        }

        //2. viewModel로 데이터 받기
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java) //viewModel 초기화
        homeViewModel.flowerName.observe(viewLifecycleOwner) { name ->
            binding.tvName.text = "이름 : $name"
        }
        homeViewModel.flowerDescription.observe(viewLifecycleOwner) { description ->
            binding.tvDes.text = "이름 : $description"
        }

        //3. findNavController()로 전달된 데이터 받기
//        val bundle = arguments
//        val name = bundle?.getString("name")
//        val description = bundle?.getString("description")
//
//        binding.tvName.text = "이름 : $name"
//        binding.tvDes.text = "설명 : $description"

        //4. FragmentManager로 전달
//        val name = arguments?.getString("name")
//        val description = arguments?.getString("description")
//        binding.tvName.text = "이름 : $name"
//        binding.tvDes.text = "이름 : $description"

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}