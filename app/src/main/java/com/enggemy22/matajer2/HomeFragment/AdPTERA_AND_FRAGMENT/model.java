package com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT;

public class model {
    String name;
    String id;
    int imageRecource;

    public model(String name, String id, int imageRecource) {
        this.name = name;
        this.id = id;
        this.imageRecource = imageRecource;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getImageRecource() {
        return imageRecource;
    }
}
