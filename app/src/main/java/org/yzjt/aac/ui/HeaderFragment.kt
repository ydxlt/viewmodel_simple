package org.yzjt.aac.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.yzjt.aac.R
import org.yzjt.aac.viewmodel.ShareViewModel

/**
 * Created by LT on 2019/8/13.
 */
class HeaderFragment : Fragment() {

    private lateinit var mRootView:View
    private lateinit var mShareViewModel:ShareViewModel
    private lateinit var mTvUserName:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_header, container, false)
        mTvUserName = mRootView.findViewById(R.id.tv_username)
        mShareViewModel = ViewModelProviders.of(activity!!).get(ShareViewModel::class.java)
        mShareViewModel.getUserLiveData().observe(this, Observer {
            mTvUserName.text = it.username
        })
        return mRootView
    }
}