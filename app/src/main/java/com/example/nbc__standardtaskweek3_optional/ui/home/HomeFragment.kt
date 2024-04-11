package com.example.nbc__standardtaskweek3_optional.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.nbc__standardtaskweek3_optional.R
import com.example.nbc__standardtaskweek3_optional.databinding.FragmentDashboardBinding
import com.example.nbc__standardtaskweek3_optional.databinding.FragmentHomeBinding
import com.example.nbc__standardtaskweek3_optional.extension.showToast
import com.example.nbc__standardtaskweek3_optional.flowerData.DataSource
import com.example.nbc__standardtaskweek3_optional.flowerData.Flower
import com.example.nbc__standardtaskweek3_optional.flowerData.flowerList
import com.example.nbc__standardtaskweek3_optional.ui.dashboard.DashboardFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    //fragment manager 선언
    //private lateinit var fragmentManager: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //데이터 생성
        val data = DataSource.getDataSource().getFlowerList()

        //dashboard fragment로 데이터 전달
        //1. setFragmentResult로 전달 -> 데이터 유지가 안됨
//        val bundle = Bundle().apply {
//            putString("name", data[0].name)
//            putString("description", data[0].description)
//        }
//
//        binding.btnSend.setOnClickListener {
//            setFragmentResult("requestKey", bundle)
//        }

        //2. viewModel로 전달 -> 데이터 유지도 되고, 탭 간 전환도 자연스러움 (best..!)
        binding.btnSend.setOnClickListener {
            homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java) //viewModel 초기화
            homeViewModel.setFlowerInfo(data[0].name, data[0].description) //데이터 설정

            context?.showToast("데이터 전달 완료")
        }

//        3. findNavController()로 전달 -> 전달 후 home 탭을 눌러도 dashboard 탭이 열러서 이상함
//        val bundle = Bundle().apply {
//            putString("name", data[0].name)
//            putString("description", data[0].description)
//        }
//
//        binding.btnSend.setOnClickListener {
//            it.findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard, bundle)
//        }

        //4. FragmentManager로 전달 -> 다른 탭으로 이동이 안돼서 이상함
//        binding.btnSend.setOnClickListener {
//            val bundle = Bundle().apply {
//                putString("name", data[0].name)
//                putString("description", data[0].description)
//            }
//
//            val fragmentDashboard = DashboardFragment()
//            fragmentDashboard.arguments = bundle
//
//            fragmentManager = requireActivity().supportFragmentManager
//
//            fragmentManager.beginTransaction()
//                .replace(R.id.container, fragmentDashboard)
//                .addToBackStack(null)
//                .commit()
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}