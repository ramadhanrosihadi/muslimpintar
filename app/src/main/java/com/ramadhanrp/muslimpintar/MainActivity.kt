package com.ramadhanrp.muslimpintar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ramadhanrp.muslimpintar.core.base.BaseActivity
import com.ramadhanrp.muslimpintar.features.dashboard.DashboardFragment
import com.ramadhanrp.muslimpintar.features.kiblat.KiblatFragment
import com.ramadhanrp.muslimpintar.features.prayertimes.PrayerTimesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayView(0,"")
        navigation.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId){
                R.id.navigation_sholat -> {
                    displayView(0,"")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_kiblat -> {
                    displayView(1,"")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_lainnya -> {
                    displayView(2,"")
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    fun displayView(position: Int, data :Any?) {
        var fragment: Fragment = PrayerTimesFragment()
        when (position) {
            0 -> {
                fragment = PrayerTimesFragment()
            }
            1 -> {
                fragment = KiblatFragment()
            }
            2 -> {
                fragment = DashboardFragment()
            }
        }

        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            replace(frameLayout.id, fragment)
            commit()
        }
    }


}
