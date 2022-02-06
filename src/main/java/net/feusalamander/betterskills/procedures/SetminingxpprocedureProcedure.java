package net.feusalamander.betterskills.procedures;

import net.minecraft.entity.Entity;

import net.feusalamander.betterskills.BetterSkillsModVariables;
import net.feusalamander.betterskills.BetterSkillsMod;

import java.util.Map;
import java.util.HashMap;

public class SetminingxpprocedureProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency entity for procedure Setminingxpprocedure!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency cmdparams for procedure Setminingxpprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText());
			entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MiningXP = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
