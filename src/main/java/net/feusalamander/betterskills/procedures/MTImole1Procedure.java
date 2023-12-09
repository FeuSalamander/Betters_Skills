package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class MTImole1Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double xp = 0;
		if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("t")) {
			if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("m")) {
				return "\u00A76Break one adjacent stone/deepslate \u00A7aUnlocked Enabled";
			} else {
				return "\u00A76Break one adjacent stone/deepslate \u00A7aUnlocked \u00A7cDisabled";
			}
		} else {
			return "\u00A76Break one adjacent stone/deepslate, \u00A7ccost 2 points";
		}
	}
}
