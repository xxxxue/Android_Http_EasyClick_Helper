package com.dmx.ec

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dmx.ec.enum.NodeEnum

import org.junit.Test
import org.junit.runner.RunWith

import com.dmx.ec.EcWrapper.Companion.globalApi
import org.junit.Assert.*
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    var TAG = this::class.java.simpleName

    // region 日志接口
    @Test
    fun logTest() {
        assertEquals(true, globalApi.logd("测试d"))
    }

    @Test
    fun setSaveLogTest() {
        assertEquals("/storage/emulated/0/logger", globalApi.setSaveLog())
    }

    // endregion

    // region  节点服务接口

    @Test
    fun exitTest() {
        assertEquals(true, globalApi.exit())
    }

    @Test
    fun openECSystemSettingTest() {
        assertEquals(true, globalApi.openECSystemSetting())
    }

    @Test
    fun isAccMode() {
        assertEquals(true, globalApi.isAccMode())
    }

    @Test
    fun isAccServiceOk() {
        assertEquals(true, globalApi.isAccServiceOk())
    }

    @Test
    fun isAgentMode() {
        assertEquals(true, globalApi.isAgentMode())
    }

    @Test
    fun isAgentServiceOk() {
        assertEquals(true, globalApi.isAgentServiceOk())
    }

    @Test
    fun isServiceOk() {
        assertEquals(true, globalApi.isServiceOk())
    }

    @Test
    fun startEnv() {
        assertEquals(true, globalApi.startEnv())
    }

    @Test
    fun setECSystemSetting() {
        // assertEquals(true, EcHelper.setECSystemSetting())
    }

    // endregion

    // region 点击动作接口
    @Test
    fun clickPoint() {
        assertEquals(true, globalApi.clickPoint(1, 1))
    }

    @Test
    fun longClickPoint() {
        assertEquals(true, globalApi.longClickPoint(1, 1))
    }

    @Test
    fun click() {
        // assertEquals(true, EcHelper.click())
    }

    @Test
    fun longClick() {
        // assertEquals(true, EcHelper.longClick())
    }
    // endregion

    // region 多点触摸动作接口

    @Test
    fun multiTouch() {
        // assertEquals(true, EcHelper.multiTouch())
    }
    // endregion

    // region 滑动动作接口

    @Test
    fun swipe() {
        // assertEquals(true, EcHelper.multiTouch())
    }

    @Test
    fun swipeToPoint() {
        assertEquals(true, globalApi.swipeToPoint(282, 595, 100, 100, 1500))
    }

    @Test
    fun isScrollEnd() {
        // assertEquals(true, EcHelper.multiTouch())
    }
    // endregion

    // region 拖动动作接口

    @Test
    fun drag() {
        assertEquals(true, globalApi.drag(282, 595, 100, 100, 1500))
    }

    @Test
    fun dragTo() {
        // assertEquals(true, EcHelper.dragTo())
    }

    @Test
    fun dragToPoint() {
        // assertEquals(true, EcHelper.dragToPoint())
    }


    // endregion

    // region 输入动作接口

    @Test
    fun currentIsOurIme() {
         assertEquals(true, globalApi.currentIsOurIme())
    }

    @Test
    fun inputText() {
         assertEquals(true, globalApi.inputText(NodeEnum.text,"写评论...","哈哈哈"))
    }

    @Test
    fun imeInputText() {
        assertEquals(true, globalApi.imeInputText(NodeEnum.text,"写评论...","哈哈哈"))
    }

    @Test
    fun pasteText() {
        assertEquals(true, globalApi.pasteText(NodeEnum.text,"写评论...","[cp]@奶汁樱桃配洋芋球: 哇啊啊啊啊我也要买！[/cp]"))
    }

    @Test
    fun clearTextField() {
        assertEquals(true, globalApi.clearTextField(NodeEnum.text,"哈哈哈"))
    }

    // endregion

    // region 节点操作接口
    @Test
    fun has() {
        assertEquals(true, globalApi.has(NodeEnum.text,"Auto.js"))
    }

    @Test
    fun waitExistActivity() {

        assertEquals(true, globalApi.waitExistActivity(globalApi.getRunningActivity(),2000))
    }

    @Test
    fun waitExistNode() {

        assertEquals(true, globalApi.waitExistNode(NodeEnum.text,"登陆"))
    }

    @Test
    fun getNodeInfo() {

        assertEquals(true, globalApi.getNodeInfo(NodeEnum.text,"登陆").isSuccess)
    }

    @Test
    fun getOneNodeInfo() {

        assertEquals(true, globalApi.getOneNodeInfo(NodeEnum.text,"登陆").isSuccess)
    }

    // region 单节点连续操作(各种找 父节点 子节点,输入,粘贴刷新,是否有效) (未实现)

    // endregion


    // endregion

    // region 系统按键接口
    @Test
    fun home() {

        assertEquals(true, globalApi.home())
    }

    @Test
    fun back() {

        assertEquals(true, globalApi.back())
    }

    @Test
    fun openNotification() {

        assertEquals(true, globalApi.openNotification())
    }

    @Test
    fun openQuickSettings() {

        assertEquals(true, globalApi.openQuickSettings())
    }

    @Test
    fun recentApps() {

        assertEquals(true, globalApi.recentApps())
    }

    @Test
    fun getRunningPkg() {

        assertEquals("com.android.systemui", globalApi.getRunningPkg())
    }

    @Test
    fun getRunningActivity() {
        assertEquals("com.android.launcher3.Launcher", globalApi.getRunningActivity())
    }


    // endregion

    // region 通知栏接口(未实现)

    // endregion

    // region 悬浮窗接口(未实现)

    // endregion

}