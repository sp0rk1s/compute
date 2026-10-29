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


    // BLOCK ENTITIES

    public static final DeferredBlock<TapeDriveBlock> TAPE_DRIVE =
      BLOCKS.registerBlock(TapeDriveBlock.ID, TapeDriveBlock::new);

    public static final DeferredBlock<ComputerBlock> COMPUTER =
      BLOCKS.registerBlock(ComputerBlock.ID, ComputerBlock::new);
}