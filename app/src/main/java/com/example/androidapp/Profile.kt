package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp.databinding.ActivityMainBinding
import com.example.androidapp.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {

                    startActivity(Intent(this@Profile, Home::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.feed -> {

                    startActivity(Intent(this@Profile, Feed::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.profile -> {

                    startActivity(Intent(this@Profile, Profile::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.settings -> {

                    startActivity(Intent(this@Profile, Settings::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                else -> {

                }
            }
            true



        }
    }
}