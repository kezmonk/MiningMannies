package net.mcreator.miningmannies.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class RightClickSet4parametersProcedure extends MiningmanniesModElements.ModElement {
	public RightClickSet4parametersProcedure(MiningmanniesModElements instance) {
		super(instance, 69);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RightClickSet4parameters!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure RightClickSet4parameters!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		entity.setMotion(0, 0, 0);
		if ((sourceentity.isSneaking())) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.POPPY, (int) (1)).getItem())) {
				if (((entity.getPersistentData().getDouble("digDownChance")) < 1)) {
					entity.getPersistentData().putDouble("digDownChance", ((entity.getPersistentData().getDouble("digDownChance")) + 0.25));
				}
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(
									new StringTextComponent((("Manni digs down  ") + ""
											+ (((entity.getPersistentData().getDouble("digDownChance")) * 100)) + "" + (" % of the time."))),
									(false));
				}
			}
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem())) {
				if (((entity.getPersistentData().getBoolean("hasOwner")) == (false))) {
					entity.getPersistentData().putString("ownerName", (sourceentity.getDisplayName().getString()));
					entity.getPersistentData().putBoolean("hasOwner", (true));
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(
								(("This Manni now belongs to you ") + "" + ((entity.getPersistentData().getString("ownerName"))))), (false));
					}
				} else if ((((entity.getPersistentData().getString("ownerName"))).equals((sourceentity.getDisplayName().getString())))) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
						((PlayerEntity) sourceentity).sendStatusMessage(
								new StringTextComponent(
										(("This Manni aready belongs to you ") + "" + ((entity.getPersistentData().getString("ownerName"))))),
								(false));
					}
				}
			} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.RED_MUSHROOM, (int) (1)).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 3600, (int) 3));
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("" + ("jump boost"))), (false));
				}
				if (sourceentity instanceof PlayerEntity)
					((PlayerEntity) sourceentity).inventory
							.clearMatchingItems(p -> new ItemStack(Blocks.RED_MUSHROOM, (int) (1)).getItem() == p.getItem(), (int) 1);
			} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.COAL_BLOCK, (int) (1)).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 3600, (int) 3));
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("" + ("fire resistance"))), (false));
				}
				if (sourceentity instanceof PlayerEntity)
					((PlayerEntity) sourceentity).inventory
							.clearMatchingItems(p -> new ItemStack(Blocks.COAL_BLOCK, (int) (1)).getItem() == p.getItem(), (int) 1);
			} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.TORCH, (int) (1)).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 3600, (int) 3));
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("" + ("glowing effect"))), (false));
				}
				if (sourceentity instanceof PlayerEntity)
					((PlayerEntity) sourceentity).inventory.clearMatchingItems(p -> new ItemStack(Blocks.TORCH, (int) (1)).getItem() == p.getItem(),
							(int) 1);
			}
		} else {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.POPPY, (int) (1)).getItem())) {
				if (((entity.getPersistentData().getDouble("digDownChance")) > 0)) {
					entity.getPersistentData().putDouble("digDownChance", ((entity.getPersistentData().getDouble("digDownChance")) - 0.25));
				}
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(
									new StringTextComponent((("Manni digs down ") + ""
											+ (((entity.getPersistentData().getDouble("digDownChance")) * 100)) + "" + (" % of the time."))),
									(false));
				}
			}
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem())) {
				entity.getPersistentData().putDouble("timerSpeed", ((entity.getPersistentData().getDouble("timerSpeed")) + 0.05));
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity).sendStatusMessage(
							new StringTextComponent((("timer speed inceased to  ") + "" + ((entity.getPersistentData().getDouble("timerSpeed"))))),
							(false));
				}
				if (sourceentity instanceof PlayerEntity)
					((PlayerEntity) sourceentity).inventory
							.clearMatchingItems(p -> new ItemStack(Blocks.IRON_ORE, (int) (1)).getItem() == p.getItem(), (int) 1);
			} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.IRON_INGOT, (int) (1)).getItem())) {
				entity.getPersistentData().putDouble("timerSpeed", ((entity.getPersistentData().getDouble("timerSpeed")) + 0.2));
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity).sendStatusMessage(
							new StringTextComponent((("timer speed inceased to ") + "" + ((entity.getPersistentData().getDouble("timerSpeed"))))),
							(false));
				}
				if (sourceentity instanceof PlayerEntity)
					((PlayerEntity) sourceentity).inventory
							.clearMatchingItems(p -> new ItemStack(Items.IRON_INGOT, (int) (1)).getItem() == p.getItem(), (int) 1);
			} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Blocks.WHITE_TULIP, (int) (1)).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
							+ (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.25)));
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(
									new StringTextComponent((("thank you, I feel better ") + ""
											+ ((new java.text.DecimalFormat("##")
													.format(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
									(false));
				}
				if (sourceentity instanceof PlayerEntity)
					((PlayerEntity) sourceentity).inventory
							.clearMatchingItems(p -> new ItemStack(Blocks.WHITE_TULIP, (int) (1)).getItem() == p.getItem(), (int) 1);
			}
		}
	}
}
