package com.daniel.GSprite.Sprites.HitboxSprites;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.PositionSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.HitboxType;
import com.daniel.GSprite.Util.Vector2D;

import java.util.ArrayList;
import java.util.List;

/**
 * A sprite with a rectangle hitbox, can have a listener
 *
 *
 *
 */
public class RectangleHitboxSprite extends PositionSprite implements HitboxSprite {

    protected boolean active = true;

    protected Vector2D hitboxSize;
    protected CollideEventListener listener = null;

    private List<HitboxSprite> collidedWithLastFrame = new ArrayList<>();

    public RectangleHitboxSprite(Vector2D position, GPanel panel, Vector2D hitboxSize) {
        super(position, panel);

        this.hitboxSize = hitboxSize;
    }

    public RectangleHitboxSprite(Vector2D position, GUtility util, Vector2D hitboxSize) {
        super(position, util);
        this.hitboxSize = hitboxSize;
    }

    @Override
    public boolean collides(Vector2D vector) {

        return active && (vector.getX() >= getHitboxPosition().getX() - (hitboxSize.getX() / 2) && vector.getX() <= getHitboxPosition().getX() + (hitboxSize.getX() / 2)) && (vector.getY() >= getHitboxPosition().getY() - (hitboxSize.getY() / 2) && vector.getY() <= getHitboxPosition().getY() + (hitboxSize.getY() / 2));
    }

    @Override
    public boolean collides(HitboxSprite hitbox) {

        if(!active || !hitbox.getActive()) return false;
        //Circle
        if(hitbox.getType() == HitboxType.CIRCLE) {
            for (double x = -(hitboxSize.getX() / 2); x <= (hitboxSize.getX() / 2); x++) {
                for (double y = -(hitboxSize.getY() / 2); y <= (hitboxSize.getY() / 2); y++) {
                    if (hitbox.collides(new Vector2D(x + position.getX(), y + position.getY()))) return true;
                }
            }
        //Rectangle
        } else if(hitbox.getType() == HitboxType.RECTANGLE){
            return collides(new Vector2D(hitbox.getHitboxPosition().getX() - (hitbox.getSize().getX() / 2), hitbox.getHitboxPosition().getY() - (hitbox.getSize().getY() / 2))) ||
                    collides(new Vector2D(hitbox.getHitboxPosition().getX() - (hitbox.getSize().getX() / 2), hitbox.getHitboxPosition().getY() + (hitbox.getSize().getY() / 2))) ||
                    collides(new Vector2D(hitbox.getHitboxPosition().getX() + (hitbox.getSize().getX() / 2), hitbox.getHitboxPosition().getY() - (hitbox.getSize().getY() / 2))) ||
                    collides(new Vector2D(hitbox.getHitboxPosition().getX() + (hitbox.getSize().getX() / 2), hitbox.getHitboxPosition().getY() + (hitbox.getSize().getY() / 2)));
        }

        return false;
    }

    @Override
    public HitboxType getType() {
        return HitboxType.RECTANGLE;
    }

    @Override
    public Vector2D getSize() {
        return hitboxSize;
    }

    @Override
    public Vector2D getHitboxPosition() {
        return position;
    }

    @Override
    public void setListener(CollideEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void removeListener() {
        this.listener = null;
    }

    @Override
    public boolean isListening() {
        return listener != null;
    }

    @Override
    public void updateListener(List<HitboxSprite> collidingWith) {
        for(HitboxSprite sprite : collidingWith){
            if(sprite == this) continue;
            if(collidedWithLastFrame.contains(sprite)){
                listener.onHitboxStay(sprite);

            }else{
                listener.onHitboxEnter(sprite);

            }
        }

        for(HitboxSprite sprite : collidedWithLastFrame){
            if(sprite == this) continue;
            if(!collidingWith.contains(sprite)){
                listener.onHitboxExit(sprite);
            }
        }

        collidedWithLastFrame = collidingWith;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean getActive() {
        return active;
    }

    @Override
    public void move(Vector2D vec) {
        position.setX(vec.getX()+position.getX());
        position.setY(vec.getY()+position.getY());
    }
}
