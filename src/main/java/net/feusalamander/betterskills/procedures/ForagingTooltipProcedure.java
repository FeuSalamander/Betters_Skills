package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class ForagingTooltipProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double xp = 0;
		if (xp == 20) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP;
		} else if (xp == 19) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 522425;
		} else if (xp == 18) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 322425;
		} else if (xp == 17) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 222425;
		} else if (xp == 16) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 147425;
		} else if (xp == 15) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 97425;
		} else if (xp == 14) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 67425;
		} else if (xp == 13) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 47425;
		} else if (xp == 12) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 32425;
		} else if (xp == 11) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 22425;
		} else if (xp == 10) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 14925;
		} else if (xp == 9) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 9925;
		} else if (xp == 8) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 6425;
		} else if (xp == 7) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 4425;
		} else if (xp == 6) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 2925;
		} else if (xp == 5) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 1925;
		} else if (xp == 4) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 1175;
		} else if (xp == 3) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 675;
		} else if (xp == 2) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 375;
		} else if (xp == 1) {
			return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 175;
		}
		return "\u00A72" + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + "/" + 50;
	}
}
