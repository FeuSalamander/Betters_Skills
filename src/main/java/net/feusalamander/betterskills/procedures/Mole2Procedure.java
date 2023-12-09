package net.feusalamander.betterskills.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class Mole2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double Xmax, double Xmin, double Ymax, double Ymin, double Zmax, double Zmin) {
		if (entity == null)
			return;
		Entity player = null;
		player = entity;
		for (int X = (int) Xmin; X <= (int) Xmax; X++) {
			for (int Z = (int) Zmin; Z <= (int) Zmax; Z++) {
				for (int Y = (int) Ymin; Y <= (int) Ymax; Y++) {
					if (!(x == X && y == Y && z == Z)) {
						if ((world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.STONE || (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.DEEPSLATE
								|| (world.getBlockState(BlockPos.containing(X, Y, Z))).getBlock() == Blocks.NETHERRACK) {
							MiningxpProcedure.execute(world, X, Y, Z, player);
							{
								BlockPos _pos = BlockPos.containing(X, Y, Z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(X, Y, Z), null);
								world.destroyBlock(_pos, false);
							}
						}
					}
				}
			}
		}
	}
}
