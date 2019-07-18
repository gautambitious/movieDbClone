package com.gautam.movies

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.content_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        setSupportActionBar(toolbar)
        val content=forgotPasswordMain
        content.layoutResource=R.layout.content_forgot_password
        content.inflate()
//        button.setOnClickListener {
//            content.layoutResource=R.layout.forgot_password_layout
//            content.inflate()
//        }
    }

}
