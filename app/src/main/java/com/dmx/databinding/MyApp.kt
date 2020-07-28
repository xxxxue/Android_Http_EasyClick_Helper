package com.dmx.databinding

import android.app.Application
import com.hjq.toast.ToastUtils

/**
 *  绑定到 AndroidManifest  application.name 里生效
 */
class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        //初始化toast
        ToastUtils.init(this);
    }
}