package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.feusalamander.betterskills.BetterSkillsModVariables;
import net.feusalamander.betterskills.BetterSkillsMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class MiningxpProcedure {
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
				BetterSkillsMod.LOGGER.warn("Failed to load dependency world for procedure Miningxp!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency x for procedure Miningxp!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency y for procedure Miningxp!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency z for procedure Miningxp!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency entity for procedure Miningxp!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 522425) {
			{
				double _setval = 20;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_20"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 322425) {
			{
				double _setval = 19;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_19"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 222425) {
			{
				double _setval = 18;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_18"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 147425) {
			{
				double _setval = 17;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_17"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 97425) {
			{
				double _setval = 16;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_16"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 67425) {
			{
				double _setval = 15;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_15"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 47425) {
			{
				double _setval = 14;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_14"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 32425) {
			{
				double _setval = 13;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_13"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 22425) {
			{
				double _setval = 12;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_12"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 14925) {
			{
				double _setval = 11;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_11"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 9925) {
			{
				double _setval = 10;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_10"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 6425) {
			{
				double _setval = 9;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_9"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 4425) {
			{
				double _setval = 8;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_8"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 2925) {
			{
				double _setval = 7;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_7"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 1925) {
			{
				double _setval = 6;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_6"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 1175) {
			{
				double _setval = 5;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_5"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 675) {
			{
				double _setval = 4;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_4"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 375) {
			{
				double _setval = 3;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_3"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 175) {
			{
				double _setval = 2;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_2"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP >= 50) {
			{
				double _setval = 1;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("better_skills:mining_1"));
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
				.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP < 50) {
			{
				double _setval = 0;
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningLvL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.STONE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 1);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRANITE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 1);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIORITE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 1);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COAL_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 3);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.IRON_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 5);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.REDSTONE_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 5);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.REDSTONE_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 5);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GOLD_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 10);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.LAPIS_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 10);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIAMOND_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 25);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EMERALD_ORE) {
			{
				double _setval = ((entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterSkillsModVariables.PlayerVariables())).MiningXP + 50);
				entity.getCapability(BetterSkillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MiningXP = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
