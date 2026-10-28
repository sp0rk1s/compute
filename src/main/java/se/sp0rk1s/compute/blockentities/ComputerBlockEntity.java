package se.sp0rk1s.compute.blockentities;

// Minecraft
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// Compute
import net.neoforged.neoforge.items.ItemStackHandler;
import se.sp0rk1s.compute.registration.ModBlockEntities;
import se.sp0rk1s.compute.registration.ModItems;
import se.sp0rk1s.compute.registration.ModTags;

import javax.annotation.Nullable;

public class ComputerBlockEntity extends BlockEntity {

    private final ItemStackHandler memoryModules = new ItemStackHandler(8) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1; // Can only ever have 1 stick per slot
        }

        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return stack.is(ModTags.Items.COMPUTER_MEMORY_MODULES);
        }
    };

    private final ItemStackHandler processors = new ItemStackHandler(1) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1; // Can only ever have 1 stick per slot
        }

        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
        }
    };

    private final ItemStackHandler accessories = new ItemStackHandler(1) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1; // Can only ever have 1 stick per slot
        }

        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
        }
    };

    public ComputerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COMPUTER.get(), pos, state);
    }
}
