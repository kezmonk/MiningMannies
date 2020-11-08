
package net.mcreator.miningmannies.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.miningmannies.itemgroup.MiningManniesItemGroup;
import net.mcreator.miningmannies.MiningmanniesModElements;

import java.util.List;

@MiningmanniesModElements.ModElement.Tag
public class BatteryCellsItem extends MiningmanniesModElements.ModElement {
	@ObjectHolder("miningmannies:battery_cells")
	public static final Item block = null;
	public BatteryCellsItem(MiningmanniesModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MiningManniesItemGroup.tab).maxStackSize(64));
			setRegistryName("battery_cells");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0.9F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Battery cells for powering the teleporter"));
		}
	}
}
