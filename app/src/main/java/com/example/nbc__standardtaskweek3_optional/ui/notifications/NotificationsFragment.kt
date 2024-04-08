package com.example.nbc__standardtaskweek3_optional.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nbc__standardtaskweek3_optional.databinding.FragmentNotificationsBinding
import com.example.nbc__standardtaskweek3_optional.flowerData.DataSource

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val data = DataSource.getDataSource().getFlowerList()

        //recycler fragment로 데이터 전달
        binding.btnRecycler.setOnClickListener {
            notificationsViewModel = ViewModelProvider(requireActivity()).get(NotificationsViewModel::class.java)
            notificationsViewModel.setFlowerInfo(data)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}