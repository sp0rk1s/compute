package se.sp0rk1s.compute.registration;

// Neoforge
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// Compute
import se.sp0rk1s.compute.blocks.*;
import se.sp0rk1s.compute.items.*;

public class ModItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("compute");

	// ITEMS

	public static final DeferredItem<Item> ADVANCED_INTEGRATED_CIRCUIT_DIE =
	  ITEMS.registerItem(AdvancedIntegratedCircuitDieItem.ID, AdvancedIntegratedCircuitDieItem::new);

	public static final DeferredItem<Item> RANDOM_ACCESS_MEMORY_MODULE =
	  ITEMS.registerItem(RandomAccessMemoryModuleItem.ID, RandomAccessMemoryModuleItem::new);

	public static final DeferredItem<Item> READ_ONLY_MEMORY_MODULE =
	  ITEMS.registerItem(ReadOnlyMemoryModuleItem.ID, ReadOnlyMemoryModuleItem::new);

	public static final DeferredItem<Item> TAPE =
	  ITEMS.registerItem(TapeItem.ID, TapeItem::new);

	public static final DeferredItem<Item> CERAMIC_BLEND_ITEM =
	  ITEMS.registerItem(CeramicBlendItem.ID, CeramicBlendItem::new);

	// OTHER

	public static final DeferredItem<BlockItem> TAPE_DRIVE_ITEM =
	  ITEMS.registerSimpleBlockItem(TapeDriveBlock.ID, ModBlocks.TAPE_DRIVE);

	public static final DeferredItem<BlockItem> COMPUTER_ITEM =
	  ITEMS.registerSimpleBlockItem(ComputerBlock.ID, ModBlocks.COMPUTER);
}
