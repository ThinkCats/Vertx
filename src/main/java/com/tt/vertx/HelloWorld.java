package com.tt.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

import java.io.Serializable;

/**
 * Created by wl on 16/7/11.
 */
public class HelloWorld extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new HelloWorld());
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route("/").handler(c -> c.response().putHeader("content-type","text/html").end("hello world"));
        router.route("/json").handler(c ->
            c.response().putHeader("content-type","application/json; charset=utf-8")
                    .end(Json.encodePrettily(new Entity("hello","world")))
        );
        System.out.println("Server Running On 8888");
        vertx.createHttpServer().requestHandler(router::accept).listen(8888);
    }
}

class Entity implements Serializable{
    private String id;
    private String msg;

    public Entity(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
