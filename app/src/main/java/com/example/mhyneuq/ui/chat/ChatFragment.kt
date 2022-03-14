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
import com.example.mhyneuq.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var chatViewModel: ChatViewModel
    private var _binding: FragmentChatBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatViewModel =
            ViewModelProvider(this).get(ChatViewModel::class.java)

        _binding = FragmentChatBinding.inflate(inflater, container, false)
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