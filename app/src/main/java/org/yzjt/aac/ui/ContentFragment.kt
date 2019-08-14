package org.yzjt.aac.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.yzjt.aac.R
import org.yzjt.aac.viewmodel.ShareViewModel

/**
 * Created by LT on 2019/8/13.
 */
class ContentFragment : Fragment(), TextWatcher {

    override fun afterTextChanged(p0: Editable?) {
        mShareViewModel.getUserLiveData().value?.username = p0.toString()
        mShareViewModel.getUserLiveData().value =  mShareViewModel.getUserLiveData().value
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    private lateinit var mRootView:View
    private lateinit var mShareViewModel:ShareViewModel
    private lateinit var mTvUserName:TextView
    private lateinit var mEtUsername:EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_content, container, false)
        mTvUserName = mRootView.findViewById(R.id.tv_username)
        mEtUsername = mRootView.findViewById(R.id.et_username)
        mEtUsername.addTextChangedListener(this)
        mShareViewModel = ViewModelProviders.of(activity!!).get(ShareViewModel::class.java)
        mShareViewModel.getUserLiveData().observe(this, Observer {
            mTvUserName.text = it.username
        })
        return mRootView
    }
}