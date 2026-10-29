package se.sp0rk1s.compute.blockentities;

// Minecraft
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// Compute
import net.neoforged.neoforge.items.ItemStackHandler;
import se.sp0rk1s.compute.registration.ModBlockEntities;
import se.sp0rk1s.compute.registration.ModItems;

public class ComputerBlockEntity extends BlockEntity {
    public static final String ID = "computer";

    public ComputerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TAPE_DRIVE.get(), pos, state);
    }
}
