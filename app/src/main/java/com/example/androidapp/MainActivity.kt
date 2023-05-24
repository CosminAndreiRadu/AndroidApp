package com.example.androidapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.LayoutInflater
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.androidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  var myVideoView: VideoView? = null
    private var myMediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {



            when (it.itemId) {

                R.id.home -> {

                    startActivity(Intent(this, Home::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.feed -> {

                    startActivity(Intent(this, Feed::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.profile -> {

                    startActivity(Intent(this, Profile::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                R.id.settings -> {

                    startActivity(Intent(this, Settings::class.java))
                    finish()
                    overridePendingTransition (0, 0)

                }

                else -> {

                }



            }
            true


        }

        myVideoView = findViewById(R.id.myVideoView)

        setUpVideoPlayer()
    }

    private fun setUpVideoPlayer() {
        if (myMediaController == null){
            myMediaController = MediaController(this)
            myMediaController!!.setAnchorView(this.myVideoView)
        }

        myVideoView!!.setMediaController(myMediaController)

        myVideoView!!.setVideoURI(
            Uri.parse("android.resource://"
            + packageName + "/" + R.raw.intro)
        )

        myVideoView!!.requestFocus()

        myVideoView!!.pause()

        myVideoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video Completed", Toast.LENGTH_SHORT).show()
        }

        myVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "An Error Occured ", Toast.LENGTH_SHORT).show()
            false
        }

    }


}