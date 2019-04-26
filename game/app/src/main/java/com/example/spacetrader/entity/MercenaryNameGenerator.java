package com.example.spacetrader.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MercenaryNameGenerator implements Serializable {
    private static List<String> mercNames = new ArrayList<>(Arrays.asList(
            "Fabian", "Suzan", "Audrea", "Giovanna", "Rosalva", "Nu", "Eartha",
            "Mercy", "Spring", "Nieves", "Alma", "Malorie", "Abbey", "Carley",
            "Cindi", "Suzann", "Esmeralda", "Hallie", "Laurence", "Laci", "Vivian",
            "Tiffany", "Marcia", "Roxane", "Latrina", "George", "Alleen", "Raelene",
            "Janelle", "Denis", "Roselee", "Rey", "Lore", "Merrie", "Mikel", "Arcelia",
            "Jay", "Diedra", "Fallon", "Iola", "Lily", "Cassidy", "Naida", "Eveline",
            "Rolande", "Greta", "Samira", "Dina", "Kami", "Taisha", "Robbie", "Eli",
            "Jeffry", "Warren", "Armand", "Kraig", "Robt", "Dustin", "Oren", "Clemente",
            "Philip", "Ronnie", "Sidney", "Chang", "Leon", "Lindsey", "Lindsay", "Edmundo",
            "Thurman", "Huey", "Irvin", "Lacy", "Timmy", "Dominick", "Carlton", "Carmen",
            "Johnny", "Mauricio", "Nigel", "Lee", "Gerry", "Ervin", "Lincoln", "Maurice",
            "Cornelius", "Garret", "Thanh", "Eduardo", "Charlie", "Eldon", "Joesph",
            "Ernesto", "Rodolfo", "Young", "Pierre", "Gino", "Zane", "Carlos", "Donnell",
            "Frances", "Ilda", "Tonda", "Shaunda", "Un", "Annita", "Dionne", "Suk",
            "Ling", "Erinn", "Nery", "Lydia", "Jeffie", "Heather", "Savannah", "Inocencia",
            "Floretta", "Takisha", "Nathalie", "Fae", "Dennise", "Christina", "Elizebeth",
            "Jinny", "Johana", "Valrie", "Sandi", "Shanell", "Marguerite", "Kiersten",
            "Rheba", "Eugenia", "Camilla", "Willena", "Elodia", "Yoshie", "Jaqueline",
            "Elnora", "Lashonda", "Illa", "Mollie", "Rafaela", "Hyacinth", "Shauna",
            "Marilyn", "Aleisha", "Lilia", "Julee", "Danyelle", "Romelia", "Tonya",
            "Marjorie Shoaff", "Apryl Faucher", "Detra Buhr", "Julie Gerber",
            "Curt Hoag", "Quentin Mitcham", "Lona Tartaglia", "Lavada Dowdy",
            "Nicole Whitton", "Linwood Cone", "August Janecek", "Morris Marnell",
            "Pearle Camille", "Hanh Meares", "Bryon Hara", "Agripina Colburn",
            "Violette Wease", "Sal Grajales", "Suzann Redmon", "Nakesha Zona",
            "Brayden", "Ashely", "Ila", "Caroline", "William", "Bob"));

    public static String getMercName() {
        Random rand = new Random();
        int index1 = rand.nextInt(mercNames.size());
        int index2 = rand.nextInt(mercNames.size());

        String name = mercNames.get(index1) + " " + mercNames.get(index2);

        return name;
    }
}
