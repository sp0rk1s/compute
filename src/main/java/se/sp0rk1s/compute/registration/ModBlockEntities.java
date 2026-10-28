package se.sp0rk1s.compute.registration;

// Minecraft
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

// Compute
import se.sp0rk1s.compute.Compute;
import se.sp0rk1s.compute.blockentities.ComputerBlockEntity;

// Java
import java.util.function.Supplier;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Compute.MOD_ID);

    public static final Supplier<BlockEntityType<ComputerBlockEntity>> COMPUTER =
      BLOCK_ENTITIES.register("computer", () ->
        BlockEntityType.Builder.of(ComputerBlockEntity::new, ModBlocks.COMPUTER.get()).build(null)
      );
}