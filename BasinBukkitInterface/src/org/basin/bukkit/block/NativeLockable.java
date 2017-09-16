package org.basin.bukkit.block;

import org.bukkit.block.Lockable;

public class NativeLockable extends NativeBlockState implements Lockable {
	
	public NativeLockable() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getLock() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setLock(String key) {
		// TODO Auto-generated method stub
		
	}
	
}
