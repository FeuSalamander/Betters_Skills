package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class XptypeProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).xptype;
	}
}
