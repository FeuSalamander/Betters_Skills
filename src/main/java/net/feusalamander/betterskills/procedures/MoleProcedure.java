package net.feusalamander.betterskills.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.feusalamander.betterskills.network.BetterskillsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MoleProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Xmin = 0;
		double Xmax = 0;
		double Ymin = 0;
		double Ymax = 0;
		double Zmin = 0;
		double Zmax = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHERRACK) {
			if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("i")) {
				if (entity.getXRot() >= 30 || entity.getXRot() <= -30) {
					Xmin = x - 1;
					Xmax = x + 1;
					Ymin = y;
					Ymax = y;
					Zmin = z - 1;
					Zmax = z + 1;
				} else if (entity.getYRot() > 45 && entity.getYRot() < 135 || entity.getYRot() > -135 && entity.getYRot() < -45) {
					Xmin = x;
					Xmax = x;
					Ymin = y - 1;
					Ymax = y + 1;
					Zmin = z - 1;
					Zmax = z + 1;
				} else {
					Xmin = x - 1;
					Xmax = x + 1;
					Ymin = y - 1;
					Ymax = y + 1;
					Zmin = z;
					Zmax = z;
				}
				Mole2Procedure.execute(world, Xmax, Xmin, Ymax, Ymin, Zmax, Zmin);
			} else if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("u")) {
				if (entity.getXRot() >= 30 || entity.getXRot() <= -30) {
					Xmin = x - 1;
					Xmax = x + 1;
					Ymin = y;
					Ymax = y;
					Zmin = z - 1;
					Zmax = z + 0;
				} else if (entity.getYRot() > 45 && entity.getYRot() < 135 || entity.getYRot() > -135 && entity.getYRot() < -45) {
					Xmin = x;
					Xmax = x;
					Ymin = y - 1;
					Ymax = y + 0;
					Zmin = z - 1;
					Zmax = z + 1;
				} else {
					Xmin = x - 1;
					Xmax = x + 1;
					Ymin = y - 1;
					Ymax = y + 0;
					Zmin = z;
					Zmax = z;
				}
				Mole2Procedure.execute(world, Xmax, Xmin, Ymax, Ymin, Zmax, Zmin);
			} else if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("y")) {
				if (entity.getXRot() >= 30 || entity.getXRot() <= -30) {
					Xmin = x - 1;
					Xmax = x + 1;
					Ymin = y;
					Ymax = y;
					Zmin = z - 0;
					Zmax = z + 0;
				} else if (entity.getYRot() > 45 && entity.getYRot() < 135 || entity.getYRot() > -135 && entity.getYRot() < -45) {
					Xmin = x;
					Xmax = x;
					Ymin = y - 0;
					Ymax = y + 0;
					Zmin = z - 1;
					Zmax = z + 1;
				} else {
					Xmin = x - 1;
					Xmax = x + 1;
					Ymin = y - 0;
					Ymax = y + 0;
					Zmin = z;
					Zmax = z;
				}
				Mole2Procedure.execute(world, Xmax, Xmin, Ymax, Ymin, Zmax, Zmin);
			} else if (((entity.getCapability(BetterskillsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new BetterskillsModVariables.PlayerVariables())).miningTree).contains("t")) {
				if (entity.getXRot() >= 30 || entity.getXRot() <= -30) {
					Xmin = x - 0;
					Xmax = x + 0;
					Ymin = y;
					Ymax = y;
					Zmin = z - 1;
					Zmax = z + 0;
				} else if (entity.getYRot() > 45 && entity.getYRot() < 135 || entity.getYRot() > -135 && entity.getYRot() < -45) {
					Xmin = x;
					Xmax = x;
					Ymin = y - 1;
					Ymax = y + 0;
					Zmin = z - 0;
					Zmax = z + 0;
				} else {
					Xmin = x - 0;
					Xmax = x + 0;
					Ymin = y - 1;
					Ymax = y + 0;
					Zmin = z;
					Zmax = z;
				}
				Mole2Procedure.execute(world, Xmax, Xmin, Ymax, Ymin, Zmax, Zmin);
			}
		}
	}
}
