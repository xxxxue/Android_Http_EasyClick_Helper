package com.dmx.ec.helper

import android.util.Log
import com.dmx.ec.enum.NodeEnum
import com.dmx.ec.model.CenterVisibleBounds
import com.dmx.ec.model.NodeInfo
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

/**
 * ec api 通用帮助类
 */
class EcHelper {
    companion object {
        val TAG = this::class.java.simpleName

        private val OK_HTTP_CLIENT = OkHttpClient()

        const val EC_HOST = "http://127.0.0.1:20390/"
        // region ec方法帮助类

        // region data属性转换类型
        fun getDataInJson(content: String): JsonElement {
            val jsonObject = JsonParser.parseString(content).asJsonObject
            return jsonObject.get("data")
        }

        fun getDataBoolInJson(content: String): Boolean {
            val jsonObject = JsonParser.parseString(content).asJsonObject
            return jsonObject.get("data").asBoolean
        }

        fun getDataStringInJson(content: String): String {
            val jsonObject = JsonParser.parseString(content).asJsonObject
            return jsonObject.get("data").asString
        }
        // endregion


        // region 获取 json
         fun getDataStringInJsonByTypeTemplate(url: String,typeStr: String): String {
            val res = EcHelper.typeTemplate(url, typeStr)
            return EcHelper.getDataInJson(res).asString
        }

         fun getDataBoolInJsonByMsgTemplate(url: String,typeStr: String, msg: String): Boolean {
            val res = EcHelper.msgTemplate(url, typeStr, msg)
            return EcHelper.getDataInJson(res).asBoolean
        }

         fun getDataBoolInJsonByTypeTemplate(url: String,typeStr: String): Boolean {
            val res = EcHelper.typeTemplate(url, typeStr)
            return EcHelper.getDataInJson(res).asBoolean
        }
        // endregion


        // region http通用模版

        fun typeTemplate(url: String, typeStr: String): String {
            val jsonObject = JSONObject()
            jsonObject.put("type", typeStr)
            val result = post(url, jsonObject.toString())
            return result
        }

        fun msgTemplate(url: String, typeStr: String, msg: String): String {
            val jsonObject = JSONObject()
            jsonObject.put("type", typeStr)
            jsonObject.put("msg", msg)
            val result = post(url, jsonObject.toString())
            return result
        }

        // endregion

        fun post(url: String, json: String): String {
            val body: RequestBody = json.toJsonBody()
            val request: Request = Request.Builder()
                .url(url)
                .post(body)
                .build()

            val result = OK_HTTP_CLIENT.newCall(request).execute().body?.string().toString()

            return result
        }

        private fun String.toJsonBody(): RequestBody {
            val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
            return this.toRequestBody(mediaType)
        }

        // endregion

    }

}