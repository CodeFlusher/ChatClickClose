package me.codeflusher.chatclickclose.mixins;

import lombok.extern.slf4j.Slf4j;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Slf4j
@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {
    @Shadow
    public abstract int getWidth();

    @Shadow
    public abstract int getHeight();

    @Shadow
    @Final
    private static int BOTTOM_MARGIN;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(at = @At("HEAD"), method = "handleChatQueueClicked", cancellable = true)
    public void closeChat(double x, double y, CallbackInfoReturnable<Boolean> cir) {
//        log.info("Chat click registered!");
        var chatWidth = this.getWidth();
        var chatHeight = this.getHeight();
        var fixedY = minecraft.getWindow().getHeight() - y;
//        log.info("Positions: {}, {}, width: {}, height {}", x, fixedY, chatWidth, chatHeight);
        if (chatWidth < x || chatHeight < y) {
            this.minecraft.setScreen(null);
            cir.cancel();
        }
    }

}
