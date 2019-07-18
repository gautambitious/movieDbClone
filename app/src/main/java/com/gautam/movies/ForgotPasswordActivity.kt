package com.gautam.movies

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.isVisible

import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.content_forgot_password.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class ForgotPasswordActivity : AppCompatActivity() {
    val db by lazy{
        loginDatabase.createDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        secondLayout.isVisible=false
//        button.setOnClickListener {
//            secondLayout.isVisible=true
//            firstLayout.isVisible=false
//        }
        checkButton.setOnClickListener {
            if(check()){
                secondLayout.isVisible=true
                firstLayout.isVisible=false
            }
        }
    }

    private fun check(): Boolean {
        var sol=true
        val email=email.editText?.text
        val name=name.editText?.text

        if (email.isNullOrBlank() || name.isNullOrBlank()){
            sol=false
            toast("No Fields can be Empty")
        }
        if(db.loginDao().getName(email.toString().toLowerCase()) != name.toString().toLowerCase()){
            sol=false
            longToast("Email and Name Doesn't Match")
        }
        return sol
    }

}
