package co.apocreate.synergize.koujistery;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ApoCreate.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ApoCreate.MODID);


    //* added blocks here
    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path

    //* added items here
    public static final RegistryObject<Item> Rubby = ITEMS.register("rubby", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(16).rarity(Rarity.UNCOMMON)));



    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    //public static final RegistryObject<Item> Rubby = ITEMS.register("test_item",() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));


}
