package co.apocreate.synergize.koujistery;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ApoCreate.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ApoCreate.MODID);


    //* itemblocks then items here
    public static final RegistryObject<Item> ceh = ITEMS.register("ceh", () -> new BlockItem(ModBlocks.ceh.get(), new Item.Properties().tab(ApoCreate.ApoCreateTab)));

    public static final RegistryObject<Item> ID_CARD = ITEMS.register("id_card", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(1).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RAW_COPPER_COIN = ITEMS.register("raw_copper_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> RAW_IRON_COIN = ITEMS.register("raw_iron_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> RAW_ROLD_COIN = ITEMS.register("raw_rold_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> RAW_GOLD_COIN = ITEMS.register("raw_gold_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> ROSE_GOLD_NUGGET = ITEMS.register("rose_gold_nugget", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> IRON_COIN = ITEMS.register("iron_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ROLD_COIN = ITEMS.register("rold_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", () -> new Item(new Item.Properties().tab(ApoCreate.ApoCreateTab).stacksTo(16).rarity(Rarity.RARE)));


}


