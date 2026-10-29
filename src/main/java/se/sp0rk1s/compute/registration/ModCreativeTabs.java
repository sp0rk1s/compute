package se.sp0rk1s.compute.registration;

// Minecraft
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

// Neoforge
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "compute");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMPUTE_TAB =
      CREATIVE_TABS.register("compute_tab", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.compute"))
        .icon(() -> new ItemStack(ModBlocks.COMPUTER.get()))
        .displayItems((params, output) -> {
            output.accept(ModBlocks.COMPUTER);
            output.accept(ModItems.RANDOM_ACCESS_MEMORY_MODULE);
            output.accept(ModItems.CERAMIC_BLEND_ITEM);
            output.accept(ModItems.READ_ONLY_MEMORY_MODULE);
            output.accept(ModItems.ADVANCED_INTEGRATED_CIRCUIT_DIE);
            output.accept(ModItems.TAPE_DRIVE_ITEM);
        })
        .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_TABS.register(modEventBus);
    }
}