package com.example.spacetrader.entity;
import java.util.HashMap;
import java.util.Random;
import java.io.Serializable;

import static com.example.spacetrader.entity.StarNameGenerator.getStarName;

public class Universe implements Serializable {
    private static HashMap<String, Star> stars;
    private static int numTypes = 6;
    private static int numLevels = 8;
    private static int numPolitical = 17;
    private static int numResources = 13;


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
        stars = new HashMap<>();
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
        Random rand = new Random();

        StarType[] types = new StarType[numTypes];
        int k = 0;
        for (StarType type : StarType.values()) {
            types[k] = (type);
            k++;
        }

        TechLevel[] levels = new TechLevel[numLevels];
        k = 0;
        for (TechLevel level : TechLevel.values()) {
            levels[k] = (level);
            k++;
        }


        Resource[] res = new Resource[numResources];
        k = 0;
        for (Resource r : Resource.values()) {
            res[k] = (r);
            k++;
        }

        PoliticalSystem[] poly = new PoliticalSystem[numPolitical];
        k = 0;
        for (PoliticalSystem p : PoliticalSystem.values()) {
            poly[k] = (p);
            k++;
        }


        HashMap<Integer, Integer> coordinates = new HashMap<>();
        for (int i = 0; i < size; i++) {
                int t = rand.nextInt(101);
                TechLevel tech = levels[rand.nextInt(numLevels)];
                Resource resource = res[rand.nextInt(numResources)];
                PoliticalSystem political = poly[rand.nextInt(numPolitical)];

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

                if (i == 0) {
                    Star paradise = new Star("Paradise", star, x, y,  Resource.NOSPECIALRESOURCES,
                            TechLevel.POSTINDUSTRIAL, PoliticalSystem.DEMOCRACY);
                    paradise.addPlanet(new Planet("Paradise-1", TechLevel.POSTINDUSTRIAL, PoliticalSystem.DEMOCRACY,
                            Resource.NOSPECIALRESOURCES, paradise));
                    stars.put("Paradise", paradise);
                } else {
                    String str = getStarName();
                    stars.put(str, new Star(str, star, x, y, resource, tech, political));
                }
        }
    }

    public HashMap<String, Star> getStars() {
        return stars;
    }

    public String toString() {
        String str = "Fire Cobra-verse:  \n";
        for (Star s: stars.values()) {
            str += s.toString() + "\n";
        }
        return str;
    }

    public static Planet getPlanet(String name, int num) {
        return stars.get(name).getPlanet(name + "-" + num);
    }


}
