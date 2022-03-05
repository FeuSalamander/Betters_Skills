package net.feusalamander.betterskills.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.block.Blocks;

import net.feusalamander.betterskills.BetterSkillsMod;

import java.util.Map;

public class WateringcanRightClickedOnBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency world for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency x for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency y for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BetterSkillsMod.LOGGER.warn("Failed to load dependency z for procedure WateringcanRightClickedOnBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double RandomZ = 0;
		double RandomX = 0;
		double Y = 0;
		double Level = 0;
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRASS_BLOCK) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.ANGRY_VILLAGER, x, y, z, (int) 10, 1, 1, 1, 1);
			}
		} else {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.SPLASH, x, y, z, (int) 25, 1, 1, 1, 1);
			}
			if (world instanceof World) {
				if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) z)) || BoneMealItem
						.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world, new BlockPos((int) x, (int) y, (int) z), (Direction) null)) {
					if (!world.isRemote())
						((World) world).playEvent(2005, new BlockPos((int) x, (int) y, (int) z), 0);
				}
			}
		}
	}
}
