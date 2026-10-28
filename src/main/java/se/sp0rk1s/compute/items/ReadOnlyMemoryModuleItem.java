package se.sp0rk1s.compute.items;

// Minecraft
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ReadOnlyMemoryModuleItem extends Item {
	public static String ID = "read_only_memory_module";

	public ReadOnlyMemoryModuleItem(Item.Properties properties) {
		super(properties
		  .rarity(Rarity.UNCOMMON)
		);
	}
}