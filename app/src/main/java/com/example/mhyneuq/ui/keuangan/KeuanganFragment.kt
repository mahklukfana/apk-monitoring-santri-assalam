package com.example.mhyneuq.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.R
import com.example.mhyneuq.databinding.FragmentKeuanganBinding
import com.example.mhyneuq.ui.walisantri.DashboardWaliActivity
import com.inyongtisto.myhelper.extension.intentActivity

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

        animation()
        return root
    }

    private fun animation() {
        val test2 = AnimationUtils.loadAnimation(requireContext(), R.anim.left_to_right)
        val test3 = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)

        binding.apply {
            textNamaUser.startAnimation(test2)
            btnNotifikasi.startAnimation(test3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}