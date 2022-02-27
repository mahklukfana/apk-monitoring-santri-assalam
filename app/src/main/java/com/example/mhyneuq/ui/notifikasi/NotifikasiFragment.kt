package com.example.mhyneuq.ui.notifikasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.databinding.FragmentNotifikasiBinding

class NotifikasiFragment : Fragment() {

    private lateinit var notifikasiViewModel: NotifikasiViewModel
    private var _binding: FragmentNotifikasiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notifikasiViewModel =
            ViewModelProvider(this).get(NotifikasiViewModel::class.java)

        _binding = FragmentNotifikasiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textInformasi
        notifikasiViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}