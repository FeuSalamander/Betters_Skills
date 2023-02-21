package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.feusalamander.betterskills.BetterskillsModVariables;
import net.feusalamander.betterskills.BetterskillsMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class CombatXpProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency entity for procedure CombatXp!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency sourceentity for procedure CombatXp!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (!(sourceentity instanceof PlayerEntity)) {
			return;
		}
		if (entity instanceof ZombieEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5 combat xp"), (true));
			}
		}
		if (entity instanceof BlazeEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 20);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+20 combat xp"), (true));
			}
		}
		if (entity instanceof CaveSpiderEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5 combat xp"), (true));
			}
		}
		if (entity instanceof CreeperEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5 combat xp"), (true));
			}
		}
		if (entity instanceof CreeperEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 10);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+10 combat xp"), (true));
			}
		}
		if (entity instanceof EnderDragonEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5000);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5000 combat xp"), (true));
			}
		}
		if (entity instanceof DrownedEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5 combat xp"), (true));
			}
		}
		if (entity instanceof ElderGuardianEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 100);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+100 combat xp"), (true));
			}
		}
		if (entity instanceof EndermanEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 20);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+20 combat xp"), (true));
			}
		}
		if (entity instanceof GhastEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 30);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+30 combat xp"), (true));
			}
		}
		if (entity instanceof GolemEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 30);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+30 combat xp"), (true));
			}
		}
		if (entity instanceof GuardianEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 10);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+10 combat xp"), (true));
			}
		}
		if (entity instanceof HuskEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 6);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+6 combat xp"), (true));
			}
		}
		if (entity instanceof IronGolemEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 30);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+30 combat xp"), (true));
			}
		}
		if (entity instanceof MagmaCubeEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 10);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+10 combat xp"), (true));
			}
		}
		if (entity instanceof PhantomEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 30);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+30 combat xp"), (true));
			}
		}
		if (entity instanceof RavagerEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 30);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+30 combat xp"), (true));
			}
		}
		if (entity instanceof AgeableEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 10);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+10 combat xp"), (true));
			}
		}
		if (entity instanceof SkeletonEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5 combat xp"), (true));
			}
		}
		if (entity instanceof SkeletonEntity) {
			{
				double _setval = ((sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP + 5);
				sourceentity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatXP = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("+5 combat xp"), (true));
			}
		}
		if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 522425) {
			{
				double _setval = 20;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_20"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 322425) {
			{
				double _setval = 19;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_19"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 222425) {
			{
				double _setval = 18;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_18"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 147425) {
			{
				double _setval = 17;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_17"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 97425) {
			{
				double _setval = 16;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_16"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 67425) {
			{
				double _setval = 15;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_15"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 47425) {
			{
				double _setval = 14;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_14"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 32425) {
			{
				double _setval = 13;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_13"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 22425) {
			{
				double _setval = 12;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_12"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 14925) {
			{
				double _setval = 11;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_11"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 9925) {
			{
				double _setval = 10;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_10"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 6425) {
			{
				double _setval = 9;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_9"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 4425) {
			{
				double _setval = 8;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_8"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 2925) {
			{
				double _setval = 7;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_7"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 1925) {
			{
				double _setval = 6;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_6"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 1175) {
			{
				double _setval = 5;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_5"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 675) {
			{
				double _setval = 4;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_4"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 375) {
			{
				double _setval = 3;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_3"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 175) {
			{
				double _setval = 2;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat_2"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP >= 50) {
			{
				double _setval = 1;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("betterskills:combat"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else if ((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BetterskillsModVariables.PlayerVariables())).CombatXP < 50) {
			{
				double _setval = 0;
				entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CombatLvl = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
