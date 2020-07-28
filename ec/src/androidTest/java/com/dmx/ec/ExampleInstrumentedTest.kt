package com.dmx.ec

import android.nfc.Tag
import android.util.Log
import android.widget.Toast
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dmx.ec.enum.NodeEnum

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    var TAG = this::class.java.simpleName

    // region 日志接口
    @Test
    fun logTest() {
        assertEquals(true, EcHelper.logd("测试d"))
    }

    @Test
    fun setSaveLogTest() {
        assertEquals("/storage/emulated/0/logger", EcHelper.setSaveLog())
    }

    // endregion

    // region  节点服务接口

    @Test
    fun exitTest() {
        assertEquals(true, EcHelper.exit())
    }

    @Test
    fun openECSystemSettingTest() {
        assertEquals(true, EcHelper.openECSystemSetting())
    }

    @Test
    fun isAccMode() {
        assertEquals(true, EcHelper.isAccMode())
    }

    @Test
    fun isAccServiceOk() {
        assertEquals(true, EcHelper.isAccServiceOk())
    }

    @Test
    fun isAgentMode() {
        assertEquals(true, EcHelper.isAgentMode())
    }

    @Test
    fun isAgentServiceOk() {
        assertEquals(true, EcHelper.isAgentServiceOk())
    }

    @Test
    fun isServiceOk() {
        assertEquals(true, EcHelper.isServiceOk())
    }

    @Test
    fun startEnv() {
        assertEquals(true, EcHelper.startEnv())
    }

    @Test
    fun setECSystemSetting() {
        // assertEquals(true, EcHelper.setECSystemSetting())
    }

    // endregion

    // region 点击动作接口
    @Test
    fun clickPoint() {
        assertEquals(true, EcHelper.clickPoint(1, 1))
    }

    @Test
    fun longClickPoint() {
        assertEquals(true, EcHelper.longClickPoint(1, 1))
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
        assertEquals(true, EcHelper.swipeToPoint(282, 595, 100, 100, 1500))
    }

    @Test
    fun isScrollEnd() {
        // assertEquals(true, EcHelper.multiTouch())
    }
    // endregion

    // region 拖动动作接口

    @Test
    fun drag() {
        assertEquals(true, EcHelper.drag(282, 595, 100, 100, 1500))
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
         assertEquals(true, EcHelper.currentIsOurIme())
    }

    @Test
    fun inputText() {
         assertEquals(true, EcHelper.inputText(NodeEnum.text,"写评论...","哈哈哈"))
    }

    @Test
    fun imeInputText() {
        assertEquals(true, EcHelper.imeInputText(NodeEnum.text,"写评论...","哈哈哈"))
    }

    @Test
    fun pasteText() {
        assertEquals(true, EcHelper.pasteText(NodeEnum.text,"写评论...","[cp]@奶汁樱桃配洋芋球: 哇啊啊啊啊我也要买！[/cp]"))
    }

    @Test
    fun clearTextField() {
        assertEquals(true, EcHelper.clearTextField(NodeEnum.text,"哈哈哈"))
    }

    // endregion

    // region 节点操作接口
    @Test
    fun has() {
        assertEquals(true, EcHelper.has(NodeEnum.text,"Auto.js"))
    }

    @Test
    fun waitExistActivity() {

        assertEquals(true, EcHelper.waitExistActivity(EcHelper.getRunningActivity(),2000))
    }

    @Test
    fun waitExistNode() {

        assertEquals(true, EcHelper.waitExistNode(NodeEnum.text,"登陆"))
    }

    @Test
    fun getNodeInfo() {

        assertEquals(true, EcHelper.getNodeInfo(NodeEnum.text,"登陆").isSuccess)
    }

    @Test
    fun getOneNodeInfo() {

        assertEquals(true, EcHelper.getOneNodeInfo(NodeEnum.text,"登陆").isSuccess)
    }

    // region 单节点连续操作(各种找 父节点 子节点,输入,粘贴刷新,是否有效) (未实现)

    // endregion


    // endregion

    // region 系统按键接口
    @Test
    fun home() {

        assertEquals(true, EcHelper.home())
    }

    @Test
    fun back() {

        assertEquals(true, EcHelper.back())
    }

    @Test
    fun openNotification() {

        assertEquals(true, EcHelper.openNotification())
    }

    @Test
    fun openQuickSettings() {

        assertEquals(true, EcHelper.openQuickSettings())
    }

    @Test
    fun recentApps() {

        assertEquals(true, EcHelper.recentApps())
    }

    @Test
    fun getRunningPkg() {

        assertEquals("com.android.systemui", EcHelper.getRunningPkg())
    }

    @Test
    fun getRunningActivity() {

        assertEquals("com.android.launcher3.Launcher", EcHelper.getRunningActivity())
    }


    // endregion

    // region 通知栏接口(未实现)

    // endregion

    // region 悬浮窗接口(未实现)

    // endregion

}