package tora.mod.realisticScience.machines;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import tora.mod.realisticScience.RealisticScienceMachine;
import tora.mod.realisticScience.RealisticScienceTileentity;
import tora.mod.realisticScience.tileentities.TileentityPipeBasic;

public class PipeBasic extends RealisticScienceMachine {
	public PipeBasic() {
		super(Material.rock);
		setUnlocalizedName("pipeBasic");
		setCreativeTab    (CreativeTabs.tabAllSearch);
		setHardness       (1F);
		setResistance     (1F);
		setStepSound      (Block.soundTypeStone);
		setHarvestLevel("pickaxe", 0);
		
		GameRegistry.registerBlock(this, "pipeBasic");
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileentityPipeBasic();
	}
}
