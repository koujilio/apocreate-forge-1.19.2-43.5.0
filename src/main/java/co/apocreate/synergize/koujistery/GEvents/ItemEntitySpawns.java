package co.apocreate.synergize.koujistery.GEvents;


import co.apocreate.synergize.koujistery.Methods.DurabilityPointsMethod;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static co.apocreate.synergize.koujistery.ApoCreate.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemEntitySpawns {

    @SubscribeEvent
    public static void onEntitySpawn(EntityJoinLevelEvent event) {
        // Check if the entity is an ItemEntity
        if (event.getEntity() instanceof ItemEntity) {
            ItemEntity itemEntity;
            itemEntity = (ItemEntity) event.getEntity();
            ItemStack droppie = itemEntity.getItem();

            if (droppie.isDamageableItem()){

                DurabilityPointsMethod.IncrementTRDP(droppie, 300);
                DurabilityPointsMethod.DynamicBaseCostSet(droppie);
            }
        }
    }
}