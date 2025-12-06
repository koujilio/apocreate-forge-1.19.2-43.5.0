package co.apocreate.synergize.koujistery.GEvents;

import co.apocreate.synergize.koujistery.Methods.DevingMethod;
import co.apocreate.synergize.koujistery.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.html.HTML;

import static co.apocreate.synergize.koujistery.ApoCreate.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class OnPlayerInteractions {

    @SubscribeEvent
    public static void OnRightClicksBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        ItemStack held =player.getMainHandItem();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        BlockEntity be = level.getBlockEntity(pos);


        if (!level.isClientSide()){
            if (state.getBlock() == Blocks.GLASS && held.getItem() == Items.SHEARS){
                level.setBlock(pos,state,3);
            }
            if (state.getBlock() == Blocks.CAMPFIRE && ForgeHooks.getBurnTime(held, RecipeType.SMELTING) > 0){
                held.setCount(held.getCount()-1);

                assert be != null;
                be.getPersistentData().putInt("burntime",be.getPersistentData().getInt("burntime") + ForgeHooks.getBurnTime(held,RecipeType.SMELTING));
                be.setChanged();
                DevingMethod.smsg(player,be.getPersistentData().getInt("burntime")+"burntime tick");
                if (be.getPersistentData().getInt("burntime")<0){
                    level.setBlockAndUpdate(pos,state.setValue(CampfireBlock.LIT,false));
                }
            }

        }


        if (level.isClientSide) return;
        if (state.getBlock() != Blocks.GLASS) return;
        if (player.getMainHandItem().getItem() != Items.SHEARS) return;

        // Replace vanilla glass with your surrier block
        level.setBlock(pos, ModBlocks.surrier.get().defaultBlockState(), 3);

        // Damage shears + sound
        player.getMainHandItem().hurtAndBreak(1, player, p -> p.broadcastBreakEvent(InteractionHand.MAIN_HAND));
        level.playSound(null, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);

        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true); // stops hand swing glitch
    }
}