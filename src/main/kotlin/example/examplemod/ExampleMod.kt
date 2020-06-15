package example.examplemod

import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(ExampleMod.ID)
object ExampleMod {
    const val ID: String = "examplemod"
    val LOGGER: Logger = LogManager.getLogger()

    init {
        LOGGER.log(Level.INFO, "Hello world!")
    }
}