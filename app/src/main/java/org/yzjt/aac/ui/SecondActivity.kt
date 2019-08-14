package org.yzjt.aac.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.yzjt.aac.App
import org.yzjt.aac.R
import org.yzjt.aac.viewmodel.ShareViewModel

/**
 * Created by LT on 2019/8/13.
 */
class SecondActivity : AppCompatActivity(), TextWatcher {

    private lateinit var mShareViewModel:ShareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var et_username: EditText = findViewById(R.id.et_username)
        et_username.addTextChangedListener(this)
        if(application is App){
            mShareViewModel = ViewModelProvider(
                (application as App).getViewModelStore(),
                ViewModelProviders.DefaultFactory(application)
            ).get(
                ShareViewModel::class.java
            )
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable) {
        Log.e("SecondActivity","afterTextChanged/p0:$p0")
        mShareViewModel.getUserLiveData().value?.username = p0.toString()
        mShareViewModel.getUserLiveData().value =  mShareViewModel.getUserLiveData().value
    }
}