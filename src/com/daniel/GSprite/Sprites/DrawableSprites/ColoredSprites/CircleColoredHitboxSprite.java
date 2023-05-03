package com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.ColoredSprite;
import com.daniel.GSprite.Sprites.DrawableSprites.DrawableSprite;
import com.daniel.GSprite.Sprites.HitboxSprites.CircleHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

/**
 * A sprite with a circular hitbox and color
 *
 *
 *
 */
public class CircleColoredHitboxSprite extends CircleHitboxSprite implements ColoredSprite, DrawableSprite {

    protected Color color;
    protected boolean fill;

    public CircleColoredHitboxSprite(Vector2D position, GPanel panel, double size, Color color, boolean fill) {
        super(position, panel, size);
        this.color = color;
        this.fill = fill;
    }

    public CircleColoredHitboxSprite(Vector2D position, GUtility util, double size, Color color, boolean fill) {
        super(position, util, size);
        this.color = color;
        this.fill = fill;
    }


    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public boolean getFill() {
        return fill;
    }

    @Override
    public void draw() {
        panel.move(position.getX(), position.getY());

        panel.color(color);
        if(fill){
            panel.fillCircle(size);
        }else{
            panel.circle(size);
        }
    }
}
