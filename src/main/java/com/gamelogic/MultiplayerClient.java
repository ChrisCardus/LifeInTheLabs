package com.gamelogic;

public class MultiplayerClient {

    int[][] positions = new int[10][2];
    int userID;

    public MultiplayerClient() {
        for(int i = 0; i < 10; i++) {
            positions[i][0] = 9;
            positions[i][1] = 6;
        }
    }

    public void updateLocation(int userID, int x, int y) {
        positions[userID][0] = x;
        positions[userID][1] = y;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}