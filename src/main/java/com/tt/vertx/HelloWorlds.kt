package com.tt.vertx

import com.tt.vertx.router.customRouter
import com.tt.vertx.router.renderPage
import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx

/**
 * Created by wl on 16/7/22.
 */
class HelloWorlds : AbstractVerticle() {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            Vertx.vertx().deployVerticle(HelloWorlds())
        }
    }

    override fun start() {
        var router = customRouter(vertx)
        renderPage(router)
        println("server running on 8888")
        vertx.createHttpServer().requestHandler({ handler -> router.accept(handler) }).listen(8888)
    }
}