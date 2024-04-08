package com.example.nbc__standardtaskweek3_optional.ui.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nbc__standardtaskweek3_optional.ItemAdapter
import com.example.nbc__standardtaskweek3_optional.databinding.FragmentRecyclerBinding
import com.example.nbc__standardtaskweek3_optional.flowerData.DataSource
import com.example.nbc__standardtaskweek3_optional.flowerData.flowerList
import com.example.nbc__standardtaskweek3_optional.ui.notifications.NotificationsViewModel

class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null

    private val binding get() = _binding!!

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val recyclerViewModel =
            ViewModelProvider(this).get(RecyclerViewModel::class.java)

        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRecycler
        recyclerViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //recyclerView 처리
        initializeViews()

        return root
    }

    private fun initializeViews() {
        notificationsViewModel = ViewModelProvider(requireActivity()).get(NotificationsViewModel::class.java)
        notificationsViewModel.flowers.observe(viewLifecycleOwner) {
            binding.rvItem.layoutManager = LinearLayoutManager(this.requireContext())
            binding.rvItem.adapter = ItemAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}