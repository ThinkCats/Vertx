package com.tt.vertx.router

import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.ext.web.templ.ThymeleafTemplateEngine

/**
 * Created by wl on 16/7/26.
 */
fun renderPage(r: Router) {
    val engine = ThymeleafTemplateEngine.create()
    r.route("/static/*").handler(StaticHandler.create("static").setCachingEnabled(false))
    r.get("/index.html").handler({ c ->
        c.put("welcome", "hello world,page")
        engine.render(c, "templates/index.html", { res ->
            if (res.succeeded()) {
                c.response().end(res.result())
            } else {
                c.fail(res.cause())
            }
        })
    })
}