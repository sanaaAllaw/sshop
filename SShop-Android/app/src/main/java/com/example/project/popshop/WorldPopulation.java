package com.example.project.popshop;

public class WorldPopulation {
    private String rank;
    private String country;
    private String population;
    private String imgS;

    public WorldPopulation(String rank, String country, String population, String imgs) {
        this.rank = rank;
        this.country = country;
        this.population = population;
        this.imgS=imgs;
    }

    public String getRank() {
        return this.rank;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPopulation() {
        return this.population;
    }

    public String getImgS() {
        return this.imgS;
    }
}
