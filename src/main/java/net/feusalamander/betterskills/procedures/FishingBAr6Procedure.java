package net.feusalamander.betterskills.procedures;

import org.checkerframework.checker.units.qual.min;

import net.minecraft.world.entity.Entity;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

public class FishingBAr6Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double min = 0;
		double max = 0;
		double XP = 0;
		double Lvl = 0;
		min = 0.6;
		max = 0.8;
		XP = (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FishingXP;
		Lvl = (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FishingLvL;
		if (Lvl == 0) {
			if (XP / 50 > min && XP / 50 < max) {
				return true;
			}
		} else if (Lvl == 1) {
			if (XP / 175 > min && XP / 175 < max) {
				return true;
			}
		} else if (Lvl == 2) {
			if (XP / 375 > min && XP / 375 < max) {
				return true;
			}
		} else if (Lvl == 3) {
			if (XP / 675 > min && XP / 675 < max) {
				return true;
			}
		} else if (Lvl == 4) {
			if (XP / 1175 > min && XP / 1175 < max) {
				return true;
			}
		} else if (Lvl == 5) {
			if (XP / 1925 > min && XP / 1925 < max) {
				return true;
			}
		} else if (Lvl == 6) {
			if (XP / 2925 > min && XP / 2925 < max) {
				return true;
			}
		} else if (Lvl == 7) {
			if (XP / 4425 > min && XP / 4425 < max) {
				return true;
			}
		} else if (Lvl == 8) {
			if (XP / 6425 > min && XP / 6425 < max) {
				return true;
			}
		} else if (Lvl == 9) {
			if (XP / 9925 > min && XP / 9925 < max) {
				return true;
			}
		} else if (Lvl == 10) {
			if (XP / 14925 > min && XP / 14925 < max) {
				return true;
			}
		} else if (Lvl == 11) {
			if (XP / 22425 > min && XP / 22425 < max) {
				return true;
			}
		} else if (Lvl == 12) {
			if (XP / 32425 > min && XP / 32425 < max) {
				return true;
			}
		} else if (Lvl == 13) {
			if (XP / 47425 > min && XP / 47425 < max) {
				return true;
			}
		} else if (Lvl == 14) {
			if (XP / 67425 > min && XP / 67425 < max) {
				return true;
			}
		} else if (Lvl == 15) {
			if (XP / 97425 > min && XP / 97425 < max) {
				return true;
			}
		} else if (Lvl == 16) {
			if (XP / 147425 > min && XP / 147425 < max) {
				return true;
			}
		} else if (Lvl == 17) {
			if (XP / 222425 > min && XP / 222425 < max) {
				return true;
			}
		} else if (Lvl == 18) {
			if (XP / 322425 > min && XP / 322425 < max) {
				return true;
			}
		} else if (Lvl == 19) {
			if (XP / 522425 > min && XP / 522425 < max) {
				return true;
			}
		} else if (Lvl == 20) {
			return false;
		}
		return false;
	}
}
