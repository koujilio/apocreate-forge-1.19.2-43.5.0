package co.apocreate.synergize.koujistery.GEvents;


import co.apocreate.synergize.koujistery.ApoCreate;
import co.apocreate.synergize.koujistery.Methods.DevingMethod;
import co.apocreate.synergize.koujistery.Methods.DurabilityPointsMethod;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import static co.apocreate.synergize.koujistery.ApoCreate.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAnvilUpdate {

    @SubscribeEvent
    public static void AnvilUpdate(AnvilUpdateEvent event) {
        ItemStack output = event.getOutput();
        ItemStack input = event.getLeft();
        ItemStack material = event.getRight();
        int InitCost = input.getBaseRepairCost();

        if (material.getItem().equals(Items.AIR)) {

            input.setRepairCost(0);
        }else {
            DurabilityPointsMethod.DynamicBaseCostSet(input);
        }


    }
}