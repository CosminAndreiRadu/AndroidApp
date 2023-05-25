package com.example.androidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.androidapp.databinding.ActivityMainBinding
import com.example.androidapp.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    lateinit var auth: FirebaseAuth
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.logOutButton.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }



        val txt = auth.currentUser?.email.toString()
        val myTextView = findViewById<TextView>(R.id.textView2)
        myTextView.text = "Connected as: " + txt

        shareButton = findViewById(R.id.shareButton2)

        shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, txt)

            val chooser = Intent.createChooser(intent, "Share using...")
            startActivity(chooser)
        }

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