package adventOfCode.day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Grid {
	protected final List<List<Light>> grid;
	protected final int lines;
	protected final int columns;
	protected Grid(String grid) {
		this.grid = new ArrayList<List<Light>>();
		for(String stringLine : grid.split("\n")){
			List<Light> line = new ArrayList<Light>();
			for(char charLight : stringLine.toCharArray())
				line.add(Light.valueOf(charLight));
			this.grid.add(line);
		}
		lines = this.grid.size();
		columns = lines>0? this.grid.get(0).size() : 0;
	}
	protected Grid(List<List<Light>> grid){
		this.grid = grid;
		lines = grid.size();
		columns = lines>0? grid.get(0).size() : 0;
	}
	
	public int getLines() {
		return lines;
	}
	public int getColumns() {
		return columns;
	}
	public int countOn(){
		I count = new I(0);
		grid.forEach((line)->line.forEach((light)->{
			if(light.equals(Light.ON))
				count.value++;
		}));
		return count.value;
	}
	public int countOff(){
		I count = new I(0);
		grid.forEach((line)->line.forEach((light)->{
			if(light.equals(Light.OFF))
				count.value++;
						}));
		return count.value;
	}
	public Light getLight(Coordinate c) {
		return grid.get(c.line).get(c.column);
	}
	
	public Grid getSurrounding(Coordinate c){
		List<Light> surrounding = new ArrayList<Light>();
		surroundingCoordinates(c).forEach((coordinate)->surrounding.add(getLight(coordinate)));
		return new Grid( Collections.singletonList(surrounding));
	}
	private List<Coordinate> surroundingCoordinates(Coordinate source){
		List<Coordinate> unchecked = new ArrayList<Coordinate>();
		unchecked.add(new Coordinate(source.line-1,source.column-1));
		unchecked.add(new Coordinate(source.line-1,source.column  ));
		unchecked.add(new Coordinate(source.line-1,source.column+1));
		unchecked.add(new Coordinate(source.line,  source.column-1));
		unchecked.add(new Coordinate(source.line,  source.column+1));
		unchecked.add(new Coordinate(source.line+1,source.column-1));
		unchecked.add(new Coordinate(source.line+1,source.column  ));
		unchecked.add(new Coordinate(source.line+1,source.column+1));
		List<Coordinate> surrounding = new ArrayList<Coordinate>();
		unchecked.forEach((c)->{
			if(c.line >= 0 && c.column >= 0 &&
				c.line < lines && c.column < columns)
				surrounding.add(c);
		});
		return surrounding;
	}
	
	public boolean equals(Object other) {
		return this.getClass().isInstance(other) && equalsSize((Grid)other) && equalsValue((Grid)other);
	}
	private boolean equalsSize(Grid other) {
		return (this.grid.size() == other.grid.size()) && 
			   (this.grid.get(0).size() == other.grid.get(0).size());
	}
	private boolean equalsValue(Grid other) {
		boolean result = true;
		for(int line =0;line<grid.size();line++)
			for(int column =0;column<grid.size();column++){
				Coordinate c = new Coordinate(line,column);
				if(!this.getLight(c).equals(other.getLight(c)))
					result = false;
			}				
		return result;
	}
	
	public String toString(){
		return grid.toString();
	}
	
	private class I{
		private int value;
		private I(int value){this.value = value;}
	}
}