package com.example.spacetrader.entity;
import java.util.Random;

public class Universe {
    Star[] stars;
    int numTypes;

    /*
     * Creates a universe with 'size' # of stars
     * options for size:
     *      small: 50 -> 400 planets
     *      medium: 75 -> 600 planets
     *      large: 100 -> 800 planets
     *
     *      creates enough space for a 1:4 ratio of
     *      planet to empty space
     */
    public Universe(int size) {
        int max;
        if (size <= 50) {
            max = 8;//15; //sqrt of 250
        } else if (size <= 75) {
            max = 9;//20; //sqrt of 375
        } else {
            max = 10;//25; //sqrt of 500
        }
        //create a random integer btwn 0 and 100, if it falls btwn 0 and 55 make it main etc
        //index into the array of the enum to get star types
        StarType[] types = new StarType[numTypes];
        int k = 0;
        for (StarType type : StarType.values()) {
            types[k] = (type);
            k++;
        }

        Random rand = new Random();
        int i = 0;
        for (int col = 0; col < max; col++) {
            for (int row = 0; row < max; row++) {
                int t = rand.nextInt(101);
                StarType star;
                if (t <= 55) {
                    star = types[0];
                } else if (t <= 68) {
                    star = types[1];
                } else if (t <= 78) {
                    star = types[2];
                } else if (t <= 84) {
                    star = types[3];
                } else if (t <= 96) {
                    star = types[4];
                } else {
                    star = types[5];
                }
                //row, col
                stars[i] = new Star("name", star, row*3, col*3);
                i++;
            }
        }
    }

}
