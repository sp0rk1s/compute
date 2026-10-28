package se.sp0rk1s.compute.registration;

// Neoforge
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// Compute
import se.sp0rk1s.compute.items.*;

public class ModItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("compute");

	// ITEMS
	public static final DeferredItem<Item> RANDOM_ACCESS_MEMORY_MODULE =
	  ITEMS.registerItem(RandomAccessMemoryModuleItem.ID, RandomAccessMemoryModuleItem::new);

	public static final DeferredItem<Item> READ_ONLY_MEMORY_MODULE =
	  ITEMS.registerItem(ReadOnlyMemoryModuleItem.ID, ReadOnlyMemoryModuleItem::new);

	public static final DeferredItem<Item> CERAMIC_BLEND_ITEM =
	  ITEMS.registerItem(CeramicBlendItem.ID, CeramicBlendItem::new);

	// OTHER

	public static final DeferredItem<BlockItem> COMPUTER_ITEM =
	  ITEMS.registerSimpleBlockItem("computer", ModBlocks.COMPUTER);
}
