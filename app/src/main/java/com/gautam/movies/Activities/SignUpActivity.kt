package com.gautam.movies

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    lateinit var db:loginDatabase
    var result=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val db  = loginDatabase.createDatabase(this)
        signUpButton.setOnClickListener {
            if (isEligible().equals("")) {
                try {
                    db.loginDao().insertRow(
                        Login(
                            name = signUpName.text.toString().trim(),
                            email = signUpEmail.text.toString().trim().toLowerCase(),
                            password = signUpPassword.text.toString().trim()
                        )
                    )
                    toast("Sign up Successful! Please Login!")
                    startActivity<LoginActivity>()
                }
                catch (e:Exception){
                    toast("Email Already Registed Please Login")
                    this@SignUpActivity.finish()
                }
            } else {
                toast(isEligible())
            }
        }
    }

    private fun isEligible(): String {
        if (!("@" in signUpEmail.text.toString() && "." in signUpEmail.text.toString()))
            result = "Wrong Email Format"
        else if (signUpPassword.text.toString() != signUpPasswordCheck.text.toString()) {
            result = "Password Doesn't Match"
            signUpPasswordCheck.setText("")
        }
        return result
    }
}
