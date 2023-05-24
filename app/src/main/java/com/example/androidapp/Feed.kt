package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp.databinding.ActivityFeedBinding
import com.example.androidapp.databinding.ActivityMainBinding

class Feed : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {

                    startActivity(Intent(this@Feed, Home::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.feed -> {

                    startActivity(Intent(this@Feed, Feed::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.profile -> {

                    startActivity(Intent(this@Feed, Profile::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.settings -> {

                    startActivity(Intent(this@Feed, Settings::class.java))
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