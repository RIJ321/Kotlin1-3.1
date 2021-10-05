package com.example.kotlin1_31.extensions

import android.graphics.Color

var Color.LIGHT_GRAY: Int
    get() = 99000000
    set(value) {
        LIGHT_GRAY = value
    }

