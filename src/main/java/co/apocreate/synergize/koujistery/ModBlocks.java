package co.apocreate.synergize.koujistery;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import co.apocreate.synergize.koujistery.Blocks.*;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ApoCreate.MODID);


    public static final RegistryObject<Block> ceh = BLOCKS.register("ceh", ceh::new);
    public static final RegistryObject<Block> surrier = BLOCKS.register("surrier", surrier::new);

}


