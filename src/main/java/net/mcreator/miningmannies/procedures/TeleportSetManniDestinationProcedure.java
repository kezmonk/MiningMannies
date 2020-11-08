package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class TeleportSetManniDestinationProcedure extends MiningmanniesModElements.ModElement {
	public TeleportSetManniDestinationProcedure(MiningmanniesModElements instance) {
		super(instance, 53);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleportSetManniDestination!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TeleportSetManniDestination!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TeleportSetManniDestination!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TeleportSetManniDestination!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleportSetManniDestination!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		MiningmanniesModVariables.XposManniDestination = (double) Math.round((entity.getPosX()));
		MiningmanniesModVariables.YposManniDestination = (double) Math.round((entity.getPosY()));
		MiningmanniesModVariables.ZposManniDestination = (double) Math.round((entity.getPosZ()));
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("XposDestination", (MiningmanniesModVariables.XposManniDestination));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("YposDestination", (MiningmanniesModVariables.YposManniDestination));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("ZposDestination", (MiningmanniesModVariables.ZposManniDestination));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity)
					.sendStatusMessage(
							new StringTextComponent((("Teleport all Mannis To: ") + "" + (" X ") + "" + (Math.round((entity.getPosX()))) + ""
									+ (" Y ") + "" + (Math.round((entity.getPosY()))) + "" + (" Z ") + "" + (Math.round((entity.getPosZ()))))),
							(false));
		}
	}
}
