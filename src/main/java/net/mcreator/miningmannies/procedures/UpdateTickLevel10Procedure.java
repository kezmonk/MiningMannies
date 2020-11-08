package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.entity.MiningManniSlot11Entity;
import net.mcreator.miningmannies.entity.MiningManniSlot10Entity;
import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.HashMap;

@MiningmanniesModElements.ModElement.Tag
public class UpdateTickLevel10Procedure extends MiningmanniesModElements.ModElement {
	public UpdateTickLevel10Procedure(MiningmanniesModElements instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UpdateTickLevel10!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UpdateTickLevel10!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UpdateTickLevel10!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UpdateTickLevel10!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UpdateTickLevel10!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof MiningManniSlot10Entity.CustomEntity)) {
			entity.getPersistentData().putDouble("timer",
					((entity.getPersistentData().getDouble("timer")) + (1 * (entity.getPersistentData().getDouble("timerSpeed")))));
			if (((entity.getPersistentData().getDouble("timer")) > 3600)) {
				MiningmanniesModVariables.MiningBlockItemNameSlot0 = (String) (ForgeRegistries.ITEMS.getKey((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) (0), entity)).getItem()).toString());
				MiningmanniesModVariables.MiningBlockItemNumberSlot1 = (double) (((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) (1), entity))).getCount());
				MiningmanniesModVariables.MiningBlockOwner = (String) (entity.getPersistentData().getString("ownerName"));
				MiningmanniesModVariables.MiningBlockTimerSpeed = (double) (entity.getPersistentData().getDouble("timerSpeed"));
				MiningmanniesModVariables.ManniBlockDigChance = (double) (entity.getPersistentData().getDouble("digDownChance"));
				if (!entity.world.isRemote)
					entity.remove();
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new MiningManniSlot11Entity.CustomEntity(MiningManniSlot11Entity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, (float) (entity.rotationYaw), (float) (entity.rotationPitch));
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				return;
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UpdateTickDropItemsAddedToSlot0Procedure.executeProcedure($_dependencies);
			}
			if (((entity.getPersistentData().getDouble("digDownChance")) > Math.random())) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					UpdateTickDigBelowSlot0Procedure.executeProcedure($_dependencies);
				}
			} else {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					UpdateTickDigFrontSlot0Procedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
