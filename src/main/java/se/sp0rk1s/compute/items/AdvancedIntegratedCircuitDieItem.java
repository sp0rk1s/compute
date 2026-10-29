package se.sp0rk1s.compute.items;

// Minecraft
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class AdvancedIntegratedCircuitDieItem extends Item {
	public static final String ID = "advanced_integrated_circuit_die";

	public AdvancedIntegratedCircuitDieItem(Properties properties) {
		super(properties
		  .rarity(Rarity.EPIC)
		);
	}
}