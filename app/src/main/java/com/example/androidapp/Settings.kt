package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidapp.databinding.ActivityMainBinding
import com.example.androidapp.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {

                    startActivity(Intent(this@Settings, Home::class.java))
                    finish()
                    overridePendingTransition (0, 0)


                }

                R.id.feed -> {

                    startActivity(Intent(this@Settings, Feed::class.java))
                    finish()
                    overridePendingTransition (0, 0)


                }

                R.id.profile -> {

                    startActivity(Intent(this@Settings, Profile::class.java))
                    finish()
                    overridePendingTransition (0, 0)


                }

                R.id.settings -> {

                    startActivity(Intent(this@Settings, Settings::class.java))
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