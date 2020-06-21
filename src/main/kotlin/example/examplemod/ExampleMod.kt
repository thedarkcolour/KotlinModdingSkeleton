package example.examplemod

import example.examplemod.block.ExampleBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.util.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.objectHolder
import thedarkcolour.kotlinforforge.forge.runWhenOn

/**
 * Main mod class. Should be an `object` declaration annotated with `@Mod`.
 * The modid should be declared in this object and should match the modId entry
 * in mods.toml.
 */
@Mod(ExampleMod.ID)
object ExampleMod {
    // the modid of our mod
    const val ID: String = "examplemod"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger()

    /**
     * Example block using an `ObjectHolderDelegate`. The block's `registryName`
     * must correspond to a `Block` instance registered during the block registry event with the same registry name.
     *
     * @see registerBlocks
     */
    val EXAMPLE_BLOCK by objectHolder<ExampleBlock>(ResourceLocation(ID, "example_block"))

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        // usage of the KotlinEventBus
        MOD_BUS.addGenericListener(::registerBlocks)
        FORGE_BUS.addListener(::onServerAboutToStart)
    }

    /**
     * Register your mod's blocks during the
     * block registry event, fired on the mod bus.
     */
    private fun registerBlocks(event: RegistryEvent.Register<Block>) {
        // from Forge.kt
        // executing sided code safely
        runWhenOn(Dist.CLIENT) {
            LOGGER.log(Level.INFO, "Hello client side! I'm in block registry!")
        }

        // register our example block with registry name matching our object holder
        event.registry.register(Block(Block.Properties.create(Material.PLANTS)).setRegistryName("example_block"))
    }

    /**
     * Fired on the Forge bus.
     */
    private fun onServerAboutToStart(event: FMLServerAboutToStartEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}