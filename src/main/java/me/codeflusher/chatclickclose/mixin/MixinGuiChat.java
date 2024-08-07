package me.codeflusher.chatclickclose.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(Side.CLIENT)
@Mixin(GuiChat.class)
public abstract class MixinGuiChat {

    private Minecraft mc = Minecraft.getMinecraft();
    private GuiNewChat newChat = mc.ingameGUI.getChatGUI();

    @Inject(method = "mouseClicked", at =@At("HEAD"))
    private void mouseClick(int mouseX, int mouseY, int mouseButton, CallbackInfo ci){

        if(mouseX < newChat.getChatWidth() &&  mc.currentScreen.height - mouseY < newChat.getChatHeight()){
            return;
        }

        mc.displayGuiScreen(null);
    }
}
