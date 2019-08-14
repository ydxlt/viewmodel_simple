package org.yzjt.aac.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
class MainActivity : AppCompatActivity() {

    private lateinit var mTvUserName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTvUserName = findViewById(R.id.tv_username)

        if(application is App){
            val shareViewModel = ViewModelProvider(
                (application as App).getViewModelStore(),
                ViewModelProviders.DefaultFactory(application)
            ).get(
                ShareViewModel::class.java
            )
            shareViewModel.getUserLiveData().observe(this, Observer {
                mTvUserName.text = "name:${it.username}"
            })
        }
    }

    fun second(view: View){
        startActivity(Intent(this,SecondActivity::class.java))
    }
}