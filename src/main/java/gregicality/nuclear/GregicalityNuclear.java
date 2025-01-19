package gregicality.nuclear;

import gregicality.GCYNInternalTags;
import gregicality.nuclear.api.util.GCYNLog;
import gregicality.nuclear.common.CommonProxy;
import gregicality.nuclear.common.blocks.GCYNMetaBlocks;
import gregicality.nuclear.common.item.GCYNMetaItems;
import gregicality.nuclear.common.metatileentities.GCYNMetaTileEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;

@Mod(modid = GCYNInternalTags.MODID,
        version = GCYNInternalTags.VERSION,
        name = GCYNInternalTags.MODNAME,
        dependencies = "required-after:gregtech@[2.8.10-beta,);",
        acceptedMinecraftVersions = "[1.12.2]")
public class GregicalityNuclear {

    @SidedProxy(modId = GCYNValues.MODID,
            clientSide = "gregicality.nuclear.common.ClientProxy",
            serverSide = "gregicality.nuclear.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(GCYNValues.MODID)
    public static GregicalityNuclear instance;

    @Mod.EventHandler
    public void onPreInit(@NotNull FMLPreInitializationEvent event) {
        GCYNLog.init(event.getModLog());

        GCYNMetaItems.initMetaItems();
        GCYNMetaBlocks.init();
        GCYNMetaTileEntities.init();

        proxy.preLoad();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        proxy.onPostLoad();
    }
}
