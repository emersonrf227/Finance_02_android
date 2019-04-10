package br.com.ilikeweb.emerson.ui.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.ilikeweb.emerson.Fragment.HomeFragment
import br.com.ilikeweb.emerson.Fragment.LancamentoFragment
import br.com.ilikeweb.emerson.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainViewPagerAdapter

    val fragments = listOf(LancamentoFragment(), HomeFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()


    }



    private fun setupViewPager() {
        viewpager.offscreenPageLimit = fragments.size

        adapter = MainViewPagerAdapter(supportFragmentManager)


        addFragments()

        viewpager.adapter = adapter

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                viewpager.setCurrentItem(position, false)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private fun addFragments() {
        for (fragment in fragments) {
            adapter.addFragment(fragment)
        }
    }


}







