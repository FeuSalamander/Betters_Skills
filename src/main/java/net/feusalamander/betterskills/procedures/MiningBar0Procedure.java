package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class MiningBar0Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 0) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 50 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 1) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 175 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 2) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 375 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 3) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 675 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 4) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 1175 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 5) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 1925 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 6) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 2925 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 7) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 4425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 8) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 6425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 9) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 9925 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 10) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 14925 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 11) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 22425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 12) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 32425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 13) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 47425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 14) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 67425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 15) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 97425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 16) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 147425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 17) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 222425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 18) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 322425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 19) {
			if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP / 522425 < 0.2) {
				return true;
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningLvL == 20) {
			return false;
		}
		return false;
	}
}
