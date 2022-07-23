package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.FoodStats;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.feusalamander.betterskills.BetterskillsModVariables;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.Map;
import java.util.HashMap;

public class ExcavateProcedure {
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
				BetterskillsMod.LOGGER.warn("Failed to load dependency world for procedure Excavate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency x for procedure Excavate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency y for procedure Excavate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency z for procedure Excavate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency entity for procedure Excavate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double number = 0;
		number = 1;
		if (BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:logs"))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())
				&& (entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).Instanttree == true
				&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("betterskills:foraging_10")))
								.isDone()
						: false)
				&& (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getSaturationLevel() : 0) >= 3
						|| ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) >= 3)) {
			for (int index0 = 0; index0 < (int) (11); index0++) {
				if (BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:logs"))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y + number), (int) z))).getBlock())) {
					world.destroyBlock(new BlockPos((int) x, (int) (y + number), (int) z), false);
					{
						double _setval = ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BetterskillsModVariables.PlayerVariables())).ForagingXP + 6);
						entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ForagingXP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+6 foraging xp"), (true));
					}
					number = (number + 1);
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.OAK_LOG));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				} else {
					break;
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getSaturationLevel() : 0) >= 2) {
				if (entity instanceof PlayerEntity) {
					ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(),
							(float) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getSaturationLevel() : 0) - 3),
							"field_75125_b");
				}
			} else {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getFoodStats()
							.setFoodLevel((int) (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) - 3));
			}
		}
	}
}
