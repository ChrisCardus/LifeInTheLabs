package com.graphics;

public class Avatars {

    @SuppressWarnings("unused")
	private int avatar;

    public Avatars(int avatar) {
        this.avatar = avatar;
    }
    /**
     * Takes an int and returns the avatar which that int corresponds to.
     * @param avatar The int which we need to convert to an avatar.
     * @return Returns an avatar corresponding to the int.
     */
    public static Avatars fromInt(int avatar) {
        Avatars temp = new Avatars(1);
        return temp;
    }

    /**
     * Takes an avatar variable and produces an int corresponding to that avatar.
     * @param avatar The avatar to convert.
     * @return Returns an int representing the avatar.
     */
    public static int toInt(Avatars avatar) {
        return 1;
    }
}