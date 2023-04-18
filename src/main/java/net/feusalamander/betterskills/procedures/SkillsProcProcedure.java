package net.feusalamander.betterskills.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SkillsProcProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((StringArgumentType.getString(arguments, "skill")).equals("farming")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp");
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FarmingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FarmingXP;
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FarmingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cEnter \"set\" or \"add\""), (false));
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("fishing")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp");
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FishingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).FishingXP;
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.FishingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cEnter \"set\" or \"add\""), (false));
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("mining")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp");
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MiningXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP;
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MiningXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cEnter \"set\" or \"add\""), (false));
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("combat")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp");
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CombatXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP;
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CombatXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cEnter \"set\" or \"add\""), (false));
			}
		} else if ((StringArgumentType.getString(arguments, "skill")).equals("foraging")) {
			if ((StringArgumentType.getString(arguments, "setadd")).equals("set")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp");
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ForagingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((StringArgumentType.getString(arguments, "setadd")).equals("add")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "xp") + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP;
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ForagingXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cEnter \"set\" or \"add\""), (false));
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cThis skill don't exist"), (false));
		}
	}
}
