package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.entity.OreSeekerLevel1Entity;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class Seeker1UpdateTickBlockFrontProcedure extends MiningmanniesModElements.ModElement {
	public Seeker1UpdateTickBlockFrontProcedure(MiningmanniesModElements instance) {
		super(instance, 105);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Seeker1UpdateTickBlockFront!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Seeker1UpdateTickBlockFront!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Seeker1UpdateTickBlockFront!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Seeker1UpdateTickBlockFront!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Seeker1UpdateTickBlockFront!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack ItemInSlot0 = ItemStack.EMPTY;
		if ((entity instanceof OreSeekerLevel1Entity.CustomEntity)) {
			ItemInSlot0 = (new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity));
			if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Items.COAL, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.COAL_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.COAL_ORE.getDefaultState().getBlock())).getDisplayName().getString())) + ""
												+ (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.IRON_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.IRON_ORE.getDefaultState().getBlock())).getDisplayName().getString())) + ""
												+ (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Items.REDSTONE, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.REDSTONE_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.REDSTONE_ORE.getDefaultState().getBlock())).getDisplayName().getString()))
												+ "" + (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.GOLD_ORE, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.GOLD_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.GOLD_ORE.getDefaultState().getBlock())).getDisplayName().getString())) + ""
												+ (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Items.LAPIS_LAZULI, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.LAPIS_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.LAPIS_ORE.getDefaultState().getBlock())).getDisplayName().getString())) + ""
												+ (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Items.QUARTZ, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock())).getDisplayName()
														.getString()))
												+ "" + (" at: X ") + "" + ((entity.world.rayTraceBlocks(
														new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																		entity.getLook(1f).z * 1),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Items.EMERALD, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.EMERALD_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.EMERALD_ORE.getDefaultState().getBlock())).getDisplayName().getString()))
												+ "" + (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
					.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Items.DIAMOND, (int) (1)).getItem()).toString())))) {
				if (((world
						.getBlockState(
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(
												new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1, entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										(int) y,
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
														entity.getLook(1f).z * 1),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))))
														.getBlock() == Blocks.DIAMOND_ORE.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager()
								.handleCommand(new CommandSource(
										ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "", new StringTextComponent(
												""),
										world.getWorld().getServer(), null).withFeedbackDisabled(),
										(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
												+ (((new ItemStack(Blocks.DIAMOND_ORE.getDefaultState().getBlock())).getDisplayName().getString()))
												+ "" + (" at: X ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()))
												+ "" + (" Y ") + "" + (y) + "" + (" Z ") + ""
												+ ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 1, entity.getLook(1f).y * 1,
																entity.getLook(1f).z * 1),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
														.getZ()))));
					}
				}
			}
		}
	}
}
