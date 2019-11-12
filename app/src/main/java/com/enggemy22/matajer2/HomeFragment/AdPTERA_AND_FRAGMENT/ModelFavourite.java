package com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT;

public class ModelFavourite {

    private int Image;
    private int Imagefavourite;
    private String Text;
    private String TextNumber;


    public ModelFavourite() {
        //empty constractor;
    }

    public ModelFavourite(int image, int imagefavourite, String text, String textNumber) {
        Image = image;
        Imagefavourite = imagefavourite;
        Text = text;
        TextNumber = textNumber;
    }

    public int getImage() {
        return Image;
    }

    public int getImagefavourite() {
        return Imagefavourite;
    }

    public String getText() {
        return Text;
    }

    public String getTextNumber() {
        return TextNumber;
    }
}
