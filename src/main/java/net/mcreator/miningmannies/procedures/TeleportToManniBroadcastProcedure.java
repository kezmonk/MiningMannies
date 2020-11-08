package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;
import java.util.Collections;

@MiningmanniesModElements.ModElement.Tag
public class TeleportToManniBroadcastProcedure extends MiningmanniesModElements.ModElement {
	public TeleportToManniBroadcastProcedure(MiningmanniesModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleportToManniBroadcast!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleportToManniBroadcast!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((!((MiningmanniesModVariables.XposManniBroadcast) == 0))
				&& ((!((MiningmanniesModVariables.YposManniBroadcast) == 0)) && (!((MiningmanniesModVariables.ZposManniBroadcast) == 0))))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Attempting teleporting to: ") + "" + (" X ") + ""
						+ ((new java.text.DecimalFormat("###").format(Math.round((MiningmanniesModVariables.XposManniBroadcast))))) + "" + (" Y ")
						+ "" + ((new java.text.DecimalFormat("###").format(Math.round((MiningmanniesModVariables.YposManniBroadcast))))) + ""
						+ (" Z ") + "" + ((new java.text.DecimalFormat("###").format(Math.round((MiningmanniesModVariables.ZposManniBroadcast))))))),
						(false));
			}
			if ((((world.getBlockState(new BlockPos((int) (MiningmanniesModVariables.XposManniBroadcast),
					(int) (MiningmanniesModVariables.YposManniBroadcast), (int) (MiningmanniesModVariables.ZposManniBroadcast))))
							.getBlock() == Blocks.AIR.getDefaultState().getBlock())
					&& ((world.getBlockState(new BlockPos((int) (MiningmanniesModVariables.XposManniBroadcast),
							(int) ((MiningmanniesModVariables.YposManniBroadcast) + 1), (int) (MiningmanniesModVariables.ZposManniBroadcast))))
									.getBlock() == Blocks.AIR.getDefaultState().getBlock()))) {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate((Math.round((MiningmanniesModVariables.XposManniBroadcast)) + 0.5),
							Math.round((MiningmanniesModVariables.YposManniBroadcast)),
							(Math.round((MiningmanniesModVariables.ZposManniBroadcast)) + 0.5));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.round((MiningmanniesModVariables.XposManniBroadcast)) + 0.5),
								Math.round((MiningmanniesModVariables.YposManniBroadcast)),
								(Math.round((MiningmanniesModVariables.ZposManniBroadcast)) + 0.5), _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				entity.rotationYaw = (float) ((entity.rotationYaw));
				entity.rotationPitch = (float) ((entity.rotationPitch));
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not enough air space, teleportation failed."), (false));
				}
			}
		}
	}
}
