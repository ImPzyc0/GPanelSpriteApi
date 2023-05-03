package com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites.ColoredSprite;
import com.daniel.GSprite.Sprites.DrawableSprites.DrawableSprite;
import com.daniel.GSprite.Sprites.HitboxSprites.RectangleHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import java.awt.*;

/**
 * A sprite with a rectangular hitbox and color
 *
 *
 *
 */
public class RectangleColoredHitboxSprite extends RectangleHitboxSprite implements DrawableSprite, ColoredSprite {

    protected Color color;
    protected boolean fill;

    public RectangleColoredHitboxSprite(Vector2D position, GPanel panel, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, panel, hitboxSize);
        this.color = color;
        this.fill = fill;
    }

    public RectangleColoredHitboxSprite(Vector2D position, GUtility util, Vector2D hitboxSize, Color color, boolean fill) {
        super(position, util, hitboxSize);
        this.color = color;
        this.fill = fill;
    }


    @Override
    public void draw() {
        panel.move(position.getX(), position.getY());
        panel.color(color);
        if(fill){
            panel.fillRectangle(hitboxSize.getX(), hitboxSize.getY());
        }else{
            panel.rectangle(hitboxSize.getX(), hitboxSize.getY());
        }
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
}
