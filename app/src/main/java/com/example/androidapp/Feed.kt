package com.example.androidapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.androidapp.databinding.ActivityFeedBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class Feed : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    lateinit var getPictureButton: Button
    private lateinit var shareButton: Button
    lateinit var gImageView: ImageView
    private var pickImage = 100
    private var imageUri: Uri? = null
    private var tempUri: Uri? = null

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

//                R.id.settings -> {
//
//                    startActivity(Intent(this@Feed, Settings::class.java))
//                    finish()
//                    overridePendingTransition (0, 0)
//
//                }

                else -> {

                }
            }
            true



        }



        gImageView = findViewById(R.id.gImageView)



        getPictureButton = findViewById(R.id.getPictureButton)

        shareButton = findViewById(R.id.shareButton)

        shareButton.setOnClickListener {

            val intent =  Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM, tempUri)

            val chooser = Intent.createChooser(intent, "Share using...")
            startActivity(chooser)
        }


        getPictureButton.setOnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)


        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            tempUri = imageUri
            gImageView.setImageURI(imageUri)

        }
    }





}