package se.sp0rk1s.compute.items;

// Minecraft
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// Compute
import static se.sp0rk1s.compute.registration.ModComponents.MEMORY_SIZE;


public class CeramicBlendItem extends Item {
	public static final String ID = "ceramic_blend";

	public CeramicBlendItem(Item.Properties properties) {
		super(properties
		  .rarity(Rarity.COMMON)
		);
	}
}
