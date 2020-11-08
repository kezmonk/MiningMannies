package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.miningmannies.item.BatteryCellsItem;
import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class TeleportToggleTeleportChanceProcedure extends MiningmanniesModElements.ModElement {
	public TeleportToggleTeleportChanceProcedure(MiningmanniesModElements instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleportToggleTeleportChance!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TeleportToggleTeleportChance!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TeleportToggleTeleportChance!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TeleportToggleTeleportChance!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleportToggleTeleportChance!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BatteryCellsItem.block, (int) (1)).getItem())) {
			if (((MiningmanniesModVariables.ManniTeleportChance) >= 1)) {
				MiningmanniesModVariables.ManniTeleportChance = (double) 1;
			} else {
				MiningmanniesModVariables.ManniTeleportChance = (double) ((MiningmanniesModVariables.ManniTeleportChance) + 0.1);
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).inventory
							.clearMatchingItems(p -> new ItemStack(BatteryCellsItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			}
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("teleportChance", Math.round(((MiningmanniesModVariables.ManniTeleportChance) * 100)));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((((new Object() {
				public String getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getString(tag);
					return "";
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "ownerName"))) + "" + (" mmmanni teleport chance is set to: ") + ""
					+ ((MiningmanniesModVariables.ManniTeleportChance)))), (false));
		}
	}
}
