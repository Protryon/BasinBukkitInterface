package org.basin.bukkit.block;

import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;

public class NativeSkull extends NativeBlockState implements Skull {
	
	@Override
	public boolean hasOwner() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getOwner() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean setOwner(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public OfflinePlayer getOwningPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setOwningPlayer(OfflinePlayer player) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BlockFace getRotation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setRotation(BlockFace rotation) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public SkullType getSkullType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setSkullType(SkullType skullType) {
		// TODO Auto-generated method stub
		
	}
	
}
