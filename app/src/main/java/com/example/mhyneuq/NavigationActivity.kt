package com.example.mhyneuq

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mhyneuq.databinding.ActivityNavigationBinding
import com.example.mhyneuq.ui.auth.LoginActivity
import com.example.mhyneuq.util.SharedPreference

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)

        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener {

//            || it.itemId == R.id.navigation_pemberitahuan || it.itemId == R.id.navigation_chat || it.itemId == R.id.navigation_keuangan
            if (it.itemId == R.id.navigation_profile) {
                if (SharedPreference.isLogin) { //true / false
                    navController.navigate(it.itemId)
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                    Log.d("TAG", "belum login")
                    return@setOnItemSelectedListener false
                }

            } else {
                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yang lain" + it.itemId)
            }

            return@setOnItemSelectedListener true
        }
    }
}