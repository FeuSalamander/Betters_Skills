package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.feusalamander.betterskills.BetterSkillsModVariables;
import net.feusalamander.betterskills.BetterSkillsMod;

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
				BetterSkillsMod.LOGGER.warn("Failed to load dependency world for procedure Excavate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency x for procedure Excavate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency y for procedure Excavate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency z for procedure Excavate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency entity for procedure Excavate!");
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
				&& !entity.isSneaking()
				&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("better_skills:foraging_10")))
								.isDone()
						: false)) {
			for (int index0 = 0; index0 < (int) (11); index0++) {
				if (BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:logs"))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y + number), (int) z))).getBlock())) {
					world.destroyBlock(new BlockPos((int) x, (int) (y + number), (int) z), false);
					{
						double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP + 6);
						entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ForagingXP = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+6 foraging xp"), (true));
					}
					number = (number + 1);
				} else {
					break;
				}
			}
		}
	}
}