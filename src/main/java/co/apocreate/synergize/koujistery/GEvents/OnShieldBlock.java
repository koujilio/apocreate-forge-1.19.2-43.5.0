package co.apocreate.synergize.koujistery.GEvents;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static co.apocreate.synergize.koujistery.ApoCreate.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnShieldBlock {

    @SubscribeEvent
    public static void rightclick(ShieldBlockEvent event) {
        Entity defender = event.getEntity();
        DamageSource source = event.getDamageSource();
        Entity attacker = source.getEntity();
        attacker.hurt(DamageSource.MAGIC,event.getBlockedDamage());
    }
}