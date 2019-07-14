package com.gautam.movies
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.util.Log
import androidx.core.content.edit
import androidx.room.Room
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import java.lang.Exception

lateinit var prefs:SharedPreferences
class LoginActivity : AppCompatActivity() {
val db by lazy {
    Room.databaseBuilder(this,loginDatabase::class.java,"users.db")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .build()
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
//        db.loginDao().insertRow(Login("hello","hello@gmail.com","hello"))
        forgotPasswordButton.setOnClickListener {
            toast("Ma nigga actually works!")
        }
        loginButton.setOnClickListener{
            loginButtonFunction()
        }
        signUpButton.setOnClickListener {
            startActivity<SignUpActivity>()
        }
    }

    fun loginButtonFunction() {
            if(loginCheck(userNameText.text.toString())){
                toast("Welcome my nigger")
                prefs.edit {
                    this.putBoolean(R.string.login_key.toString(),true)
                }
                startActivity<MainActivity>()
                this@LoginActivity.finish()
            }
        else{
                toast("Lol")
            }
    }

    fun loginCheck(email:String): Boolean {
        if(db.loginDao().getPassword(email)==passwordText.text.toString()){
            prefs.edit {
                this.putString(R.string.loggedin_email_key.toString(),email)
            }
            return true}
        return false
    }

    fun isLoggedIn():Boolean{
        return prefs.getBoolean(R.string.login_key.toString(),false)
    }
}
