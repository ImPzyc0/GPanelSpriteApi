package com.daniel.GSprite.Sprites.HitboxSprites;

/**
 * The interface for the collides, you will get a concurrentModificationError when removing objects in the listener! Remove them afterwards!
 *
 *
 *
 */
public interface CollideEventListener {

    void onHitboxEnter(HitboxSprite sprite);
    void onHitboxStay(HitboxSprite sprite);
    void onHitboxExit(HitboxSprite sprite);

}
