package com.ramadhanrp.muslimpintar.features.dashboard

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ramadhanrp.muslimpintar.R
import com.ramadhanrp.muslimpintar.core.base.BaseFragment

class DashboardFragment: BaseFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}
