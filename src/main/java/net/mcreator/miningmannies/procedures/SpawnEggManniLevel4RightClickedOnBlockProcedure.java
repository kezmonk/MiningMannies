package net.mcreator.miningmannies.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.item.SpawnEggManniLevel4Item;
import net.mcreator.miningmannies.entity.MiningManniSlot40Entity;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class SpawnEggManniLevel4RightClickedOnBlockProcedure extends MiningmanniesModElements.ModElement {
	public SpawnEggManniLevel4RightClickedOnBlockProcedure(MiningmanniesModElements instance) {
		super(instance, 143);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpawnEggManniLevel4RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpawnEggManniLevel4RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpawnEggManniLevel4RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpawnEggManniLevel4RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpawnEggManniLevel4RightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory
					.clearMatchingItems(p -> new ItemStack(SpawnEggManniLevel4Item.block, (int) (1)).getItem() == p.getItem(), (int) 1);
		if (world instanceof World && !world.getWorld().isRemote) {
			Entity entityToSpawn = new MiningManniSlot40Entity.CustomEntity(MiningManniSlot40Entity.entity, world.getWorld());
			entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), z, (float) (entity.rotationYaw), (float) (entity.rotationPitch));
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
	}
}
