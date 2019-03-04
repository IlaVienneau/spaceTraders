package com.example.spacetrader.entity;
import java.util.HashMap;
import java.util.Random;

public class Universe {
    Star[] stars;
    int numTypes = 6;

    /*
     * Creates a universe with 'size' # of stars
     * options for size:
     *      small: 50 -> 400 planets
     *      medium: 75 -> 600 planets
     *      large: 100 -> 800 planets
     *
     *      creates enough space for a 1:4 ratio of
     *      star to empty space e.g. 50*5 = 250
     */
    public Universe(int size) {
        stars = new Star[size];
        int max;
        if (size <= 50) {
            max = 15; //sqrt of 250
        } else if (size <= 75) {
            max = 20; //sqrt of 375
        } else {
            max = 25; //sqrt of 500
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
        HashMap<Integer, Integer> coordinates = new HashMap<>();
        for (int i = 0; i < size; i++) {
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
                //each key is x + y, each value is x
                int x = rand.nextInt(max);
                int y = rand.nextInt(max);
                if (!coordinates.isEmpty()) {
                    while (coordinates.get(x+y) != null && coordinates.get(x+y) == x) {
                        x = rand.nextInt(max);
                        y = rand.nextInt(max);
                    }
                }
                coordinates.put(x+y, x);
                stars[i] = new Star("name", star, x, y);
        }
    }

    public String toString() {
        String str = "Fire Cobra-verse:  \n";
        for (Star s: stars) {
            str += s.toString() + "\n";
        }
        return str;
    }

}
