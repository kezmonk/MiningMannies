package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.miningmannies.entity.OreSeekerLevel1Entity;
import net.mcreator.miningmannies.MiningmanniesModVariables;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class Seeker1UpdateTickBelowAndDigProcedure extends MiningmanniesModElements.ModElement {
	public Seeker1UpdateTickBelowAndDigProcedure(MiningmanniesModElements instance) {
		super(instance, 159);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Seeker1UpdateTickBelowAndDig!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Seeker1UpdateTickBelowAndDig!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Seeker1UpdateTickBelowAndDig!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Seeker1UpdateTickBelowAndDig!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Seeker1UpdateTickBelowAndDig!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack ItemInSlot0 = ItemStack.EMPTY;
		double PosY = 0;
		double start_PosY = 0;
		boolean keepLooking = false;
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
			keepLooking = (boolean) (true);
			if (((!((ItemInSlot0).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem())) && (keepLooking))) {
				PosY = (double) y;
				start_PosY = (double) y;
				if (((PosY) >= 0)) {
					for (int index0 = 0; index0 < (int) (32); index0++) {
						if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.WHITE_TULIP, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.COAL_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.COAL_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.DANDELION, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.IRON_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.IRON_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.OXEYE_DAISY, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.REDSTONE_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.REDSTONE_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.AZURE_BLUET, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.GOLD_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.GOLD_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.CORNFLOWER, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.LAPIS_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.LAPIS_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.LILAC, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.ROSE_BUSH, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.EMERALD_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.EMERALD_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						} else if ((((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString()))
								.equals((ForgeRegistries.ITEMS.getKey(new ItemStack(Blocks.PEONY, (int) (1)).getItem()).toString())))) {
							if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (PosY), (int) Math.floor(z))))
									.getBlock() == Blocks.DIAMOND_ORE.getDefaultState().getBlock())) {
								if (((world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
										.getBlock() == Blocks.DIAMOND_ORE.getDefaultState().getBlock())) {
									keepLooking = (boolean) (false);
									break;
								} else {
									Block.spawnDrops(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))),
											world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
									world.destroyBlock(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z)), false);
									break;
								}
							}
						}
						PosY = (double) ((PosY) - 1);
					}
				}
			}
			if (((keepLooking) == (false))) {
				if ((((entity.getPersistentData().getDouble("timer")) % 1200) == 0)) {
					if ((MiningmanniesModVariables.ManniChatter)) {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + ""
											+ ((entity.getDisplayName().getString())) + "" + (" staying put on top of ") + ""
											+ (((new ItemStack(
													(world.getBlockState(new BlockPos((int) Math.floor(x), (int) (y - 1), (int) Math.floor(z))))
															.getBlock())).getDisplayName().getString()))
											+ "" + (" from: X ") + "" + (Math.floor(x)) + "" + (" Y ") + "" + (Math.round(y)) + "" + (" Z ") + ""
											+ (Math.floor(z))));
						}
					}
					MiningmanniesModVariables.XposManniBroadcast = (double) Math.floor(x);
					MiningmanniesModVariables.YposManniBroadcast = (double) Math.round(y);
					MiningmanniesModVariables.ZposManniBroadcast = (double) Math.floor(z);
				}
			}
		}
	}
}
