package com.dmx.ec.api

import android.util.Log
import com.dmx.ec.enum.NodeEnum
import com.dmx.ec.helper.EcHelper
import com.dmx.ec.model.CenterVisibleBounds
import com.dmx.ec.model.NodeInfo
import com.dmx.ec.model.ResultNodeInfo
import com.dmx.ec.model.ResultNodeInfoList
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

/**
 * 全局节点模块接口
 */
class GlobalApi {
    private val TAG = this::class.java.simpleName

    private  val globalUrl = EcHelper.EC_HOST + "global"


    //region 日志接口
    /**
     * 弹出 Toast 消息
     */
    fun toast(msg: String): Boolean {
        return getDataBoolInJsonByMsgTemplate("toast", msg)
    }

    /**
     * log debug
     */
    fun logd(msg: String): Boolean {
        return getDataBoolInJsonByMsgTemplate("logd", msg)
    }


    /**
     * log info
     */
    fun logi(msg: String): Boolean {
        return getDataBoolInJsonByMsgTemplate("logi", msg)

    }

    /**
     * log warn
     */
    fun logw(msg: String): Boolean {
        return getDataBoolInJsonByMsgTemplate("logw", msg)

    }

    /**
     * log error
     */
    fun loge(msg: String): Boolean {
        return getDataBoolInJsonByMsgTemplate("loge", msg)
    }

    /**
     * 设置保存日志到手机操作
     * @return 字符串，保存日志的文件夹地址
     */
    fun setSaveLog(): String {
        val jsonObject = JSONObject()
        jsonObject.put("type", "setSaveLog")
        jsonObject.put("save", true)
        val result = post(jsonObject.toString())
        Log.d(TAG, "setSaveLog: $result")

        return EcHelper.getDataStringInJson(result)
        //
    }

    //endregion

    // region  节点服务接口

    /**
     * 退出脚本
     */
    fun exit(): Boolean {
        return getDataBoolInJsonByTypeTemplate("exit")
    }

    /**
     * 打开EC设置
     */
    fun openECSystemSetting(): Boolean {
        return getDataBoolInJsonByTypeTemplate("openECSystemSetting")
    }

    /**
     * 是否无障碍模式
     * @return 布尔型，true代表是，false代表否
     */
    fun isAccMode(): Boolean {
        return getDataBoolInJsonByTypeTemplate("isAccMode")
    }

    /**
     * 无障碍服务是否正常
     * @return 布尔型，true代表是，false代表否
     */
    fun isAccServiceOk(): Boolean {
        return getDataBoolInJsonByTypeTemplate("isAccServiceOk")

    }

    /**
     * 是否代理模式
     * @return 布尔型，true代表是，false代表否
     */
    fun isAgentMode(): Boolean {
        return getDataBoolInJsonByTypeTemplate("isAgentMode")
    }

    /**
     * 代理服务是否正常
     * @return 布尔型，true代表是，false代表否
     */
    fun isAgentServiceOk(): Boolean {
        return getDataBoolInJsonByTypeTemplate("isAgentServiceOk")

    }

    /**
     * 节点服务是否正常
     * @return 布尔型，true代表是，false代表否
     */
    fun isServiceOk(): Boolean {
        return getDataBoolInJsonByTypeTemplate("isServiceOk")

    }

    /**
     * 启动环境，最好先激活手机，这样会自动启动环境，且免root
     * @return 布尔型，true代表是，false代表否
     */
    fun startEnv(): Boolean {
        return getDataBoolInJsonByTypeTemplate("startEnv")
    }

    /**
     * 设置EC系统参数
     */
    fun setECSystemSetting() {

        //            设置EC系统参数
        //            @param settings JSON内部属性解释:
        //            running_mode：运行模式，值为 无障碍 或者 代理
        //            auto_start_service: 是否自启动服务，值为 是或者否
        //            daemon_service: 是否守护服务，值为 是或者否
        //            volume_start_tc: 是否音量键启动脚本，值为 是或者否
        //            log_float_window: 是否展示日志悬浮窗，值为 是或者否
        //            @return 布尔型，true代表是，false代表否


        //            {
        //                "type":"setECSystemSetting",
        //                "settings":{
        //                              "running_mode":"无障碍",
        //                              "log_float_window":"是"
        //                          }
        //            }


    }
    // endregion

    // region 点击动作接口

    /**
     * 点击坐标
     */
    fun clickPoint(x: Int, y: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "clickPoint")
        jsonObject.put("x", x)
        jsonObject.put("y", y)
        val result = post(jsonObject.toString())
        Log.d(TAG, "clickPoint: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 长点击坐标
     */
    fun longClickPoint(x: Int, y: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "longClickPoint")
        jsonObject.put("x", x)
        jsonObject.put("y", y)
        val result = post(jsonObject.toString())
        Log.d(TAG, "longClickPoint: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 选择器点击 (未实现)
     */
    fun click() {
        //@param selectors 选择器数组，更多选择器属性，请查看选择器与节点属性
        //@return 布尔型，true代表成功 false代表失败
        /*
            {
                "type": "click",
                "selectors": [{
                            "text": "设置"
                 }]
            }
         */
    }

    /**
     * 选择器 长点击 (未实现)
     */
    fun longClick() {
        //@param selectors 选择器数组，更多选择器属性，请查看选择器与节点属性
        //@return 布尔型，true代表成功 false代表失败
        /*

            {
                "type": "longClick",
                "selectors": [{
                        "text": "设置"
                 }]
            }

         */
    }

    // endregion

    // region 多点触摸动作接口

    /**
     * 多点触摸 (未实现)
     */
    fun multiTouch() {


        /*
             var touch1 = [
                 {"action": 0, "x": 500, "y": 1200, "pointer": 1, "delay": 1},
                 {"action": 2, "x": 500, "y": 1100, "pointer": 1, "delay": 20},
                 {"action": 2, "x": 500, "y": 1000, "pointer": 1, "delay": 20},
                 {"action": 1, "x": 1, "y": 1, "pointer": 1, "delay": 20}
            ];
            var touch2 = [
                 {"action": 0, "x": 800, "y": 1200, "pointer": 2, "delay": 1},
                 {"action": 2, "x": 800, "y": 1100, "pointer": 2, "delay": 20},
                 {"action": 2, "x": 800, "y": 1000, "pointer": 2, "delay": 20},
                 {"action": 1, "x": 800, "y": 1, "pointer": 2, "delay": 20}
            ];
            var p = {
                     "type": "multiTouch",
                     "arrays": [touch1,touch2],
                    "timeout":1000
                 };


         */
    }


    // endregion

    // region 滑动动作接口

    /**
     * 滑动节点(未实现)
     */
    fun swipe() {
        /*

        {
          "type": "swipe",
          "selectors": [{
              "text": "设置"
          }],
         "endX":100,
         "endY":100,
         "duration":1500
        };

         */
    }


    /**
     * 滑动坐标到目标坐标
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param duration 动作持续时长，单位毫秒
     */
    fun swipeToPoint(startX: Int, startY: Int, endX: Int, endY: Int, duration: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "swipeToPoint")
        jsonObject.put("startX", startX)
        jsonObject.put("startY", startY)
        jsonObject.put("endX", endX)
        jsonObject.put("endY", endY)
        jsonObject.put("duration", duration)
        val result = post(jsonObject.toString())
        Log.d(TAG, "swipeToPoint: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 是否滚动到底部了
     */
    fun isScrollEnd() {


        /*

        {
         "type": "isScrollEnd",
         "selectors": [{
             "text": "设置"
         }],
        "direction":"UP"
         }
         */
    }

    // endregion

    // region 拖动动作接口

    /**
     * 从一个坐标到另一个坐标的拖动
     * @param duration 动作持续时长，单位毫秒
     */
    fun drag(startX: Int, startY: Int, endX: Int, endY: Int, duration: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "drag")
        jsonObject.put("startX", startX)
        jsonObject.put("startY", startY)
        jsonObject.put("endX", endX)
        jsonObject.put("endY", endY)
        jsonObject.put("duration", duration)
        val result = post(jsonObject.toString())
        Log.d(TAG, "drag: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 拖动节点到目标节点 (未实现)
     */
    fun dragTo() {

        /*
        {
         "type": "dragTo",
         "selectors": [{
             "text": "设置"
         }],
        "destObj": [{
             "text": "浏览器"
         }],
        "duration":1500
        }
         */
    }


    /**
     * 拖动节点到目标坐标
     */
    fun dragToPoint() {

        /*

        {
         "type": "dragToPoint",
         "selectors": [{
             "text": "设置"
         }],
        "endX":100,
        "endY":100,
        "duration":1500
        }
         */
    }

    // endregion

    // region 输入动作接口

    /**
     * 当前是否是我们的输入法
     */
    fun currentIsOurIme(): Boolean {
        return getDataBoolInJsonByTypeTemplate("currentIsOurIme")
    }

    fun <T> inputText(nodeEnum: NodeEnum, nodeContent: T, content: String): Boolean {
        val jsonStr =
            "{\"type\":\"inputText\",\"selectors\":[{'${nodeEnum.name}':'$nodeContent'}],\"content\":\"$content\"}"
        val result = post(jsonStr)

        Log.d(TAG, "inputText: ${result}")

        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 通过输入法输入内容
     */
    fun <T> imeInputText(nodeEnum: NodeEnum, nodeContent: T, content: String): Boolean {
        val jsonStr =
            "{\"type\":\"imeInputText\",\"selectors\":[{'${nodeEnum.name}':'$nodeContent'}],\"content\":\"$content\"}"
        val result = post(jsonStr)

        Log.d(TAG, "imeInputText: ${result}")

        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 通过选择器粘贴数据
     */
    fun <T> pasteText(nodeEnum: NodeEnum, nodeContent: T, content: String): Boolean {
        val jsonStr =
            "{\"type\":\"pasteText\",\"selectors\":[{'${nodeEnum.name}':'$nodeContent'}],\"content\":\"$content\"}"
        val result = post(jsonStr)

        Log.d(TAG, "pasteText: ${result}")

        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 通过选择器清除数据
     */
    fun <T> clearTextField(nodeEnum: NodeEnum, nodeContent: T): Boolean {
        val jsonStr =
            "{\"type\":\"clearTextField\",\"selectors\":[{'${nodeEnum.name}':'$nodeContent'}]}"
        val result = post(jsonStr)

        Log.d(TAG, "clearTextField: ${result}")

        return EcHelper.getDataBoolInJson(result)
    }
    // endregion

    // region 节点操作接口

    /**
     * 通过选择器判断元素是否存在
     */
    fun <T> has(nodeEnum: NodeEnum, content: T): Boolean {
        val jsonStr = "{\"type\":\"has\",\"selectors\":[{'${nodeEnum.name}':'$content'}]}"
        val result = post(jsonStr)
        Log.d(TAG, "has: ${result}")

        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 等待activity界面出现
     */
    fun waitExistActivity(activityName: String, timeout: Int): Boolean {
        val jsonObject = JSONObject()
        jsonObject.put("type", "waitExistActivity")
        jsonObject.put("activity", activityName)
        jsonObject.put("timeout", timeout)

        val result = post(jsonObject.toString())
        Log.d(TAG, "waitExistActivity: $result")
        return EcHelper.getDataBoolInJson(result)
    }

    /**
     * 通过选择器判断并等待元素是否存在
     */
    fun <T> waitExistNode(nodeEnum: NodeEnum, content: T, timeout: Int = 3000): Boolean {
        val jsonStr =
            "{\"type\":\"waitExistNode\",\"selectors\":[{'${nodeEnum.name}':'$content'}],\"timeout\":$timeout}"
        val result = post(jsonStr)
        Log.d(TAG, "waitExistNode: ${result}")

        return EcHelper.getDataBoolInJson(result)
    }


    /**
     * 获取多个节点信息
     */
    fun <T> getNodeInfo(
        nodeEnum: NodeEnum,
        content: T,
        timeout: Int = 3000
    ): ResultNodeInfoList {
        val jsonStr =
            "{\"type\":\"getNodeInfo\",\"selectors\":[{'${nodeEnum.name}':'$content'}],\"timeout\":$timeout}"
        val result = post(jsonStr)

        Log.d(TAG, "getNodeInfo: ${result}")

        val jsonObject = JsonParser.parseString(result).asJsonObject

        val data = jsonObject.getAsJsonArray("data")

        if (data.size() == 0) {
            return ResultNodeInfoList(false, null)
        } else {
            val res: ArrayList<NodeInfo> =
                Gson().fromJson(data, object : TypeToken<ArrayList<NodeInfo>>() {}.type)
            return ResultNodeInfoList(true, res)
        }
    }


    /**
     * 获取多个节点信息
     */
    fun <T> getOneNodeInfo(
        nodeEnum: NodeEnum,
        content: T,
        timeout: Int = 3000
    ): ResultNodeInfo {
        val jsonStr =
            "{\"type\":\"getOneNodeInfo\",\"selectors\":[{'${nodeEnum.name}':'$content'}],\"timeout\":$timeout}"
        val result = post(jsonStr)

        Log.d(TAG, "getNodeInfo: ${result}")


        val jsonObject = JsonParser.parseString(result).asJsonObject

        val data = jsonObject.getAsJsonObject("data")


        if (data == null) {
            return ResultNodeInfo(false, null)
        } else {
            val res: NodeInfo =
                Gson().fromJson(data, object : TypeToken<NodeInfo>() {}.type)
            return ResultNodeInfo(true, res)
        }
    }


    // region 单节点连续操作(各种找 父节点 子节点,输入,粘贴刷新,是否有效) (未实现)

    // endregion

    // endregion

    // region 系统按键接口
    /**
     * 按下 home 键
     */
    fun home(): Boolean {
        return getDataBoolInJsonByTypeTemplate("home")
    }

    /**
     * 按下 back 键
     */
    fun back(): Boolean {
        return getDataBoolInJsonByTypeTemplate("back")
    }

    /**
     * 打开通知栏
     * @return 布尔型 true 代表保存，false代表不保存
     */
    fun openNotification(): Boolean {
        return getDataBoolInJsonByTypeTemplate("openNotification")

    }

    /**
     * 打开快速设置
     * @return 布尔型 true 代表保存，false代表不保存
     */
    fun openQuickSettings(): Boolean {
        return getDataBoolInJsonByTypeTemplate("openQuickSettings")

    }

    /**
     * 最近APP任务按键
     * @return 布尔型 true 代表保存，false代表不保存
     */
    fun recentApps(): Boolean {
        return getDataBoolInJsonByTypeTemplate("recentApps")

    }

    /**
     * 取得当前运行的App包名
     */
    fun getRunningPkg(): String {
        return getDataStringInJsonByTypeTemplate("getRunningPkg")
    }

    /**
     * 取得当前运行的Activity类名
     */
    fun getRunningActivity(): String {
        return getDataStringInJsonByTypeTemplate("getRunningActivity")
    }
    // endregion

    // region 通知栏接口(未实现)

    // endregion

    // region 悬浮窗接口(未实现)

    // endregion


    // region 自己的帮助类

    /**
     * 点击文字
     */
    fun clickText(text: String): Boolean {
        return clickTemplate(NodeEnum.text, text)
    }

    fun clickDesc(desc: String): Boolean {
        return clickTemplate(NodeEnum.desc, desc)
    }

    fun clickTextOrDesc(data: String): Boolean {
        var res = clickText(data)
        if (!res) {
            res = clickDesc(data)
        }
        return res
    }

    fun <T> clickTemplate(nodeEnum: NodeEnum, data: T): Boolean {

        val res = getOneNodeInfo(nodeEnum, data)
        if (res.isSuccess) {
            if (res.data != null) {
                val centerVisibleBounds = getCenterVisibleBounds(res.data!!)

                return clickPoint(centerVisibleBounds.x, centerVisibleBounds.y)
            }
        }
        return false
    }

    private fun getCenterVisibleBounds(nodeInfo: NodeInfo): CenterVisibleBounds {

        val bounds = nodeInfo.visibleBounds

        val x = bounds.left + (bounds.right - bounds.left) / 2
        val y = bounds.top + (bounds.bottom - bounds.top) / 2
        return CenterVisibleBounds(x, y)
    }
    // endregion


    // region 获取 json
    fun getDataStringInJsonByTypeTemplate(typeStr: String): String {

        val res = EcHelper.getDataStringInJsonByTypeTemplate(globalUrl,typeStr)
        Log.d(TAG, "$typeStr: $res")
        return res
    }

    fun getDataBoolInJsonByMsgTemplate(typeStr: String, msg: String): Boolean {
        val res = EcHelper.getDataBoolInJsonByMsgTemplate(globalUrl,typeStr,msg)
        Log.d(TAG, "$typeStr: $res")
        return res
    }

    fun getDataBoolInJsonByTypeTemplate(typeStr: String): Boolean {
        val res = EcHelper.getDataBoolInJsonByTypeTemplate(globalUrl,typeStr)
        Log.d(TAG, "$typeStr: $res")
        return res
    }
    // endregion
    private fun post(json: String): String {
        return EcHelper.post(globalUrl, json)
    }
}