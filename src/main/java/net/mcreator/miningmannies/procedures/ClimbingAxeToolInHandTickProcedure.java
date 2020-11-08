package net.mcreator.miningmannies.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class ClimbingAxeToolInHandTickProcedure extends MiningmanniesModElements.ModElement {
	public ClimbingAxeToolInHandTickProcedure(MiningmanniesModElements instance) {
		super(instance, 150);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ClimbingAxeToolInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ClimbingAxeToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((itemstack).getOrCreateTag().getBoolean("climbing")) == (true))) {
			(itemstack).getOrCreateTag().putDouble("timer", (((itemstack).getOrCreateTag().getDouble("timer")) + 1));
			if ((((itemstack).getOrCreateTag().getDouble("timer")) >= 10)) {
				entity.setMotion(0, 0, 0);
				(itemstack).getOrCreateTag().putBoolean("climbing", (false));
				(itemstack).getOrCreateTag().putDouble("timer", 0);
			}
		}
	}
}
