package com.gautam.movies

import android.content.Context
import android.os.Bundle

import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import org.jetbrains.anko.*
import org.jetbrains.anko.design.*
import androidx.core.content.edit
import com.gautam.movies.genreFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs=getPreferences(Context.MODE_PRIVATE)
        val login=LoginActivity()
        if(!login.isLoggedIn()){
            startActivity<LoginActivity>()
            this@MainActivity.finish()
        }
//        else{
//            navHeaderEmail.setText("My nigga cool")
//            navHeaderUserName.setText("dfdfdf")
//        }
//        else{
//        navHeaderEmail.text=prefs.getString(R.string.loggedin_email_key.toString(),"user@example.com").toString()
//        navHeaderUserName.text=login.db.loginDao().getName(prefs.getString(R.string.loggedin_email_key.toString(),"user@example.com").toString()).toString()
//    }
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            view.longSnackbar("Open ma nigga to see","Sure!"){
                startActivity<LoginActivity>()
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_genres -> {
                val bundle=Bundle()
                var frag=genreFragment()
                frag.arguments=bundle
                supportFragmentManager.beginTransaction().replace(R.id.mainContent,frag).commit()
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_logout-> {
                alert("Log out of your Account?") {
                    yesButton {
                        prefs.edit {
                            this.putBoolean(R.string.login_key.toString(),false)
                        }
                        startActivity<LoginActivity>()
                        this@MainActivity.finish()
                    }
                    noButton {
                        drawer_layout.closeDrawer(GravityCompat.START)
                    }
                }.show()

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
