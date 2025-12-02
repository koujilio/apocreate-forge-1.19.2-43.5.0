package co.apocreate.synergize.koujistery.Blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class surrier extends Block {

    public surrier() {
        super(Properties.copy(Blocks.GLASS).strength(0.1f));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (hand == InteractionHand.MAIN_HAND && !level.isClientSide){
            if (player.getMainHandItem().equals(new ItemStack(Items.SHEARS))){
                player.sendSystemMessage(Component.literal(player.getMainHandItem().getDisplayName().getString()));
                //replace glass with modblocks.surrierblock
            }

        }

        return super.use(state, level, pos, player, hand, hitResult);
    }
}