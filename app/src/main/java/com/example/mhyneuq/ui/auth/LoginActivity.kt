package com.example.mhyneuq.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.mhyneuq.NavigationActivity
import com.example.mhyneuq.R
import com.example.mhyneuq.core.data.source.remote.network.State
import com.example.mhyneuq.core.data.source.remote.request.LoginRequest
import com.example.mhyneuq.databinding.ActivityLoginV2Binding
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModel()

    //    #1
    private var _binding: ActivityLoginV2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        #2
        _binding = ActivityLoginV2Binding.inflate(layoutInflater)

//        declare animation
        val test1 = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom)
        val test2 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val test3 = AnimationUtils.loadAnimation(this, R.anim.fade_slow_1)
        val test4 = AnimationUtils.loadAnimation(this, R.anim.fade_slow_2)
        val test5 = AnimationUtils.loadAnimation(this, R.anim.fade_slow_3)
        val test6 = AnimationUtils.loadAnimation(this, R.anim.fade_top)

//        set the animation
        binding.apply {
            tvWelcome.startAnimation(test1)
            tvHope.startAnimation(test1)
            lineLayout2.startAnimation(test2)
            tilUsername.startAnimation(test3)
            tilPassword.startAnimation(test4)
            tvLupaKataSandi.startAnimation(test5)
            btnLogin.startAnimation(test6)
            tvDaftar.startAnimation(test6)
        }

        setData()
        mainButton()
        setContentView(binding.root)
    }

    private fun setData() {
        binding.inputEmail.setText("mhamdany649@gmail.com")
        binding.inputPassword.setText("mhamdany")
    }

    private fun mainButton(){
        binding.btnLogin.setOnClickListener {
            login()
        }

        binding.tvDaftar.setOnClickListener {
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

        viewModel.login(body).observe(this) {

            when (it.state) {
                State.SUCCESS -> {
                    dismisLoading()
//                    showToast("Selamat Datang " + it?.body?.name)
                    toastSuccess("Selamat Datang " + it?.body?.name)
                    pushActivity(NavigationActivity::class.java)
                }
                State.ERROR -> {
                    dismisLoading()
                    toastError(it.message ?: "Terjadi Kesalahan")
                }
                State.LOADING -> {
                    showLoading()
                }
            }
        }
    }

}