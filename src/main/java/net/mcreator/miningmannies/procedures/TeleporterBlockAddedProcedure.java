package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.miningmannies.block.SteelBlockBlock;
import net.mcreator.miningmannies.block.ElectricFieldBlock;
import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class TeleporterBlockAddedProcedure extends MiningmanniesModElements.ModElement {
	public TeleporterBlockAddedProcedure(MiningmanniesModElements instance) {
		super(instance, 56);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TeleporterBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TeleporterBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TeleporterBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleporterBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xx = 0;
		double zz = 0;
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("teleportChance", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("XposDestination", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("YposDestination", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("ZposDestination", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		MiningmanniesModVariables.XposManniDestination = (double) 0;
		MiningmanniesModVariables.YposManniDestination = (double) 0;
		MiningmanniesModVariables.ZposManniDestination = (double) 0;
		MiningmanniesModVariables.ManniTeleportChance = (double) 0;
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putBoolean("hasOwner", (false));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("tpX", x);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("tpY", y);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("tpZ", z);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		xx = (double) (-3);
		for (int index0 = 0; index0 < (int) (7); index0++) {
			zz = (double) (-3);
			for (int index1 = 0; index1 < (int) (7); index1++) {
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y - 1), (int) (z + Math.round((zz)))),
						SteelBlockBlock.block.getDefaultState(), 3);
				zz = (double) ((zz) + 1);
			}
			xx = (double) ((xx) + 1);
		}
		xx = (double) (-3);
		for (int index2 = 0; index2 < (int) (2); index2++) {
			zz = (double) (-3);
			for (int index3 = 0; index3 < (int) (7); index3++) {
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 0), (int) (z + Math.round((zz)))),
						ElectricFieldBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 1), (int) (z + Math.round((zz)))),
						ElectricFieldBlock.block.getDefaultState(), 3);
				zz = (double) ((zz) + 1);
			}
			xx = (double) 3;
		}
		zz = (double) (-3);
		for (int index4 = 0; index4 < (int) (2); index4++) {
			xx = (double) (-2);
			for (int index5 = 0; index5 < (int) (5); index5++) {
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 0), (int) (z + Math.round((zz)))),
						ElectricFieldBlock.block.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + Math.round((xx))), (int) (y + 1), (int) (z + Math.round((zz)))),
						ElectricFieldBlock.block.getDefaultState(), 3);
				xx = (double) ((xx) + 1);
			}
			zz = (double) 3;
		}
	}
}
