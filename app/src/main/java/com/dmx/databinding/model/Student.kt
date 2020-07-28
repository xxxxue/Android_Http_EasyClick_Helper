package com.dmx.databinding.model

import com.dmx.databinding.helper.ComOb

data class Student(
    var name: ComOb.String = ComOb.String(),
    var age: ComOb.Int = ComOb.Int(),
    var address: ComOb.String = ComOb.String()
)

