package com.tt.vertx.service

/**
 * Created by wl on 16/7/25.
 */
interface IFileOprate {
    fun createFile(fileName:String)
    fun writeContent(fileName:String, content:String)
}