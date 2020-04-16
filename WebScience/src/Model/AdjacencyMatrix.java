package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Datamining.Datacompiler;

public class AdjacencyMatrix {
	//has two build methods, choose whichever works best for the data available
	//build1 works for one large set of games with a webstore variable
	private Map<Game, ArrayList<Integer>> matrix = new HashMap<Game, ArrayList<Integer>>();
	
	public Map<Game, ArrayList<Integer>> build1(List<Game> gamelist){
		for(Game i : gamelist) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			if(i.getWebshop() == "Both") {
				row.add(1,1);
			}
			if(i.getWebshop() == "Steam") {
				row.add(1, 0);
			}
			else {
				row.add(0,1);
			}
			matrix.put(i, row);
		}
		
		return matrix;
	}
	
	//build2 works with 2 sets of games and comparing them
	public Map<Game, ArrayList<Integer>> build2(List<Game> steam, List<Game> epic){
		for(Game i : steam) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for(Game j : epic) {
				if (i.getName() == j.getName()) {
					row.add(1,1);
					matrix.put(i, row);
				}
				else {
					//works since HashMaps don't take duplicates
					row.add(0,1);
					matrix.put(j, row);
				}
			}
			row.clear();
			row.add(1,0);
		}
		
		return matrix;
		
	}
}
