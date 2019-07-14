package com.gautam.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
val login=LoginActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpButton.setOnClickListener {
            if(isEligible()==""){
                login.db.loginDao().insertRow(Login(name=signUpName.text.toString(),email = signUpEmail.text.toString(),password = signUpPassword.text.toString()))
                toast("Sign up Successful! Please Login!")
                startActivity<LoginActivity>()
            }
            else{
                toast(isEligible())
            }
        }
    }

    private fun isEligible(): String {
        var result=""
        if (!("@" in signUpEmail.text.toString() && "." in signUpEmail.text.toString()))
            result="Wrong Email Format"
        else if(signUpPassword.text.toString()!=signUpPasswordCheck.text.toString()){
            result="Password Doesn't Match"
            signUpPasswordCheck.setText("")}
        try {
            login.db.loginDao().getName("djdfnd")
            result="Email Already Registerd!"
            signUpEmail.setText("")

        }catch (e:Exception){}
        return result
    }
}
