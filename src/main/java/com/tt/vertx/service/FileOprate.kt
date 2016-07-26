package com.tt.vertx.service

import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer

/**
 * Created by wl on 16/7/25.
 */
class FileOprate : IFileOprate{
    override fun writeContent(fileName: String, content: String) {
        var data =  Buffer.buffer(content)
        Companion.fs.writeFile(fileName,data,{ handler ->
            if(handler.succeeded()){
                println("success")
            }else{
                println("hehehe")
            }
        })
    }

    override fun createFile(fileName: String) {
        Companion.fs.createFile(fileName,{ handler ->
            if(handler.succeeded()){
                println("success create file")
            }else{
                println("hehe, create fail")
            }
        })
    }

    companion object {
        val fs = Vertx.vertx().fileSystem()
    }
}