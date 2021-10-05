package com.example.kotlin1_31.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBinding()
        setContentView(binding.root)

        initListener()
//        checkInternet()
    }

    abstract fun inflateBinding(): VB

    abstract fun initListener() //  внутри этого метода обрабьтываем все клики

//    abstract fun checkInternet() // checking inet
}