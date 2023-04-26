package me.dasha.lab5.collectionClasses;

public class Coordinates {
    private int x; //Значение поля должно быть больше -623
    private double y; //Значение поля должно быть больше -347

    public Coordinates(int x, double y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
      this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

}

