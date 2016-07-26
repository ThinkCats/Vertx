@file:JvmName("ResponseUtil")
package com.tt.vertx.router

import com.tt.vertx.bean.Entity
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.Json
import io.vertx.ext.web.Router

/**
 * Created by wl on 16/7/22.
 */

fun customRouter(v : Vertx) : Router {
    var router = Router.router(v)
    router.route("/hello").handler({c -> c.response().html().end("hello world")})
    router.route("/json").handler({c -> c.response().json().end(Json.encode(Entity("name","sss")))})
    return router
}

fun HttpServerResponse.html() : HttpServerResponse {
    return this.putHeader("content-type","text/html")
}

fun HttpServerResponse.json() : HttpServerResponse {
    return this.putHeader("content-type","application/json; charset=utf-8")
}
