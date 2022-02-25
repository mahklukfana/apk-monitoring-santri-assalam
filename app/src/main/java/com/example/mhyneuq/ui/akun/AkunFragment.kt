package com.example.mhyneuq.ui.akun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mhyneuq.NavigationActivity
import com.example.mhyneuq.databinding.FragmentAkunBinding
import com.example.mhyneuq.util.SharedPreference
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.pushActivity

class AkunFragment : Fragment() {

    private lateinit var akunViewModel: AkunViewModel
    private var _binding: FragmentAkunBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        akunViewModel =
            ViewModelProvider(this).get(AkunViewModel::class.java)

        _binding = FragmentAkunBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUser()
        mainButton()

        return root
    }

    fun mainButton(){
//        binding.btnLogout.setOnClickListener {
//            SharedPreference.isLogin = false
//            pushActivity(NavigationActivity::class.java)
//        }
    }

    private fun setUser(){
        val user = SharedPreference.getUser()
        if(user != null){
            binding.apply {
                namaUser.text = user.name
//                emailUser.text = user.email
//                phoneUser.text = user.phone
                inisialName.text = user.name.getInitial()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}