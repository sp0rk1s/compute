package se.sp0rk1s.compute;

// Minecraft
import com.mojang.logging.LogUtils;

// Neoforge
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;

// Compute
import se.sp0rk1s.compute.registration.*;

// Java
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Compute.MOD_ID)
public class Compute {

    public static final String MOD_ID = "compute";

    public static final Logger LOGGER = LogUtils.getLogger();

    public Compute(IEventBus modBus, ModContainer container) {
        ModComponents.COMPONENTS.register(modBus);
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modBus);
        ModCreativeTabs.CREATIVE_TABS.register(modBus);
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}