package com.example.kotlin1_31.ui

import android.content.Intent
import android.os.Bundle
import com.example.kotlin1_31.ui.adapter.MyAdapter
import com.example.kotlin1_31.base.BaseActivity
import com.example.kotlin1_31.databinding.ActivityMainBinding
import com.example.kotlin1_31.R
import com.example.kotlin1_31.data.keys.Keys
import com.example.kotlin1_31.ui.adapter.BGListener

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private var sendList = arrayListOf<Int>()

    private var list = arrayListOf(
        R.drawable.one,
        R.drawable.three,
        R.drawable.two,
        R.drawable.four,
        R.drawable.one,
        R.drawable.three,
        R.drawable.two,
        R.drawable.four
    )
    private lateinit var adapter: MyAdapter

    override fun inflateBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFavorites()
        removePhoto()
    }

    private fun removePhoto() {

    }

    private fun openFavorites() {
        binding.btnSelectedPhotos.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java).putExtra(
                    Keys.IMAGES_KEY,
                    sendList
                )
            )
        }
    }


    override fun initListener() {
        adapter = MyAdapter(list, object : BGListener {
            override fun changeBG(image: Int) {
                sendList.add(image)
            }

            override fun remove(image: Int) {
                sendList.remove(image)
            }
        })
        binding.mainRv.adapter = adapter
    }

}