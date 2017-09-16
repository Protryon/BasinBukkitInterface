package org.basin.bukkit.block;

import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;

public class NativeNoteBlock extends NativeBlockState implements NoteBlock {
	
	@Override
	public Note getNote() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public byte getRawNote() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void setNote(Note note) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setRawNote(byte note) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean play(byte instrument, byte note) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean play(Instrument instrument, Note note) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
