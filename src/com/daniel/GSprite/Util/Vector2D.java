package com.daniel.GSprite.Util;

import org.jetbrains.annotations.NotNull;

/**
 *
 *Class for the Vectors, has an x and y coordinate
 *
 *
 */
public class Vector2D {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Vector2D(@NotNull Vector2D vec){
        this.x = vec.getX();
        this.y = vec.getY();
    }

    public static Vector2D vec(double x, double y){
        return new Vector2D(x, y);
    }

}
