package tora.mod.realisticScience;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class RealisticScienceTileentity extends TileEntity{
	
	private NBTTagCompound compound = new NBTTagCompound();
	
	@Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTagCompound);
	}
	
	@Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
        this.readFromNBT(pkt.data);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);      
        this.compound = par1NBTTagCompound.getCompoundTag("compound");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setCompoundTag("compound", this.compound);
    }
    
    public String getString(String key)
    {
       return this.compound.getString(key);
    }
    
    public void setString(String key, String value)
    {
       this.compound.setString(key, value);
    }
}