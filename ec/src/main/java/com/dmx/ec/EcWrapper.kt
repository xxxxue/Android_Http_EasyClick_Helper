package com.dmx.ec

import com.dmx.ec.api.AgentEventApi
import com.dmx.ec.api.GlobalApi
import com.dmx.ec.api.ShellApi

/**
 * EC 包装类
 */
class EcWrapper {
    companion object {
        val globalApi = GlobalApi()
        val agentEventApi = AgentEventApi()
        val shellApi = ShellApi()
    }
}