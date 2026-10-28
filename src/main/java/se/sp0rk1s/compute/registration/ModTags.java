package se.sp0rk1s.compute.registration;

// Neoforge
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// Compute
import se.sp0rk1s.compute.Compute;

public class ModTags {
	public static class Items {
		public static final TagKey<Item> COMPUTER_MEMORY_MODULES = tag("computer_memory_modules");
		public static final TagKey<Item> COMPUTER_PROCESSORS = tag("computer_processors");
		public static final TagKey<Item> COMPUTER_ACCESSORIES = tag("computer_accessories");

		private static TagKey<Item> tag(String name) {
			return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Compute.MOD_ID, name));
		}
	}
}
