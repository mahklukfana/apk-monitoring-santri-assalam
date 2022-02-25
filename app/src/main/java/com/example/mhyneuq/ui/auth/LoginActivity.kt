package com.example.mhyneuq.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mhyneuq.NavigationActivity
import com.example.mhyneuq.core.data.source.remote.network.State
import com.example.mhyneuq.core.data.source.remote.request.LoginRequest
import com.example.mhyneuq.databinding.ActivityLoginBinding
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    //    #1
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        #2
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        mainButton()
    }

    private fun setData() {
        binding.inputEmail.setText("mhamdany649@gmail.com")
        binding.inputPassword.setText("mhamdany")
    }

    private fun mainButton(){
        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.btnDaftar.setOnClickListener {
            intentActivity(RegisterActivity::class.java)
        }
    }

    private fun login() {

        if(binding.inputEmail.isEmpty()) return
        if(binding.inputPassword.isEmpty()) return

        val body = LoginRequest(
            binding.inputEmail.text.toString(),
            binding.inputPassword.text.toString()
        )

        viewModel.login(body).observe(this, {

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