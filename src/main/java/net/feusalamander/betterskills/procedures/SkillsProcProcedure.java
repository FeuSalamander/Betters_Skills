package net.feusalamander.betterskills.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.CommandSource;

import net.feusalamander.betterskills.BetterskillsModVariables;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SkillsProcProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency arguments for procedure SkillsProc!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency entity for procedure SkillsProc!");
			return;
		}
		CommandContext<CommandSource> arguments = (CommandContext<CommandSource>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		if ((StringArgumentType.getString(arguments, "skill")).equals("farming")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp"));
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FarmingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FarmingXP);
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FarmingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cEnter \"set\" or \"add\""), (false));
				}
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("fishing")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp"));
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FishingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FishingXP);
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FishingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cEnter \"set\" or \"add\""), (false));
				}
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("mining")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp"));
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MiningXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP);
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MiningXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cEnter \"set\" or \"add\""), (false));
				}
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("combat")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp"));
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CombatXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP);
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CombatXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cEnter \"set\" or \"add\""), (false));
				}
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("foraging")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp"));
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ForagingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = (DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP);
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ForagingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cEnter \"set\" or \"add\""), (false));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cThis skill don't exist"), (false));
			}
		}
	}
}
