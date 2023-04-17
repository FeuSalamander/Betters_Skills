package net.feusalamander.betterskills.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.feusalamander.betterskills.BetterskillsMod;

import java.util.Random;
import java.util.Map;

public class WateringcanRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency world for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency x for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency y for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency z for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency entity for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BetterskillsMod.LOGGER.warn("Failed to load dependency itemstack for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double RandomZ = 0;
		double RandomX = 0;
		double Y = 0;
		double Level = 0;
		if (BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:crops")).contains((world.getBlockState(new BlockPos(x, y, z))).getBlock())) {
			if ((itemstack).getDamage() < 9500) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 25, 1, 1, 1, 1);
				}
				if (world instanceof World) {
					if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos(x, y, z)) || BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos(x, y, z), (Direction) null)) {
						if (!world.isRemote())
							((World) world).playEvent(2005, new BlockPos(x, y, z), 0);
					}
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.attemptDamageItem((int) 500, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("no more water"), (true));
				}
			}
		} else if (entity.isInWaterOrBubbleColumn() && entity.isSneaking()) {
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) (-250), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
