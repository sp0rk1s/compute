package se.sp0rk1s.compute.registration;

// Neoforge
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

// Compute
import se.sp0rk1s.compute.Compute;
import se.sp0rk1s.compute.blocks.*;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
      DeferredRegister.createBlocks(Compute.MOD_ID);

    public static final DeferredBlock<ComputerBlock> COMPUTER =
      BLOCKS.registerBlock("computer", ComputerBlock::new);
}