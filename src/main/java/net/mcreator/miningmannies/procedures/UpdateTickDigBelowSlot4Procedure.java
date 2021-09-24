package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.Collections;

@MiningmanniesModElements.ModElement.Tag
public class UpdateTickDigBelowSlot4Procedure extends MiningmanniesModElements.ModElement {
	public UpdateTickDigBelowSlot4Procedure(MiningmanniesModElements instance) {
		super(instance, 80);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UpdateTickDigBelowSlot4!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UpdateTickDigBelowSlot4!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UpdateTickDigBelowSlot4!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UpdateTickDigBelowSlot4!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UpdateTickDigBelowSlot4!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack ItemInSlot0 = ItemStack.EMPTY;
		ItemStack ItemInSlot1 = ItemStack.EMPTY;
		double NumberOfItems = 0;
		ItemInSlot0 = (new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (4), entity));
		ItemInSlot1 = (new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (5), entity));
		if (((/* @BlockState */(new Object() {
			public BlockState toBlock(ItemStack _stk) {
				if (_stk.getItem() instanceof BlockItem) {
					return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
				}
				return Blocks.AIR.getDefaultState();
			}
		}.toBlock((ItemInSlot0))).getBlock() == Blocks.AIR.getDefaultState().getBlock()) == (false))) {
			if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
					.getBlock() == /* @BlockState */(new Object() {
						public BlockState toBlock(ItemStack _stk) {
							if (_stk.getItem() instanceof BlockItem) {
								return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
							}
							return Blocks.AIR.getDefaultState();
						}
					}.toBlock((ItemInSlot0))).getBlock())) {
				entity.setMotion(0, 0, 0);
				if ((MiningmanniesModVariables.ManniChatter)) {
					if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
						world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
								(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Found ") + ""
										+ (((ItemInSlot0).getDisplayName().getString())) + "" + (" at: X ") + "" + (Math.floor(x)) + "" + (" Y ") + ""
										+ (Math.round((y - 1))) + "" + (" Z ") + "" + (Math.floor(z))));
					}
				}
				if (((((ItemInSlot1)).getCount()) < ((entity.getPersistentData().getDouble("maxItemsInSlot1"))
						/ (4 * (MiningmanniesModVariables.ManniTeleportChance))))) {
					world.playEvent(2001, new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)),
							Block.getStateId(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))));
					world.setBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), Blocks.AIR.getDefaultState(), 3);
					{
						final ItemStack _setstack = (ItemInSlot0);
						final int _sltid = (int) (5);
						_setstack.setCount((int) ((((ItemInSlot1)).getCount()) + 1));
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				} else {
					world.playEvent(2001, new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)),
							Block.getStateId(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)))));
					Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))), world.getWorld(),
							new BlockPos((int) x, (int) y, (int) z));
					world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
					if (((MiningmanniesModVariables.ManniTeleportChance) > Math.random())) {
						if (((MiningmanniesModVariables.YposManniDestination) > 0)) {
							if ((((new Object() {
								public String getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(new BlockPos((int) (MiningmanniesModVariables.Teleporter_Xpos),
									(int) (MiningmanniesModVariables.Teleporter_Ypos), (int) (MiningmanniesModVariables.Teleporter_Zpos)),
									"ownerName"))).equals((entity.getPersistentData().getString("ownerName"))))) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate((MiningmanniesModVariables.XposManniDestination),
											(MiningmanniesModVariables.YposManniDestination), (MiningmanniesModVariables.ZposManniDestination));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation((MiningmanniesModVariables.XposManniDestination),
												(MiningmanniesModVariables.YposManniDestination), (MiningmanniesModVariables.ZposManniDestination),
												_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
									}
								}
								if (((((ItemInSlot1)).getCount()) >= 1)) {
									NumberOfItems = (double) (((ItemInSlot1)).getCount());
									for (int index0 = 0; index0 < (int) ((NumberOfItems)); index0++) {
										if (!world.getWorld().isRemote) {
											ItemEntity entityToSpawn = new ItemEntity(world.getWorld(),
													(MiningmanniesModVariables.XposManniDestination),
													(MiningmanniesModVariables.YposManniDestination),
													(MiningmanniesModVariables.ZposManniDestination),
													new ItemStack(
															(ForgeRegistries.ITEMS.getValue(new ResourceLocation(
																	(ForgeRegistries.ITEMS.getKey((ItemInSlot1).getItem()).toString())))),
															(int) (1)));
											entityToSpawn.setPickupDelay(10);
											world.addEntity(entityToSpawn);
										}
									}
									{
										final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
										final int _sltid = (int) (5);
										_setstack.setCount((int) 1);
										entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											if (capability instanceof IItemHandlerModifiable) {
												((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
											}
										});
									}
									if ((MiningmanniesModVariables.ManniChatter)) {
										if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
											world.getWorld().getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), world.getWorld().getServer(), null)
																	.withFeedbackDisabled(),
													(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + ("delivered ")
															+ "" + (((ItemInSlot0).getDisplayName().getString()))));
										}
									}
								}
							}
						}
					}
				}
				MiningmanniesModVariables.XposManniBroadcast = (double) Math.floor(x);
				MiningmanniesModVariables.YposManniBroadcast = (double) (y - 1);
				MiningmanniesModVariables.ZposManniBroadcast = (double) Math.floor(z);
			}
		}
	}
}
