package net.mcreator.miningmannies.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class OreDetectorEntitySwingsItemProcedure extends MiningmanniesModElements.ModElement {
	public OreDetectorEntitySwingsItemProcedure(MiningmanniesModElements instance) {
		super(instance, 89);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OreDetectorEntitySwingsItem!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure OreDetectorEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity.isSneaking()) == (true))) {
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == (new ItemStack(Blocks.COAL_ORE.getDefaultState().getBlock())).getItem())
					|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == (new ItemStack(Blocks.IRON_ORE.getDefaultState().getBlock())).getItem())
							|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == (new ItemStack(Blocks.REDSTONE_ORE.getDefaultState().getBlock())).getItem())
									|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
											.getItem() == (new ItemStack(Blocks.GOLD_ORE.getDefaultState().getBlock())).getItem())
											|| ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
													.getItem() == (new ItemStack(Blocks.LAPIS_ORE.getDefaultState().getBlock())).getItem())
													|| ((((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemOffhand()
															: ItemStack.EMPTY)
																	.getItem() == (new ItemStack(Blocks.DIAMOND_ORE.getDefaultState().getBlock()))
																			.getItem())
															|| ((((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemOffhand()
																	: ItemStack.EMPTY)
																			.getItem() == (new ItemStack(
																					Blocks.EMERALD_ORE.getDefaultState().getBlock())).getItem())
																	|| (((entity instanceof LivingEntity)
																			? ((LivingEntity) entity).getHeldItemOffhand()
																			: ItemStack.EMPTY)
																					.getItem() == (new ItemStack(
																							Blocks.NETHER_QUARTZ_ORE.getDefaultState().getBlock()))
																									.getItem()))))))))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.COAL_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Coal");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A70Coal"), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Iron");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A77Iron "), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.REDSTONE_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Redstone");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A74Redstone"), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.GOLD_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Gold");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A76Gold"), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.LAPIS_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Lapis");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A71Lapis"), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.DIAMOND_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Diamond");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A73Diamond"), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.EMERALD_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "Emerald");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A72Emerald"), (false));
					}
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(Blocks.NETHER_QUARTZ_ORE, (int) (1)).getItem())) {
					(itemstack).getOrCreateTag().putString("oreMode", "NetherQuartz");
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A74NetherQuartz"), (false));
					}
				}
			}
		}
	}
}
