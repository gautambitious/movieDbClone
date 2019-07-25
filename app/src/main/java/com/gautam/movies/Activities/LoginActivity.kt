package com.gautam.movies
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

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
        prefs=getPreferences(Context.MODE_PRIVATE)
        forgotPasswordButton.setOnClickListener {
            startActivity<ForgotPasswordActivity>()
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
                toast("Welcome! ${db.loginDao().getName(userNameText.text.toString())}")
                prefs.edit {
                    this.putBoolean(login_key,true)
                }
                Log.i("workk","login check ${prefs.getBoolean(login_key,false)}")
                startActivity<MainActivity>()
                this@LoginActivity.finish()
            }
        else{
                toast("Lol")
            }
    }

    fun loginCheck(email:String): Boolean {
        if(db.loginDao().getPassword(email)==passwordText.text.toString().toLowerCase()){
            return true}
        return false
    }

}
