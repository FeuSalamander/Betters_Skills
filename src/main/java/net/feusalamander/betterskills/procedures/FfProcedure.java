package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.feusalamander.betterskills.init.BetterskillsModItems;

public class FfProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (BetterskillsModItems.WATERINGCAN.get() == BetterskillsModItems.WATERINGCAN.get()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Message"), (false));
		}
	}
}
