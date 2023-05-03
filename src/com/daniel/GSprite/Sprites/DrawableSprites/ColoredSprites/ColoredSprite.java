package com.daniel.GSprite.Sprites.DrawableSprites.ColoredSprites;

import java.awt.*;

/**
 * The interface for all sprites with a color
 *
 *
 *
 */
public interface ColoredSprite {

    void setColor(Color color);
    Color getColor();

    void setFill(boolean fill);
    boolean getFill();

}
