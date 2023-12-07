package net.feusalamander.betterskills.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Mole2Procedure {
	public static void execute(LevelAccessor world, double Xmax, double Xmin, double Ymax, double Ymin, double Zmax, double Zmin) {
		for (int X = (int) Xmin; X <= (int) Xmax; X++) {
			for (int Z = (int) Zmin; Z <= (int) Zmax; Z++) {
				for (int Y = (int) Ymin; Y <= (int) Ymax; Y++) {
					if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.STONE || (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.DEEPSLATE
							|| (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.NETHERRACK) {
						world.destroyBlock(BlockPos.containing(X, Y, Z), false);
					}
				}
			}
		}
	}
}
