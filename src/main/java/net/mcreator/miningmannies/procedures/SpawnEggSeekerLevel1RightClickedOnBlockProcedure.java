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

import net.mcreator.miningmannies.item.SpawnEggSeekerLevel1Item;
import net.mcreator.miningmannies.entity.OreSeekerLevel1Entity;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class SpawnEggSeekerLevel1RightClickedOnBlockProcedure extends MiningmanniesModElements.ModElement {
	public SpawnEggSeekerLevel1RightClickedOnBlockProcedure(MiningmanniesModElements instance) {
		super(instance, 141);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpawnEggSeekerLevel1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SpawnEggSeekerLevel1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SpawnEggSeekerLevel1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SpawnEggSeekerLevel1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SpawnEggSeekerLevel1RightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory
					.clearMatchingItems(p -> new ItemStack(SpawnEggSeekerLevel1Item.block, (int) (1)).getItem() == p.getItem(), (int) 1);
		if (world instanceof World && !world.getWorld().isRemote) {
			Entity entityToSpawn = new OreSeekerLevel1Entity.CustomEntity(OreSeekerLevel1Entity.entity, world.getWorld());
			entityToSpawn.setLocationAndAngles((x + 0.5), (y + 1), z, (float) (entity.rotationYaw), (float) (entity.rotationPitch));
			if (entityToSpawn instanceof MobEntity)
				((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
						SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
			world.addEntity(entityToSpawn);
		}
	}
}
