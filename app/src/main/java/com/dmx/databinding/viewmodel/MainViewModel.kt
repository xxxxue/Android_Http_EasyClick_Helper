package com.dmx.databinding.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableFloat
import androidx.lifecycle.ViewModel
import com.dmx.databinding.helper.ComOb
import com.dmx.databinding.model.Student
import com.hjq.toast.ToastUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val phone = ComOb.String()
    val smsCode = ComOb.String()

    val loginEnable = object : ObservableBoolean(phone, smsCode) {

        override fun get(): Boolean {

            val phoneStr = phone.get()
            val smsCodeStr = smsCode.get()

            return !(phoneStr.isNullOrEmpty() || smsCodeStr.isNullOrEmpty())

        }
    }
    val loginAlpha = object : ObservableFloat(loginEnable) {
        override fun get(): Float {
            val enable = loginEnable.get()
            return if (enable)
                1.0f
            else
                0.5f
        }
    }

    val list = ArrayList<Student>()

    init {
        for (i in 1..100) {
            val model = Student()
            model.name.value = "小明$i"
            model.age.value = i
            model.address.value = "山西$i"
            list.add(model)
        }

        phone.value = "123444"
        smsCode.value = "123444"

    }

    var currIndex = ComOb.Int()

    fun loginClick() {

        GlobalScope.launch {

            list[currIndex.value].name.value = "小明的爸爸"
            list[currIndex.value].age.value = 9999
            list[currIndex.value].address.value = "山西999"
            currIndex.value++
            // ToastUtils.show(phone.get() + "|" + smsCode.get())
        }
    }

    fun onItemClick(v: View, position: Int) {
        Log.d("TAG", "setOnItemClick: $v")
        ToastUtils.show("点击的子项: $position")
    }

}