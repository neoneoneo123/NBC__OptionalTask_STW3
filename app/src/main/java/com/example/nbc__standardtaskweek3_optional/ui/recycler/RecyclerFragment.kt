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
import com.example.nbc__standardtaskweek3_optional.extension.showToast
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
        recyclerViewShow()

        return root
    }

    private fun recyclerViewShow() {
        notificationsViewModel = ViewModelProvider(requireActivity()).get(NotificationsViewModel::class.java)
        notificationsViewModel.flowers.observe(viewLifecycleOwner) {
            val itemAdapter = ItemAdapter(it)

            binding.rvItem.layoutManager = LinearLayoutManager(this.requireContext())
            binding.rvItem.adapter = itemAdapter

            //toast 띄우기 - extension
            itemAdapter.itemClickListener = object : ItemAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val item = it[position]
                    context?.showToast("${item.name} 클릭됨")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}