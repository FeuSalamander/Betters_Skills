package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class MThaste3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double xp = 0;
		if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("j")) {
			return true;
		} else {
			return false;
		}
	}
}
