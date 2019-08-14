package org.yzjt.aac.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import org.yzjt.aac.model.User

/**
 * Created by LT on 2019/8/13.
 */
class ShareViewModel : AndroidViewModel {

    private val userLiveData:MutableLiveData<User> = MutableLiveData()

    constructor(application: Application) : super(application){
        userLiveData.value = User("default","123")
    }


    fun getUserLiveData() : MutableLiveData<User>{
        return userLiveData
    }
}