package br.com.ilikeweb.emerson

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import br.com.ilikeweb.emerson.Fragment.*
import kotlinx.android.synthetic.main.activity_main.*


@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //message.setText("Aqui é o texto 1")
                val ft = supportFragmentManager.beginTransaction()
                val fragment = HomeFragment()
                ft.replace(R.id.container, fragment)
                ft.addToBackStack(null)
                ft.commit()

               return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_receita -> {
                //message.setText("Aqui é o texto 2")
                val ft = supportFragmentManager.beginTransaction()
                val fragment = LancamentoFragment()
                ft.replace(R.id.container, fragment)
                ft.addToBackStack(null)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_despesa -> {
               // message.setText(R.string.title_notifications)

                val ft = supportFragmentManager.beginTransaction()
                val fragment = PagamentoFragment()
                ft.replace(R.id.container, fragment)
                ft.addToBackStack(null)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_bank -> {
                // message.setText(R.string.title_notifications)

                val ft = supportFragmentManager.beginTransaction()
                val fragment = MapsFragment()
                ft.replace(R.id.container, fragment)
                ft.addToBackStack(null)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_logout -> {
                // message.setText(R.string.title_notifications)

                val ft = supportFragmentManager.beginTransaction()
                val fragment = SettingFragment()
                ft.replace(R.id.container, fragment)
                ft.addToBackStack(null)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }



        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()!!.hide();

        val ft = supportFragmentManager.beginTransaction()
        val fragment = HomeFragment()
        ft.replace(R.id.container, fragment)
        ft.addToBackStack(null)
        ft.commit()


        //MainActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, HomeFragment()).commit()

       navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }



}
