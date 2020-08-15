package com.dmx.databinding.helper

import androidx.databinding.ObservableField

open class ComOb<T>(default: T) : ObservableField<T>(default) {


    var value: T = this.get()!!
        set(value) {
            field = value
            this.set(value)     //注意，这个this.set才是ObservableField原有的方法，即我们之前直接调用的方法
        }
        get() {
            return this.get()!!
        }

    class String(default: kotlin.String = "") : ComOb<kotlin.String>(default)

    class Int(default: kotlin.Int = 0) : ComOb<kotlin.Int>(default)

    class Boolean(default: kotlin.Boolean = false) : ComOb<kotlin.Boolean>(default)

}
