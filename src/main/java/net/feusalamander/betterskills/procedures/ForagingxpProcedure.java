package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.feusalamander.betterskills.BetterSkillsModVariables;
import net.feusalamander.betterskills.BetterSkillsMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class ForagingxpProcedure {
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
				BetterSkillsMod.LOGGER.warn("Failed to load dependency world for procedure Foragingxp!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency x for procedure Foragingxp!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency y for procedure Foragingxp!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency z for procedure Foragingxp!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency entity for procedure Foragingxp!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 522425) {
			{
				double _setval = 20;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_20"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 322425) {
			{
				double _setval = 19;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_19"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 222425) {
			{
				double _setval = 18;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_18"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 147425) {
			{
				double _setval = 17;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_17"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 97425) {
			{
				double _setval = 16;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_16"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 67425) {
			{
				double _setval = 15;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_15"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 47425) {
			{
				double _setval = 14;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_14"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 32425) {
			{
				double _setval = 13;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_13"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 22425) {
			{
				double _setval = 12;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_12"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 14925) {
			{
				double _setval = 11;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_11"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 9925) {
			{
				double _setval = 10;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_10"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 6425) {
			{
				double _setval = 9;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_9"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 4425) {
			{
				double _setval = 8;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_8"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 2925) {
			{
				double _setval = 7;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_7"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 1925) {
			{
				double _setval = 6;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_6"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 1175) {
			{
				double _setval = 5;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_5"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 675) {
			{
				double _setval = 4;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_4"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 375) {
			{
				double _setval = 3;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_3"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 175) {
			{
				double _setval = 2;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_2"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP >= 50) {
			{
				double _setval = 1;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:foraging_1"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).ForagingXP < 50) {
			{
				double _setval = 0;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ForagingLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OAK_LOG) {
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
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.SPRUCE_LOG) {
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
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.BIRCH_LOG) {
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
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.JUNGLE_LOG) {
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
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DARK_OAK_LOG) {
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
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WARPED_STEM) {
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
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CRIMSON_STEM) {
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
		}
	}
}
