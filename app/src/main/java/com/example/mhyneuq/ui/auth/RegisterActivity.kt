package com.example.mhyneuq.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mhyneuq.NavigationActivity
import com.example.mhyneuq.core.data.source.remote.network.State
import com.example.mhyneuq.core.data.source.remote.request.LoginRequest
import com.example.mhyneuq.core.data.source.remote.request.RegisterRequest
import com.example.mhyneuq.databinding.ActivityRegisterBinding
import com.example.mhyneuq.ui.auth.AuthViewModel
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    //    #1
    private var _binding: ActivityRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        #2
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {

        binding.btnDaftar.setOnClickListener {
            register()
        }

    }

    private fun register() {

        if(binding.inputEmail.isEmpty()) return
        if(binding.inputPassword.isEmpty()) return
        if(binding.inputPhone.isEmpty()) return
        if(binding.inputName.isEmpty()) return

        val body = RegisterRequest(
            binding.inputEmail.text.toString(),
            binding.inputPassword.text.toString(),
            binding.inputPhone.text.toString(),
            binding.inputName.text.toString(),
        )

        viewModel.register(body).observe(this, {

            when (it.state){
                State.SUCCESS ->{
                    dismisLoading()
//                    showToast("Selamat Datang " + it?.body?.name)
                    toastSuccess("Selamat Datang " +  it?.body?.name)
                    pushActivity(NavigationActivity::class.java)
                }
                State.ERROR ->{
                    dismisLoading()
                    toastError(it.message ?: "Terjadi Kesalahan")
                }
                State.LOADING ->{
                    showLoading()
                }
            }
        })
    }

}