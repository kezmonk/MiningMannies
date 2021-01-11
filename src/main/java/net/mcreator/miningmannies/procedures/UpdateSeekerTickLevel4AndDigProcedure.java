package net.mcreator.miningmannies.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.entity.OreSeekerLevel1Entity;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.Map;
import java.util.HashMap;

@MiningmanniesModElements.ModElement.Tag
public class UpdateSeekerTickLevel4AndDigProcedure extends MiningmanniesModElements.ModElement {
	public UpdateSeekerTickLevel4AndDigProcedure(MiningmanniesModElements instance) {
		super(instance, 165);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UpdateSeekerTickLevel4AndDig!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UpdateSeekerTickLevel4AndDig!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UpdateSeekerTickLevel4AndDig!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UpdateSeekerTickLevel4AndDig!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UpdateSeekerTickLevel4AndDig!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof OreSeekerLevel1Entity.CustomEntity)) {
			entity.getPersistentData().putDouble("timer",
					((entity.getPersistentData().getDouble("timer")) + (1 * (entity.getPersistentData().getDouble("timerSpeed")))));
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UpdateSeekerTickDropItemsAddedToSlot0Procedure.executeProcedure($_dependencies);
			}
			if ((((entity.getPersistentData().getDouble("timer")) % 20) == 0)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					Seeker4UpdateTickBelowAndDigProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
