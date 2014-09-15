package tora.mod.realisticScience;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

public class RealisticScienceBlock extends Block {
	//変数宣言＆コンストラクタ
	public RealisticScienceBlock (int id, Material material, String name, CreativeTabs creativetab, float hardness, float resistance, StepSound stepsound, String texturename, String harvesttool, int harvestlevel) {
		super(id, material);
		setUnlocalizedName(name);
		setCreativeTab    (creativetab);
		setHardness       (hardness);
		setResistance     (resistance);
		setStepSound      (stepsound);
		setTextureName    (texturename);
		
		MinecraftForge.setBlockHarvestLevel(this, harvesttool, harvestlevel);
		GameRegistry.registerBlock(this, name);
	}
	
	//テクスチャ操作
	public void changeTexture(String src) {
		setTextureName(src);
	}
	
	//ドロップ操作
	public int   dropItemBlockID  = this.blockID;
	public float dropItemQuantity = 1;
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return dropItemBlockID;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return (int)(Math.floor(dropItemQuantity) + ((random.nextFloat() < dropItemQuantity - Math.floor(dropItemQuantity)) ? 1.0F : 0.0F));
	}
	
	//メタデータ操作
	public void newMetadata(String key, String value) {
		
	}
}