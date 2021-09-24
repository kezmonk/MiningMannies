package net.mcreator.miningmannies.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class OreDetectorEntitySwingItemscanALLProcedure extends MiningmanniesModElements.ModElement {
	public OreDetectorEntitySwingItemscanALLProcedure(MiningmanniesModElements instance) {
		super(instance, 168);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OreDetectorEntitySwingItemscanALL!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure OreDetectorEntitySwingItemscanALL!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double ore = 0;
		if (((entity.isSneaking()) == (true))) {
			if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Coal"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Iron");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A77Iron "), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Iron"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Redstone");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A74Redstone"), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Redstone"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Gold");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A76Gold"), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Gold"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Lapis");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A71Lapis"), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Lapis"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Diamond");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A73Diamond"), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Diamond"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Emerald");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A72Emerald"), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("Emerald"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "NetherQuartz");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A74NetherQuartz"), (false));
				}
			} else if (((((itemstack).getOrCreateTag().getString("oreMode"))).equals("NetherQuartz"))) {
				(itemstack).getOrCreateTag().putString("oreMode", "Coal");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Changed detection mode to \u00A70Coal"), (false));
				}
			}
		}
	}
}
