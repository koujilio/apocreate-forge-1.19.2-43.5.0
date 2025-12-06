package co.apocreate.synergize.koujistery.GEvents;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.apocreate.synergize.koujistery.ApoCreate.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnInventoryTick {

    private static final Logger log = LoggerFactory.getLogger(OnInventoryTick.class);
    @SubscribeEvent
    public static void handtick(LivingEvent.LivingTickEvent event) {
        LivingEntity living = event.getEntity();
        ItemStack held = event.getEntity().getMainHandItem();

        if (!living.level.isClientSide() && held.isDamageableItem() && held.getEnchantmentLevel(EVERLASTING.get()) != 0){//on server tool has everlasting
            int i = living.getPersistentData().getInt("i");
            if (i>20){
                i = 0;
                log.info("tick countreset");

                if (Math.random() < held.getEnchantmentLevel(EVERLASTING.get())/10.0){
                    held.setDamageValue(held.getDamageValue()-1);
                }
            }
            living.getPersistentData().putInt("i",i+1);
            log.info(i+"");
        }
    }
}