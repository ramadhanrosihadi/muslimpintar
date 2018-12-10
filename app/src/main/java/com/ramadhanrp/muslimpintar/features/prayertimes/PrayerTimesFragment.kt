package com.ramadhanrp.muslimpintar.features.prayertimes

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ramadhanrp.muslimpintar.R
import com.ramadhanrp.muslimpintar.core.base.BaseFragment

class PrayerTimesFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_prayer_times, container, false)
    }
}
