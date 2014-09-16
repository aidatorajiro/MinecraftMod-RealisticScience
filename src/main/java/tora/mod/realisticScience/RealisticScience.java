package tora.mod.realisticScience;

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
		//===== oreSmelting =====
		RealisticScienceBlock oreSmelting = new RealisticScienceBlock(
		999, Material.rock,                       //id, material
		"oreSmelting", CreativeTabs.tabAllSearch, //name, creativetabs
		1F, 1F, Block.soundStoneFootstep,         //hardness, resistance, footstep
		"realisticscience:oresmelting",           //texturename
		"pickaxe", 0                              //tool, toollevel
		) {
			@Override
			public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {
				if (!par1World.isRemote) {
					par1World.createExplosion(null, (double)par2, (double)par3, (double)par4, 2F, true);
					par1World.setBlock(par2, par3, par4, lavaMoving.blockID);
				}
			}
			
			@Override
			public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
				if (!par1World.isRemote) {
					onBlockDestroyedByExplosion(par1World, par2, par3, par4, null);
				}
			}
		};
		oreSmelting.dropItemQuantity = 0;
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
        
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}