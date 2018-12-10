package com.ramadhanrp.muslimpintar.features.kiblat

import android.app.AlertDialog
import android.app.AppComponentFactory
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.ramadhanrp.muslimpintar.R
import com.ramadhanrp.muslimpintar.core.base.BaseFragment
import com.ramadhanrp.muslimpintar.features.kiblat.data.KiblatOrientation
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_kiblat.*

class KiblatFragment: BaseFragment(),KiblatContract.View{
    lateinit var viewModel: KiblatViewModel
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(KiblatViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()
    }

    override fun updateDirections(kiblatOrientation: KiblatOrientation) {
        adjustArrow(kiblatOrientation.destinationDirection,kiblatOrientation.lastDestinationDirection,ivCompass)
    }

    override fun bindViewModel() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(viewModel.getKiblatOrientation().subscribe(
            {kiblatOrientation -> this.updateDirections(kiblatOrientation) }
        ))
    }

    override fun unbindViewModel() {
        compositeDisposable.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_kiblat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun adjustArrow(azimuth: Float, currentAzimuth: Float, targetView: View) {
        val rotateAnimation = RotateAnimation(-currentAzimuth, -azimuth,Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF,0.5f)
        rotateAnimation.duration = 500
        rotateAnimation.repeatCount = 0
        rotateAnimation.fillAfter = true
        targetView.startAnimation(rotateAnimation)
    }
}