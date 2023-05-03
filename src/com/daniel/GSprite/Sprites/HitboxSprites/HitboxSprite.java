package com.daniel.GSprite.Sprites.HitboxSprites;

import com.daniel.GSprite.Util.HitboxType;
import com.daniel.GSprite.Util.Vector2D;

import java.util.List;

/**
 * Interface for all hitboxes, used especially in collides
 *
 *
 *
 */
public interface HitboxSprite {

    boolean collides(Vector2D vector);
    boolean collides(HitboxSprite hitbox);

    HitboxType getType();

    Vector2D getSize();

    Vector2D getHitboxPosition();

    void setListener(CollideEventListener listener);

    void removeListener();

    boolean isListening();

    void updateListener(List<HitboxSprite> collidingWith);

    void setActive(boolean active);
    boolean getActive();
}
