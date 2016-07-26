package com.tt.vertx.service

import io.vertx.core.cli.CLI
import io.vertx.core.cli.Option

/**
 * Created by wl on 16/7/25.
 */
class Command :ICommand {
    override fun exec(cmd: String) {
        val cli = CLI.create("hehe")
        cli.addOption(Option())
    }
}