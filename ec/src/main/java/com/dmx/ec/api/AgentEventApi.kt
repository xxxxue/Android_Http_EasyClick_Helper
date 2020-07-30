package com.dmx.ec.api

import android.util.Log
import com.dmx.ec.helper.EcHelper
import org.json.JSONObject

/**
 * 代理事件模块接口
 */
class AgentEventApi {
    private val TAG = this::class.java.simpleName
    private val agentEventUrl = EcHelper.EC_HOST + "agentEvent"


    /**
     * 设置当前的输入法，用于输入数据
     */
    fun setCurrentIme(): Boolean {
        return getDataBoolInJsonByTypeTemplate("setCurrentIme")
    }

    /**
     * 恢复到之前的输入法
     */
    fun restoreIme(): Boolean {
        return getDataBoolInJsonByTypeTemplate("restoreIme")
    }

    /**
     * 执行输入事件
     * @param action 动作，请看类: MotionEvent.ACTION_*
     * @param x x坐标
     * @param y y坐标
     * @param metaState 控制按键，比如说shift键，alt键，ctrl键等控制键, 0或者 1 any meta info
     * @return 布尔型 true 代表成功 false代表失败
     */
    fun inputEvent(action: Int, x: Int, y: Int, metaState: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "inputEvent")
        jsonObject.put("action", action)
        jsonObject.put("x", x)
        jsonObject.put("y", y)
        jsonObject.put("metaState", metaState)

        val result = post(jsonObject.toString())
        Log.d(TAG, "inputEvent: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 执行按下输入事件
     */
    fun touchDown(x: Int, y: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "touchDown")
        jsonObject.put("x", x)
        jsonObject.put("y", y)
        val result = post(jsonObject.toString())
        Log.d(TAG, "touchDown: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 执行移动输入事件
     */
    fun touchMove(x: Int, y: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "touchMove")
        jsonObject.put("x", x)
        jsonObject.put("y", y)
        val result = post(jsonObject.toString())
        Log.d(TAG, "touchMove: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 执行弹起输入事件
     */
    fun touchUp(x: Int, y: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "touchUp")
        jsonObject.put("x", x)
        jsonObject.put("y", y)
        val result = post(jsonObject.toString())
        Log.d(TAG, "touchUp: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 模拟按键,例如home back等
     * @param key 对应的值分别为
     * home, back, left, right, up, down, center,
     * menu, search, enter, delete(or del), recent(recent apps),
     * volume_up, volume_down, volume_mute, camera, power *
     * @return 布尔型 true 成功, false 失败
     */
    fun pressKey(keyStr: String): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "pressKey")
        jsonObject.put("key", keyStr)

        val result = post(jsonObject.toString())
        Log.d(TAG, "pressKey: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 模拟键盘输入
     * @param keyCode 键盘的key，参见KeyEvent.KEYCODE_*
     * @return 布尔型 true 代表成功，false 代表失败
     */
    fun pressKeyCode(keyStr: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "pressKeyCode")
        jsonObject.put("keyCode", keyStr)

        val result = post(jsonObject.toString())
        Log.d(TAG, "pressKeyCode: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 模拟键盘输入
     * @param keyCode keyCode 键盘的key，参见KeyEvent.KEYCODE_*
     * @param metaState metaState 控制按键，比如说shift键，alt键，ctrl键等控制键, 0或者 1
     * @return 布尔型 true 代表成功，false 代表失败。
     */
    fun pressKeyCodeWithMetaState(keyStr: Int, metaState: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "pressKeyCodeWithMetaState")
        jsonObject.put("keyCode", keyStr)
        jsonObject.put("metaState", metaState)

        val result = post(jsonObject.toString())
        Log.d(TAG, "pressKeyCodeWithMetaState: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 打开菜单
     */
    fun menu(): Boolean {
        return getDataBoolInJsonByTypeTemplate("menu")
    }

    /**
     * Enter键
     */
    fun enter(): Boolean {
        return getDataBoolInJsonByTypeTemplate("enter")
    }

    /**
     * delete键
     */
    fun delete(): Boolean {
        return getDataBoolInJsonByTypeTemplate("delete")
    }

    /**
     * 关闭屏幕，屏幕不亮，但是依然可以自动点击
     */
    fun closeScreen(): Boolean {
        return getDataBoolInJsonByTypeTemplate("closeScreen")
    }

    /**
     * 点亮屏幕，和closeScreen相反的动作
     */
    fun lightScreen(): Boolean {
        return getDataBoolInJsonByTypeTemplate("lightScreen")
    }


    // region 获取 json
    fun getDataStringInJsonByTypeTemplate(typeStr: String): String {

        val res = EcHelper.getDataStringInJsonByTypeTemplate(agentEventUrl,typeStr)
        Log.d(TAG, "$typeStr: $res")
        return res
    }

    fun getDataBoolInJsonByMsgTemplate(typeStr: String, msg: String): Boolean {
        val res = EcHelper.getDataBoolInJsonByMsgTemplate(agentEventUrl,typeStr,msg)
        Log.d(TAG, "$typeStr: $res")
        return res
    }

    fun getDataBoolInJsonByTypeTemplate(typeStr: String): Boolean {
        val res = EcHelper.getDataBoolInJsonByTypeTemplate(agentEventUrl,typeStr)
        Log.d(TAG, "$typeStr: $res")
        return res
    }
    // endregion

    fun post(json: String): String {
        return EcHelper.post(agentEventUrl, json)
    }

}