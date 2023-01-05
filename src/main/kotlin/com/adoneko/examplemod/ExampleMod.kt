package com.adoneko.examplemod

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

class ExampleMod : ModInitializer {
    val LOGGER = LoggerFactory.getLogger("example")

    override fun onInitialize() {
        LOGGER.info("Hello Reisa!")
    }
}