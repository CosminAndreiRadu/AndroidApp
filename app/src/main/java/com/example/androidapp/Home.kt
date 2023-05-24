package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp.databinding.ActivityHomeBinding
import com.example.androidapp.databinding.ActivityMainBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            it.isChecked = false

            when (it.itemId) {

                R.id.home -> {

                    startActivity(Intent(this@Home, Home::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.feed -> {

                    startActivity(Intent(this@Home, Feed::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.profile -> {

                    startActivity(Intent(this@Home, Profile::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.settings -> {

                    startActivity(Intent(this@Home, Settings::class.java))
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