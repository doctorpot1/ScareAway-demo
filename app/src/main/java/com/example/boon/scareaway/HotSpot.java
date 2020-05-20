package com.example.boon.scareaway;

import java.util.List;

public class HotSpot {
    private double lat;
    private double lon;
    private int rad;
    private String title;
    private String snippet;
    private int color;

    public HotSpot(double lat, double lon, int rad, String title, String snippet, String color) {
        this.lat = lat;
        this.lon = lon;
        this.rad = rad;
        this.title = title;
        this.snippet = snippet;
        this.color = ConvertTextToColor(color);
    }

    public HotSpot(double lat, double lon, int rad, String title, String snippet, int color) {
        this.lat = lat;
        this.lon = lon;
        this.rad = rad;
        this.title = title;
        this.snippet = snippet;
        this.color = color;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int ConvertTextToColor(String color) {
        color = color.toLowerCase();
        switch (color) {
            case "r":
            case "red":
                return 0x40ff0000;
            case "o":
            case "orange":
                return 0x40ff8c00;
            case "y":
            case "yellow":
                return 0x40ffd700;
            default:
                return 0x409400d3;
        }
    }
}
