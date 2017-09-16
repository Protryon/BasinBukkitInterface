package org.basin.bukkit.block;

import java.util.Set;
import org.bukkit.Server;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class NativeCommandBlock extends NativeBlockState implements CommandBlock, BlockCommandSender {
	
	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setCommand(String command) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sendMessage(String[] messages) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isPermissionSet(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isPermissionSet(Permission perm) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean hasPermission(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean hasPermission(Permission perm) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void removeAttachment(PermissionAttachment attachment) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void recalculatePermissions() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isOp() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void setOp(boolean value) {
		// TODO Auto-generated method stub
		
	}
	
}
