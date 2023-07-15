package baseScrabble;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Word implements Serializable{


	private static final long serialVersionUID = 1L;
	private Tile[] tiles;
	private int row,col;
	private boolean vertical;
	
	public Word(Tile[] tiles, int row, int col, boolean vertical) {
		super();
		this.tiles = tiles;
		this.row = row;
		this.col = col;
		this.vertical = vertical;
	}
	
	public Word(ArrayList<Tile> tiles, int row, int col, boolean vertical) {
		  super();
		  Tile [] tilesArr = Tile.arrayList_Tile_To_Arr(tiles);
		  this.tiles = tilesArr;
		  this.row = row;
		  this.col = col;
		  this.vertical = vertical;
		 }
	
	
	
	private String arrToString(Tile[] tiles) {
		String str="[";
		for(Tile t:tiles) {
			str+=t.toString();
		}
		str+="]";
		return str;
	}
	public String getString() {
		String str= "{tiles:"+arrToString(this.tiles)+"endArr"+",row:"+row+",col:"+col+",vertical:"+vertical+"}";
		return str;
		
	}
	
	public Tile[] getTiles() {
		return tiles;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isVertical() {
		return vertical;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(tiles);
		result = prime * result + Objects.hash(col, row, vertical);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return col == other.col && row == other.row && Arrays.equals(tiles, other.tiles) && vertical == other.vertical;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(Tile t : tiles)
			sb.append(t.letter);
		sb.append(" ("+row+","+col+") "+(vertical?"vertical":"horizontal"));
		return sb.toString();
	}
	
	public String createSimpleString() {
		StringBuilder sb=new StringBuilder();
		for(Tile t : tiles)
			sb.append(t.letter);
		return sb.toString();
	}
	
}
