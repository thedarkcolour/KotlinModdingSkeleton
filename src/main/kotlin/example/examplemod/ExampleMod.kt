package example.examplemod

import net.minecraft.block.Block
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runWhenOn

@Mod(ExampleMod.ID)
object ExampleMod {
    const val ID: String = "examplemod"
    val LOGGER: Logger = LogManager.getLogger()

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        // usage of the KotlinEventBus
        MOD_BUS.addGenericListener(::onBlockRegistry)
        FORGE_BUS.addListener(::onServerAboutToStart)
    }

    private fun onBlockRegistry(event: RegistryEvent.Register<Block>) {
        // from Forge.kt
        runWhenOn(Dist.CLIENT) {
            LOGGER.log(Level.INFO, "Hello client side! I'm in block registry!")
        }
    }

    private fun onServerAboutToStart(event: FMLServerAboutToStartEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}