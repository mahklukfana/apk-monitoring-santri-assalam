package com.example.mhyneuq.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.databinding.FragmentKeuanganBinding

class KeuanganFragment : Fragment() {

    private lateinit var keuanganViewModel: KeuanganViewModel
    private var _binding: FragmentKeuanganBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        keuanganViewModel =
            ViewModelProvider(this).get(KeuanganViewModel::class.java)

        _binding = FragmentKeuanganBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView : TextView = binding.textKeuangan
        keuanganViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}