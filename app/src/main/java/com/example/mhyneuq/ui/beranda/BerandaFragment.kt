package com.example.mhyneuq.ui.beranda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.databinding.FragmentBerandaBinding

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

        setData()
        mainButton()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setData(){
        berandaViewModel.text.observe(viewLifecycleOwner,{
        binding.textHome.text = it
        })
    }

    fun mainButton(){

    }
}