package tora.mod.realisticScience.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import tora.mod.realisticScience.CommonProxy;
import tora.mod.realisticScience.RealisticScience;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void init(FMLInitializationEvent event) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(RealisticScience.oreSmelting), 0, new ModelResourceLocation("realisticscience:oreSmelting", "inventory"));
	}
}