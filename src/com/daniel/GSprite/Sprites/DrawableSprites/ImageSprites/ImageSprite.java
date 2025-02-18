package com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites;

import com.daniel.GSprite.Util.Vector2D;

/**
 * The interface for all Sprites with an image displayed on them
 *
 *
 *
 */
public interface ImageSprite {

    void setSize(Vector2D size);
    Vector2D getSize();

    void setImage(String path);

    String getPath();
}
