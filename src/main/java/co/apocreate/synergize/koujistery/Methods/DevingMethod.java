package co.apocreate.synergize.koujistery.Methods;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class DevingMethod {

    public static void smsg(Player player, String message){
        if (!player.level.isClientSide && player.getDisplayName().getString().equals("Dev")){
            player.sendSystemMessage(Component.literal(String.valueOf("Debug : " + message)));
        }
    }

    public static void dcmsg(Player player, String message){
        if (!player.level.isClientSide && player.getDisplayName().getString().equals("Dev")){
            player.displayClientMessage(Component.literal(String.valueOf("Debug : " + message)),true);
        }
    }



}
