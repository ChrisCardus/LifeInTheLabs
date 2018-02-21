package ui;

import com.rendering.TileGrid;

import gamelogic.Player;

public class Game {

		private TileGrid grid;
		private Player player;
		
		
		
		public Game(int[][] map) {
			
			grid = new TileGrid(map);
		//	player = new Player(grid);
			
		}
		
		public void update(){
			grid.Draw();
		}
}
