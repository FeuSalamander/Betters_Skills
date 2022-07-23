package net.feusalamander.betterskills.procedures;

import net.minecraft.entity.Entity;

import net.feusalamander.betterskills.BetterskillsModVariables;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.Map;

public class MoletoggleProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency entity for procedure Moletoggle!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).mole == true) {
			{
				boolean _setval = (false);
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mole = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).mole == false) {
			{
				boolean _setval = (true);
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mole = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
