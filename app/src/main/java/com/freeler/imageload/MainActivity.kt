package com.freeler.imageload

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeler.imageloader.ImageLoaderManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://static.yuxiaor.com/user-default-img-b-23.png"

        mBtn.setOnClickListener { ImageLoaderManager.getInstance().showImage(ImageLoaderManager.getDefaultOptions(mIv, url)) }
    }
}
