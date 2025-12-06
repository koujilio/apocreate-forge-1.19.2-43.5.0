package co.apocreate.synergize.koujistery.GEvents;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static co.apocreate.synergize.koujistery.ApoCreate.MODID;




@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLevelTick {

    @SubscribeEvent
    public static void LevelTick(TickEvent.LevelTickEvent event) {

    }

}