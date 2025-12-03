package co.apocreate.synergize.koujistery.GEvents;


import co.apocreate.synergize.koujistery.Methods.DevingMethod;
import co.apocreate.synergize.koujistery.Methods.DurabilityPointsMethod;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

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
        int CurRDP = input.getDamageValue()-output.getDamageValue();// currently repaired durability points


        if (!player.level.isClientSide && output.isDamageableItem()) {
            DevingMethod.smsg(player, "Anvil processed " + output.getHoverName().getString() + " which has " + output.getDamageValue() + "dp damagedness left .");
            DevingMethod.smsg(player, CurRDP + "DurabilityPoints recovered.");
            DevingMethod.smsg(player, (material.getDisplayName().getString()));

            DurabilityPointsMethod.DynamicBaseCostSet(output);
            DevingMethod.smsg(player, ("CurRDP : " + CurRDP + DurabilityPointsMethod.GetRDP(output)));

            if (DurabilityPointsMethod.GetRDP(output) >= 1000) {
                DevingMethod.dcmsg(player,"This item has become Everlasting");;
                output.enchant(EverlastingEnchantment, 1);
                output.setHoverName(Component.literal("Everlasting " + output.getHoverName().getString()));
            }
        }
    }
}