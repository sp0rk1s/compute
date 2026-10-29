package se.sp0rk1s.compute.items;

// Minecraft
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TapeItem extends Item {
	public static final String ID = "tape";

	public TapeItem(Item.Properties properties) {
		super(properties
		  .rarity(Rarity.COMMON)
		);
	}
}