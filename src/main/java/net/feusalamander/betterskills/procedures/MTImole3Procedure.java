package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class MTImole3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double xp = 0;
		if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("u")) {
			return "\u00A76Break 5 adjacent stone/deepslate \u00A7aUnlocked";
		} else {
			return "\u00A76Grant haste 6 when mining rocks, \u00A7ccost 5 points";
		}
	}
}
