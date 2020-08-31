package com.akhaliq.province

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val actionbar = supportActionBar
        actionbar!!.title = "Profile"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgProfile: ImageView = findViewById(R.id.imgProfile)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        Glide.with(this)
            .load(R.drawable.profile)
            .apply(RequestOptions())
            .into(imgProfile)
        tvName.text = "Abdul Khaliq Arrachman "
        tvEmail.text = "khaliq.umb@gmail.com"

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}