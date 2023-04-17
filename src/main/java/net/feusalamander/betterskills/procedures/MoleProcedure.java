package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.feusalamander.betterskills.BetterskillsModVariables;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.Map;
import java.util.HashMap;

public class MoleProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency world for procedure Mole!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency x for procedure Mole!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency y for procedure Mole!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency z for procedure Mole!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency entity for procedure Mole!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.STONE && (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements().getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager().getAdvancement(new ResourceLocation("betterskills:mining_10"))).isDone()
				: false) && (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).mole == true) {
			if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.STONE) {
				world.destroyBlock(new BlockPos(x + 1, y, z), false);
				{
					double _setval = ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).MiningXP + 1);
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MiningXP = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).xptype).equals("Mining")) {
					{
						double _setval = (1 + (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).xpnumber);
						entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xpnumber = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						String _setval = "Mining";
						entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xptype = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 1;
						entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.xpnumber = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					double _setval = 100;
					entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.xptime = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
