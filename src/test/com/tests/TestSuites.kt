package com.tests

import com.tt.vertx.service.FileOprate
import com.tt.vertx.service.IFileOprate
import io.vertx.core.cli.Argument
import io.vertx.core.cli.CLI
import io.vertx.core.cli.Option
import org.junit.Test

/**
 * Created by wl on 16/7/25.
 */

class TestSuites() {
    private val fileOp:IFileOprate = FileOprate()
    private var path = "/Users/dasouche/hehe.txt"

    @Test
    fun test_create_file(){
        fileOp.createFile(path)
    }

    @Test
    fun test_write_content(){
        fileOp.writeContent(path,"Hello World..")
    }

    @Test
    fun test_cmd_generate(){
        val  cli = CLI.create("copy")
                .setSummary("A command line interface to copy files.")
                .addOption(Option()
                        .setLongName("directory")
                        .setShortName("R")
                        .setDescription("enables directory support")
                        .setFlag(true))
                .addArgument(Argument()
                        .setIndex(0)
                        .setDescription("The source")
                        .setArgName("source"))
                .addArgument(Argument()
                        .setIndex(0)
                        .setDescription("The destination")
                        .setArgName("target"));

        var  builder = StringBuilder();
        cli.usage(builder);
        println("usage:"+builder.toString())
    }

}

