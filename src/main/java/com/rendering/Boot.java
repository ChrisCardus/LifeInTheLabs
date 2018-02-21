package com.rendering;

import com.gamelogic.Friend;
import com.gamelogic.Player;
import org.lwjgl.opengl.Display;

import static com.rendering.Creator.*;

public class Boot {

    public Boot(){

        BeginSession();

        int[][] map = {
                {6 , 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}

        };

        TileGrid grid = new TileGrid(map);


        Player player = new Player(QuickLoad("player"),grid.getTile(0,1), 64,64,0.5f, "Ollie", 1547484);
        Friend friend = new Friend(QuickLoad("friend"),grid.getTile(4,5), 64,64,0.5f);

        while ((!Display.isCloseRequested())){
            Clock.update();


            grid.Draw();
            player.update();
            friend.update();


            Display.update();
            Display.sync(60);
        }

        Display.destroy();
    }

    public static void main(String [] args){
        new Boot();
    }
}
