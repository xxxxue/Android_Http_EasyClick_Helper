package com.dmx.ec.api

import android.util.Log
import com.dmx.ec.helper.EcHelper
import org.json.JSONObject

/**
 * Shell 命令模块接口
 */
class ShellApi {

    private val TAG = this::class.java.simpleName

    private  val shellUrl = EcHelper.EC_HOST + "shell"


    /**
     * 安装 app
     */
    fun installApp(path:String): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "installApp")
        jsonObject.put("path", path)

        val result = post(jsonObject.toString())
        Log.d(TAG, "installApp: $result")
        return EcHelper.getDataBoolInJson(result)
    }
    /**
     * 卸载 app
     */
    fun uninstallApp(packageName:String): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "uninstallApp")
        jsonObject.put("packageName", packageName)

        val result = post(jsonObject.toString())
        Log.d(TAG, "uninstallApp: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 停止正在执行的应用
     */
    fun stopApp(packageName:String): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "stopApp")
        jsonObject.put("packageName", packageName)

        val result = post(jsonObject.toString())
        Log.d(TAG, "stopApp: $result")
        return EcHelper.getDataBoolInJson(result)
    }
    /**
     * 执行Shell命令
     */
    fun execCommand(command:String): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "execCommand")
        jsonObject.put("command", command)

        val result = post(jsonObject.toString())
        Log.d(TAG, "execCommand: $result")
        return EcHelper.getDataBoolInJson(result)
    }



    // region 获取 json
    fun getDataStringInJsonByTypeTemplate(typeStr: String): String {

        val res = EcHelper.getDataStringInJsonByTypeTemplate(shellUrl,typeStr)
        Log.d(TAG, "$typeStr: $res")
        return res
    }

    fun getDataBoolInJsonByMsgTemplate(typeStr: String, msg: String): Boolean {
        val res = EcHelper.getDataBoolInJsonByMsgTemplate(shellUrl,typeStr,msg)
        Log.d(TAG, "$typeStr: $res")
        return res
    }

    fun getDataBoolInJsonByTypeTemplate(typeStr: String): Boolean {
        val res = EcHelper.getDataBoolInJsonByTypeTemplate(shellUrl,typeStr)
        Log.d(TAG, "$typeStr: $res")
        return res
    }
    // endregion

    private fun post(json: String): String {
        return EcHelper.post(shellUrl, json)
    }
}