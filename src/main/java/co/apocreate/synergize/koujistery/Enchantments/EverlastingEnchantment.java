package co.apocreate.synergize.koujistery.Enchantments;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.*;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

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
        return 9;
    }


}

