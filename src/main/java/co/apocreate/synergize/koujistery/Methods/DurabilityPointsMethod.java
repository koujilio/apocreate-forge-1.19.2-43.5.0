package co.apocreate.synergize.koujistery.Methods;

import net.minecraft.world.item.ItemStack;

public class DurabilityPointsMethod {
    public static int GetRDP(ItemStack item){
        return item.getOrCreateTag().getInt("RecoveredDP");
    }

    public static void DynamicBaseCostSet(ItemStack item){
        item.setRepairCost (10-GetRDP(item)/100);
        if (item.getBaseRepairCost() <= 0){
            item.setRepairCost(1);
        }
    }

    public static void IncrementTRDP(ItemStack item, int RecoveredDP){

        item.getOrCreateTag().putInt("RecoveredDP", RecoveredDP + GetRDP(item)); //increment recovery

    }


}
