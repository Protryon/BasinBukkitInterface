package org.basin.bukkit.advancement;

import java.util.Collection;
import java.util.Date;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;

public class NativeAdvancementProgress implements AdvancementProgress {
	
	public NativeAdvancementProgress() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Advancement getAdvancement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean awardCriteria(String criteria) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean revokeCriteria(String criteria) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Date getDateAwarded(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection<String> getRemainingCriteria() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection<String> getAwardedCriteria() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
