package se.sp0rk1s.compute.registration;

// Minecraft
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

// Neoforge
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import se.sp0rk1s.compute.Compute;

// Compute

public class ModComponents {
	public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
	  DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Compute.MOD_ID);

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> MEMORY_SIZE =
	  COMPONENTS.register("memory_size", () -> DataComponentType.<Integer>builder()
		.persistent(ExtraCodecs.POSITIVE_INT)
		.networkSynchronized(ByteBufCodecs.VAR_INT)
		.build());
}
