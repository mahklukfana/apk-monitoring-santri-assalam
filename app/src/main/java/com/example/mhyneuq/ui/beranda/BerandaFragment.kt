package com.example.mhyneuq.ui.beranda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.R
import com.example.mhyneuq.databinding.FragmentBerandaBinding
import com.example.mhyneuq.ui.walisantri.DashboardWaliActivity
import com.inyongtisto.myhelper.extension.intentActivity

class BerandaFragment : Fragment() {

    private lateinit var berandaViewModel: BerandaViewModel
    private var _binding: FragmentBerandaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        berandaViewModel =
            ViewModelProvider(this).get(BerandaViewModel::class.java)

        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        animation()
        setData()
        mainButton()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun animation(){
        val test1 = AnimationUtils.loadAnimation(requireContext(), R.anim.top_to_bottom)
        val test2 = AnimationUtils.loadAnimation(requireContext(), R.anim.left_to_right)
        val test3 = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        val test4 = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_slow_1)
        val test5 = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_slow_2)

        binding.apply {
            cardInformation.startAnimation(test1)
            textNamaUser.startAnimation(test2)
            btnNotifikasi.startAnimation(test3)
            menuPengurusPutra.startAnimation(test4)
            menuSantriPutra.startAnimation(test4)
            menuKitabNgaji.startAnimation(test4)
            menuPengurusPutri.startAnimation(test5)
            menuSantriPutri.startAnimation(test5)
            menuKitabPasan.startAnimation(test5)
        }
    }

    private fun setData(){
//        berandaViewModel.text.observe(viewLifecycleOwner,{
//        binding.textHome.text = it
//        })
    }

    private fun mainButton(){
        binding.btnLihatDetail.setOnClickListener {
            intentActivity(DashboardWaliActivity::class.java)
        }
    }
}