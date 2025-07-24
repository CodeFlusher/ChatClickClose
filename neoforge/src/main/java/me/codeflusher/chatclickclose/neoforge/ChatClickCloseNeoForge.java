package me.codeflusher.chatclickclose.neoforge;

import me.codeflusher.chatclickclose.ChatClickClose;
import net.neoforged.fml.common.Mod;

@Mod(ChatClickClose.MOD_ID)
public final class ChatClickCloseNeoForge {
    public ChatClickCloseNeoForge() {
        // Run our common setup.
        ChatClickClose.init();
    }
}
