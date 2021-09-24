package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.item.ClimbingAxeItem;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class ClimbingAxeRightClickedOnBlockProcedure extends MiningmanniesModElements.ModElement {
	public ClimbingAxeRightClickedOnBlockProcedure(MiningmanniesModElements instance) {
		super(instance, 153);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ClimbingAxeRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ClimbingAxeRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ClimbingAxeRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ClimbingAxeRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new ItemStack(ClimbingAxeItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
				&& (new ItemStack(ClimbingAxeItem.block, (int) (1))
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem()))) {
			if (((entity.rotationPitch) <= 25)) {
				if ((((((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getZ())))).getMaterial() == net.minecraft.block.material.Material.ORGANIC)
						|| ((world.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(
												entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getMaterial() == net.minecraft.block.material.Material.ROCK))
						|| ((world.getBlockState(
								new BlockPos(
										(int) (entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getZ())))).getMaterial() == net.minecraft.block.material.Material.SAND))
						|| ((world
								.getBlockState(
										new BlockPos(
												(int) (entity.world.rayTraceBlocks(
														new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																		entity.getLook(1f).z * 1),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												(int) y,
												(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ())))).getMaterial() == net.minecraft.block.material.Material.EARTH))) {
					entity.setMotion(0, 0.25, 0);
					(itemstack).getOrCreateTag().putDouble("interval", 10);
					(itemstack).getOrCreateTag().putBoolean("climbing", (true));
				}
			}
		} else if (((new ItemStack(ClimbingAxeItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())
				^ (new ItemStack(ClimbingAxeItem.block, (int) (1))
						.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem()))) {
			if (((entity.rotationPitch) <= 90)) {
				if ((((((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getZ())))).getMaterial() == net.minecraft.block.material.Material.ORGANIC)
						|| ((world.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(
												entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getMaterial() == net.minecraft.block.material.Material.ROCK))
						|| ((world.getBlockState(
								new BlockPos(
										(int) (entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getZ())))).getMaterial() == net.minecraft.block.material.Material.SAND))
						|| ((world
								.getBlockState(
										new BlockPos(
												(int) (entity.world.rayTraceBlocks(
														new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																		entity.getLook(1f).z * 1),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												(int) y,
												(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ())))).getMaterial() == net.minecraft.block.material.Material.EARTH))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 10, (int) 1, (true), (false)));
				}
			}
		}
	}
}
