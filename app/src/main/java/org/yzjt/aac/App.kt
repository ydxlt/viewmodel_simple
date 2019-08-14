package org.yzjt.aac

import android.app.Application
import androidx.lifecycle.ViewModelStore

/**
 * Created by LT on 2019/8/13.
 */
class App : Application() {

    private lateinit var mViewModelStore:ViewModelStore

    override fun onCreate() {
        super.onCreate()
        mViewModelStore = ViewModelStore()
    }

    fun getViewModelStore() : ViewModelStore {
        return mViewModelStore
    }
}