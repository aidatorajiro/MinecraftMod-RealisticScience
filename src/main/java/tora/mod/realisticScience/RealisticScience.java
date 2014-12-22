package tora.mod.realisticScience;

import tora.mod.realisticScience.ores.OreSmelting;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="RealisticScience", name="RealisticScience", version="0.0.0")
@NetworkMod(clientSideRequired=true)
public class RealisticScience {
	// The instance of your mod that Forge uses.
	@Instance(value = "RealisticScience")
	public static RealisticScience instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="tora.mod.realisticScience.client.ClientProxy", serverSide="tora.mod.realisticScience.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//====================================//
		//          Ores - Overworld          //
		//====================================//
		
		OreSmelting oreSmelting = new OreSmelting(1000);
		
		//====================================//
		//          Machines - Pipes          //
		//====================================//
		
		//----- Pipe -----
		
		//----- PiCharm -----
		
		//----- Pipe on Rails -----
		
		//----- NetBeams -----
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
        
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}