package example.examplemod.block

import example.examplemod.ExampleMod
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraftforge.registries.ForgeRegistries
import thedarkcolour.kotlinforforge.forge.KDeferredRegister

object ModBlocks {
    // use of the new KDeferredRegister
    val REGISTRY = KDeferredRegister(ForgeRegistries.BLOCKS, ExampleMod.ID)

    // the returned ObjectHolderDelegate can be used as a property delegate
    // this is automatically registered by the deferred registry at the correct times
    val EXAMPLE_BLOCK by REGISTRY.registerObject("example_block") {
        Block(AbstractBlock.Properties.of(Material.BAMBOO).lightLevel() { 15 }.strength(3.0f))
    }
}