package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class OreDetectorightClickAirscanALLProcedure extends MiningmanniesModElements.ModElement {
	public OreDetectorightClickAirscanALLProcedure(MiningmanniesModElements instance) {
		super(instance, 167);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OreDetectorightClickAirscanALL!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure OreDetectorightClickAirscanALL!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure OreDetectorightClickAirscanALL!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure OreDetectorightClickAirscanALL!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure OreDetectorightClickAirscanALL!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OreDetectorightClickAirscanALL!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double PosY = 0;
		double start_PosY = 0;
		if (((entity.isSneaking()) == (false))) {
			PosY = (double) y;
			start_PosY = (double) y;
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Scanning earth below node") + "" + (" x:") + "" + (Math.round(x))
						+ "" + (" y:") + "" + (Math.round((PosY))) + "" + (" z:") + "" + (Math.round(z)) + "" + (" for ") + "" + ("ores"))), (false));
			}
			if (((PosY) >= 0)) {
				for (int index0 = 0; index0 < (int) (64); index0++) {
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.COAL_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									(("Metal Detector Fround Ore: \u00A70Coal \u00A7f:") + "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))),
									(false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.REDSTONE_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A74Redstone Ore \u00A7f:") + ""
											+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.GOLD_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									(("Metal Detector Fround Ore: \u00A76Gold \u00A7f:") + "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))),
									(false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.LAPIS_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A71Lapis Ore \u00A7f:") + ""
											+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.EMERALD_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A72Emerald Ore \u00A7f:") + ""
											+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.NETHER_QUARTZ_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A74Nether Quartz Ore \u00A7f:") + ""
											+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.DIAMOND_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A73Diamond Ore \u00A7f:") + ""
											+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
						}
						break;
					}
					if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.IRON_ORE.getDefaultState()
							.getBlock())) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									(("Metal Detector Fround Ore: \u00A77Iron \u00A7f:") + "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))),
									(false));
						}
						break;
					}
					PosY = (double) ((PosY) - 1);
				}
				if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Coal"))) {
					for (int index1 = 0; index1 < (int) (128); index1++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.COAL_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A70Coal \u00A7f:")
										+ "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Iron"))) {
					for (int index2 = 0; index2 < (int) (128); index2++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.IRON_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A77Iron \u00A7f:")
										+ "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Redstone"))) {
					for (int index3 = 0; index3 < (int) (128); index3++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.REDSTONE_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity)
										.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A74Redstone Ore \u00A7f:") + ""
												+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Gold"))) {
					for (int index4 = 0; index4 < (int) (128); index4++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.GOLD_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A76Gold \u00A7f:")
										+ "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Lapis"))) {
					for (int index5 = 0; index5 < (int) (128); index5++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.LAPIS_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity)
										.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A71Lapis Ore \u00A7f:") + ""
												+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Diamond"))) {
					for (int index6 = 0; index6 < (int) (128); index6++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.DIAMOND_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity)
										.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A73Diamond Ore \u00A7f:") + ""
												+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Emerald"))) {
					for (int index7 = 0; index7 < (int) (128); index7++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.EMERALD_ORE.getDefaultState()
								.getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity)
										.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A72Emerald Ore \u00A7f:") + ""
												+ (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("NetherQuartz"))) {
					for (int index8 = 0; index8 < (int) (128); index8++) {
						if (((world.getBlockState(new BlockPos((int) x, (int) (PosY), (int) z))).getBlock() == Blocks.NETHER_QUARTZ_ORE
								.getDefaultState().getBlock())) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity)
										.sendStatusMessage(new StringTextComponent((("Metal Detector Fround Ore: \u00A74Nether Quartz Ore \u00A7f:")
												+ "" + (((start_PosY) - (PosY))) + "" + (" nodes down"))), (false));
							}
							break;
						}
						PosY = (double) ((PosY) - 1);
					}
				}
			}
		}
	}
}
