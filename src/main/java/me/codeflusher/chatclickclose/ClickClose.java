package me.codeflusher.chatclickclose;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "chatclickclose", useMetadata=true)
public class ClickClose {

    Logger logger = LogManager.getLogger();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("Initializing Chat Click Close Mod!");
    }
}
