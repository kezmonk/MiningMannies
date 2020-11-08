package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class UpdateTickDropItemsAddedToSlot0Procedure extends MiningmanniesModElements.ModElement {
	public UpdateTickDropItemsAddedToSlot0Procedure(MiningmanniesModElements instance) {
		super(instance, 68);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UpdateTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UpdateTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UpdateTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UpdateTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UpdateTickDropItemsAddedToSlot0!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack ItemInSlot0 = ItemStack.EMPTY;
		double NumberOfItemsDroppedToSlot = 0;
		ItemInSlot0 = (new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (0), entity));
		if (((((ItemInSlot0)).getCount()) > 1)) {
			NumberOfItemsDroppedToSlot = (double) (((ItemInSlot0)).getCount());
			for (int index0 = 0; index0 < (int) (((NumberOfItemsDroppedToSlot) - 1)); index0++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z,
							new ItemStack(
									(ForgeRegistries.ITEMS
											.getValue(new ResourceLocation((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString())))),
									(int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
			{
				final ItemStack _setstack = (ItemInSlot0);
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
	}
}
