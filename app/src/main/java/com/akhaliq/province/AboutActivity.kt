package com.akhaliq.province

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //val actionbar = supportActionBar
        //actionbar!!.title = "Profile"
        //actionbar.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.hide()
        val btnBack: Button = findViewById(R.id.btn_Back)
        val imgProfile: ImageView = findViewById(R.id.imgProfile)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvEmail: TextView = findViewById(R.id.tvEmail)

        Glide.with(this)
            .load(R.drawable.profile)
            .apply(RequestOptions())
            .into(imgProfile)
        tvName.text = "Abdul Khaliq Arrachman "
        tvEmail.text = "khaliq.umb@gmail.com"


        btnBack.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_Back -> {
                val iMainActivity = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(iMainActivity)
            }
        }
    }
}