package net.mcreator.miningmannies.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class OreDetectorItemIsCraftedsmeltedProcedure extends MiningmanniesModElements.ModElement {
	public OreDetectorItemIsCraftedsmeltedProcedure(MiningmanniesModElements instance) {
		super(instance, 93);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure OreDetectorItemIsCraftedsmelted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putString("oreMode", "Coal");
	}
}
