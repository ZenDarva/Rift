package org.dimdev.riftloader.launch;

import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RiftLoaderServerTweaker extends RiftLoaderTweaker {
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.args = new ArrayList<>(args);

        addArg("--version", profile);
    }

    @Override
    protected MixinEnvironment.Side getMixinSide() {
        return MixinEnvironment.Side.SERVER;
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.server.MinecraftServer";
    }
}
