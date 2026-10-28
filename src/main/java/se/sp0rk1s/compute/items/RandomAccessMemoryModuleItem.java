package se.sp0rk1s.compute.items;

// Minecraft
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import se.sp0rk1s.compute.logic.Utility;

// Compute
import java.util.List;

import static se.sp0rk1s.compute.registration.ModComponents.MEMORY_SIZE;


public class RandomAccessMemoryModuleItem extends Item {
	public static String ID = "random_access_memory_module";

	public RandomAccessMemoryModuleItem(Item.Properties properties) {
		super(properties
		  .rarity(Rarity.UNCOMMON)
		  //.stacksTo(1)
		  .component(MEMORY_SIZE, 1024)
		);
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		Integer size = stack.get(MEMORY_SIZE.get());
		tooltipComponents.add(Component.literal("Memory size:").withStyle(ChatFormatting.GRAY));
		if (size != null) {
			tooltipComponents.add(Component.literal(" " + Utility.MetricPrefix(size)).withStyle(ChatFormatting.BLUE));
		} else {
			tooltipComponents.add(Component.literal(" 0 B").withStyle(ChatFormatting.BLUE));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
}
