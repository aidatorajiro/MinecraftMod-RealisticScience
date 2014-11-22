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

public class RealisticScienceOre extends Block {
	//変数宣言＆コンストラクタ
	public RealisticScienceOre (int id, Material material) {
		super(id, material);
	}
}