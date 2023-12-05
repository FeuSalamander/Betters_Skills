package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class PointsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Points: " + new java.text.DecimalFormat("##").format((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).points);
	}
}
