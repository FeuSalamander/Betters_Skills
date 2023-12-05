package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class MTIhaste1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double xp = 0;
		if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("g")) {
			return "\u00A76Grant haste 1 when mining rocks \u00A7aUnlocked";
		} else {
			return "\u00A76Grant haste 1 when mining rocks, \u00A7ccost 2 points";
		}
	}
}
