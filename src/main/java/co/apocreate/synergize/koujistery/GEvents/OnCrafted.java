package co.apocreate.synergize.koujistery.GEvents;


import co.apocreate.synergize.koujistery.Methods.DevingMethod;
import co.apocreate.synergize.koujistery.Methods.DurabilityPointsMethod;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import static co.apocreate.synergize.koujistery.ApoCreate.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnCrafted {

    @SubscribeEvent
    public static void onAnvilRepair(PlayerEvent.ItemCraftedEvent event) {
        Player player = event.getEntity();
        ItemStack crafted = event.getCrafting();

        if (!player.level.isClientSide && crafted.isDamageableItem()){
            DurabilityPointsMethod.IncrementTRDP(crafted,300);
            DurabilityPointsMethod.DynamicBaseCostSet(crafted);
        }
    }
}