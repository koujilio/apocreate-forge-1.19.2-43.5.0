package co.apocreate.synergize.koujistery.Enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class EverlastingEnchantment extends Enchantment {
    public EverlastingEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
        super(rarity, category, slots);
    }

    @Override
    public boolean canEnchant(@NotNull ItemStack stack) {
        return true; // can enchant any tool
    }

    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }
}

