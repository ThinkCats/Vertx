package com.tt.vertx.router

import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.ext.web.templ.ThymeleafTemplateEngine
import org.thymeleaf.templatemode.TemplateMode

/**
 * Created by wl on 16/7/26.
 */
fun renderPage(r: Router) {
    val engine = ThymeleafTemplateEngine.create().setMode(TemplateMode.HTML)
    r.route("/static/*").handler(StaticHandler.create("static").setCachingEnabled(false))
    r.get("/index.html").handler({ c ->
        c.put("welcome", "hello world,page !!??!!")
        render(c,engine,"templates/index.html")
    })
}

fun render(c: RoutingContext, engine: ThymeleafTemplateEngine, templ:String){
    engine.render(c,templ,{res->
        if (res.succeeded()) {
            c.response().end(res.result())
        } else {
            c.fail(res.cause())
        }
    })
}