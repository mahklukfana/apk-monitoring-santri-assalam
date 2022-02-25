package com.example.mhyneuq.ui.keranjang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.R
import com.example.mhyneuq.databinding.FragmentAkunBinding
import com.example.mhyneuq.databinding.FragmentHomeBinding
import com.example.mhyneuq.databinding.FragmentKeranjangBinding
import com.example.mhyneuq.ui.home.HomeViewModel

class KeranjangFragment : Fragment() {

    private lateinit var keranjangViewModel: KeranjangViewModel
    private var _binding: FragmentKeranjangBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        keranjangViewModel =
            ViewModelProvider(this).get(KeranjangViewModel::class.java)

        _binding = FragmentKeranjangBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}