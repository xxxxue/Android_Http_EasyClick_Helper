package com.dmx.ec.model

/**
 * 节点信息
 */
data class NodeInfo(
    /**
     * 资源的ID
     */
    var id: String,
    /**
     * 视图类名，例如 android.widget.TextView
     */
    var clz: String,
    /**
     * 包名，例如com.tencent.mm
     */
    var pkg: String,
    /**
     * 内容描述
     */
    var desc: String,
    /**
     * 文本
     */
    var text: String,
    /**
     * 是否可选中
     */
    var checkable: Boolean,
    /**
     * 是否选中
     */
    var checked: Boolean,
    /**
     * 是否可点击
     */
    var clickable: Boolean,
    /**
     * 是否启用
     */
    var enabled: Boolean,
    /**
     * 是否可获取焦点
     */
    var focusable: Boolean,
    /**
     * 是否聚焦
     */
    var focused: Boolean,
    /**
     * 是否可长点击
     */
    var longClickable: Boolean,
    /**
     * 是否滚动
     */
    var scrollable: Boolean,
    /**
     * 是否被选择
     */
    var selected: Boolean,
    /**
     * 子节点的个数
     */
    var childCount: Int,
    /**
     * 节点的索引
     */
    var index: Int,
    /**
     * 节点的层级深度
     */
    var depth: Int,
    /**
     * 节点的绘制顺序
     */
    var drawingOrder: Int,

    /**
     * 空间对象
     */
    var bounds: Rect,
    /**
     * 可视空间对象
     */
    var visibleBounds: Rect


)

data class Rect(
    var top: Int,
    var bottom: Int,
    var left: Int,
    var right: Int
)


data class ResultNodeInfo(var isSuccess: Boolean, var data: NodeInfo?)
data class ResultNodeInfoList(var isSuccess: Boolean, var data: ArrayList<NodeInfo>?)
data class CenterVisibleBounds(var x: Int, var y: Int)

