package net.feusalamander.betterskills.procedures;

import net.minecraft.entity.Entity;

import net.feusalamander.betterskills.BetterSkillsModVariables;
import net.feusalamander.betterskills.BetterSkillsMod;

import java.util.Map;
import java.util.HashMap;

public class AddfarmingProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency entity for procedure Addfarming!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency cmdparams for procedure Addfarming!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		{
			double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BetterSkillsModVariables.PlayerVariables())).FarmingXP + new Object() {
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
					}.getText()));
			entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FarmingXP = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
