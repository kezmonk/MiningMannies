package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.block.TeleporterBlock;
import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class TeleporterBlockDestroyedByPlayerProcedure extends MiningmanniesModElements.ModElement {
	public TeleporterBlockDestroyedByPlayerProcedure(MiningmanniesModElements instance) {
		super(instance, 95);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleporterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TeleporterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TeleporterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TeleporterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleporterBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xx = 0;
		double zz = 0;
		double i = 0;
		MiningmanniesModVariables.XposManniDestination = (double) 0;
		MiningmanniesModVariables.YposManniDestination = (double) 0;
		MiningmanniesModVariables.ZposManniDestination = (double) 0;
		xx = (double) (-3);
		for (int index0 = 0; index0 < (int) (2); index0++) {
			zz = (double) (-3);
			for (int index1 = 0; index1 < (int) (7); index1++) {
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 0), (int) (z + Math.round((zz)))),
						Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 1), (int) (z + Math.round((zz)))),
						Blocks.AIR.getDefaultState(), 3);
				zz = (double) ((zz) + 1);
			}
			xx = (double) 3;
		}
		zz = (double) (-3);
		for (int index2 = 0; index2 < (int) (2); index2++) {
			xx = (double) (-2);
			for (int index3 = 0; index3 < (int) (5); index3++) {
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 0), (int) (z + Math.round((zz)))),
						Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 1), (int) (z + Math.round((zz)))),
						Blocks.AIR.getDefaultState(), 3);
				xx = (double) ((xx) + 1);
			}
			zz = (double) 3;
		}
		xx = (double) (-3);
		for (int index4 = 0; index4 < (int) (7); index4++) {
			zz = (double) (-3);
			for (int index5 = 0; index5 < (int) (7); index5++) {
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y - 1), (int) (z + Math.round((zz)))),
						Blocks.DIRT.getDefaultState(), 3);
				zz = (double) ((zz) + 1);
			}
			xx = (double) ((xx) + 1);
		}
		i = (double) Math.random();
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You have ") + "" + ((MiningmanniesModVariables.ManniTeleportChance))
					+ "" + (" energy for revoery chance. Attempting recovery over....") + "" + ((i)))), (false));
		}
		if (((MiningmanniesModVariables.ManniTeleportChance) >= (i))) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, (1 + y), z, new ItemStack(TeleporterBlock.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
