package tora.mod.realisticScience;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RealisticScienceMachine extends BlockContainer {
	public RealisticScienceMachine (int id, Material material) {
		super(id, material);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new RealisticScienceTileentity();
	}
}