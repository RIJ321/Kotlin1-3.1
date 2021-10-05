package com.example.kotlin1_31.ui

import android.os.Bundle
import com.example.kotlin1_31.base.BaseActivity
import com.example.kotlin1_31.data.keys.Keys
import com.example.kotlin1_31.databinding.ActivitySecondBinding
import com.example.kotlin1_31.ui.adapter.MyAdapter

class SecondActivity : BaseActivity<ActivitySecondBinding>() {

    private lateinit var adapter: MyAdapter

    override fun initListener() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        intent.getIntegerArrayListExtra(Keys.IMAGES_KEY)?.let {
            adapter = MyAdapter(it,null)
        }
        binding.favouritesRv.adapter = adapter
    }

    override fun inflateBinding(): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(layoutInflater)
    }
}