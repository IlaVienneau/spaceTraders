package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class StarNameGenerator implements Serializable {
    private static final List<String> starNames = new ArrayList<>(Arrays.asList("Acamar", "Adahn", "Aldea",
            "Andevian", "Antedi", "Annabelle", "Balosnee", "Baratas", "Brax", "Bretel",
            "Beasley", "Calondia", "Campor", "Capellius", "Carzon", "Castor", "Cestus",
            "Cheron", "Courteney", "Daled", "Damast", "Davlos", "Deneb", "Deneva", "Devidia",
            "Dryalon", "Drema", "Endor", "Esmee", "Exo", "Ferris", "Festen", "Fourmi",
            "Frolix", "Gemulon", "Guinivere", "Hades", "Hamlet", "Helena", "Hulst", "Iodine",
            "Iralius", "Janus", "Japori", "Jarada", "Jason", "Kaylon", "Kratomicus", "Khefka",
            "Kira", "Kiatu", "Klaestron", "Kravat", "Krios", "Laertes", "Largo", "Lave", "Ligon",
            "Lowry", "Magrat", "Malcoria", "Brayden", "Caroline", "Ila", "William", "Ashley",
            "Melina", "Mentar", "Merik", "Mintaka", "Montor", "Mordan", "Myrthe", "Nelvana",
            "Nix", "Nyle", "Tommy", "Karl", "Henry", "Odet", "Og", "Omegasus", "Galactavapecus",
            "Othello", "Omphalos", "Orias", "Penthara", "Picardicus", "Pollux", "Quator", "Rakhar",
            "Ramzeus", "Rasperus", "Regulus", "Relva", "Rhymus", "Rochani", "Rubicum", "Rutia",
            "Sarpeidon", "Sefalla", "Shimilaka", "Seltrice", "Sigma", "Sol", "Somari", "Stakoron",
            "Styris", "Talani", "Tamus", "Tantalos", "Tanuga", "Tungaska", "Triacus", "Tarin",
            "Royazmuth", "Modthovan", "Thera", "Terosa", "Umberlyke", "Vagra", "Vadera", "Vandor",
            "Ventaxus", "Xenon", "Rufaas", "Xerxes", "Yewl", "Sourin", "Yojimbo", "Zalcon",
            "Zejuul", "Where's Bob"));

    /**
     * This method gets the name of the star, randomly generated
     * @return the name of the star that was randomly indexed
     */
    public static String getStarName() {
        Random rand = new Random();
        Map<Integer, String> names = new HashMap<>();
        int index = rand.nextInt(starNames.size());

        if (!names.isEmpty()) {
            String nameAtIndex = names.get(index);
            String starNameAtIndex = starNames.get(index);

            while ((names.get(index) != null) && nameAtIndex.equals(starNameAtIndex)) {
                index = rand.nextInt(132);
            }
        }
        names.put(index, starNames.get(index));

        return starNames.get(index);
    }


}
