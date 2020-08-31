package com.akhaliq.province

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbar()
        setWhiteStatusBar()
    }

    protected open fun hideToolbar() {
        if (supportActionBar != null) supportActionBar!!.hide()
    }

    protected open fun setWhiteStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        }
    }

    /*
    protected open fun gotoLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    protected open fun gotoProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

     */

    protected open fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}