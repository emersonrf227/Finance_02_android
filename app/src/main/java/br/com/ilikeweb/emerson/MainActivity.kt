package br.com.ilikeweb.emerson

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import br.com.ilikeweb.emerson.Fragment.HomeFragment
import br.com.ilikeweb.emerson.Fragment.LancamentoFragment
import br.com.ilikeweb.emerson.Fragment.PagamentoFragment
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
            R.id.navigation_dashboard -> {
                //message.setText("Aqui é o texto 2")
                val ft = supportFragmentManager.beginTransaction()
                val fragment = LancamentoFragment()
                ft.replace(R.id.container, fragment)
                ft.addToBackStack(null)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
               // message.setText(R.string.title_notifications)

                val ft = supportFragmentManager.beginTransaction()
                val fragment = PagamentoFragment()
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

        val ft = supportFragmentManager.beginTransaction()
        val fragment = HomeFragment()
        ft.replace(R.id.container, fragment)
        ft.addToBackStack(null)
        ft.commit()


        //MainActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, HomeFragment()).commit()

       navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }



}
