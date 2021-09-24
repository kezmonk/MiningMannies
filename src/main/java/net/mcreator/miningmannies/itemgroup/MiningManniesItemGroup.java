
package net.mcreator.miningmannies.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.miningmannies.item.OreDetectorItem;
import net.mcreator.miningmannies.MiningmanniesModElements;

@MiningmanniesModElements.ModElement.Tag
public class MiningManniesItemGroup extends MiningmanniesModElements.ModElement {
	public MiningManniesItemGroup(MiningmanniesModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmining_mannies") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OreDetectorItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
