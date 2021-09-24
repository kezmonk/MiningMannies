package net.mcreator.miningmannies.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@MiningmanniesModElements.ModElement.Tag
public class UpdateSeekerTickDropItemsAddedToSlot0Procedure extends MiningmanniesModElements.ModElement {
	public UpdateSeekerTickDropItemsAddedToSlot0Procedure(MiningmanniesModElements instance) {
		super(instance, 121);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UpdateSeekerTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UpdateSeekerTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UpdateSeekerTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UpdateSeekerTickDropItemsAddedToSlot0!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UpdateSeekerTickDropItemsAddedToSlot0!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack ItemInSlot0 = ItemStack.EMPTY;
		double NumberOfItemsDroppedToSlot = 0;
		if (((new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					_retval.set(capability.getStackInSlot(sltid).copy());
				});
				return _retval.get();
			}
		}.getItemStack((int) (0), entity)).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem())) {
			return;
		} else {
			ItemInSlot0 = (new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity));
			if ((!(((ItemInSlot0).getItem() == new ItemStack(Blocks.WHITE_TULIP, (int) (1)).getItem()) || (((ItemInSlot0)
					.getItem() == new ItemStack(Blocks.DANDELION, (int) (1)).getItem())
					|| (((ItemInSlot0).getItem() == new ItemStack(Blocks.OXEYE_DAISY, (int) (1)).getItem()) || (((ItemInSlot0)
							.getItem() == new ItemStack(Blocks.AZURE_BLUET, (int) (1)).getItem())
							|| (((ItemInSlot0).getItem() == new ItemStack(Blocks.CORNFLOWER, (int) (1)).getItem())
									|| (((ItemInSlot0).getItem() == new ItemStack(Blocks.LILAC, (int) (1)).getItem())
											|| (((ItemInSlot0).getItem() == new ItemStack(Blocks.ROSE_BUSH, (int) (1)).getItem())
													|| ((ItemInSlot0).getItem() == new ItemStack(Blocks.PEONY, (int) (1)).getItem())))))))))) {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							(("/tell ") + "" + ((entity.getPersistentData().getString("ownerName"))) + "" + (" Sorry ") + ""
									+ ((entity.getPersistentData().getString("ownerName"))) + ""
									+ (", I can only look for Ores using thier flowers, so no thanks.")));
				}
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z,
							new ItemStack(
									(ForgeRegistries.ITEMS
											.getValue(new ResourceLocation((ForgeRegistries.ITEMS.getKey((ItemInSlot0).getItem()).toString())))),
									(int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				{
					final ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
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
}
