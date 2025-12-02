package co.apocreate.synergize.koujistery.GEvents;


import co.apocreate.synergize.koujistery.Enchantments.EverlastingEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import static co.apocreate.synergize.koujistery.ApoCreate.ENCHANTMENTS;
import static co.apocreate.synergize.koujistery.ApoCreate.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnvilUse {

    private static Enchantment EverlastingEnchantment;

    @SubscribeEvent
    public static void onAnvilRepair(AnvilRepairEvent event) {
        Player player = event.getEntity();
        ItemStack output = event.getOutput();
        ItemStack input = event.getLeft();
        ItemStack material = event.getRight();
        int RecoveredDP = input.getDamageValue()-output.getDamageValue();


        if (player.level.isClientSide){
            player.sendSystemMessage(Component.literal("Anvil processed " + output.getHoverName().getString() + " which has " + output.getDamageValue() + "dp damagedness left ."));
            player.sendSystemMessage(Component.literal(RecoveredDP + "DurabilityPoints recovered."));
            player.sendSystemMessage(Component.literal(material.getDisplayName().getString()));
        }else {
            int TotalRDP = output.getOrCreateTag().getInt("RecoveredDP");
            output.setRepairCost(10-TotalRDP/100);
            output.getOrCreateTag().putInt("RecoveredDP", RecoveredDP + TotalRDP);
            player.sendSystemMessage(Component.literal(RecoveredDP+TotalRDP + ""));

            if (TotalRDP >= 10){
                player.displayClientMessage(Component.literal("This item has become Everlasting"),true);
                output.enchant(EverlastingEnchantment,1);
            }
        }
    }
}