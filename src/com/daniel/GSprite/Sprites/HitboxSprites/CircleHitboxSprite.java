package com.daniel.GSprite.Sprites.HitboxSprites;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.PositionSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.HitboxType;
import com.daniel.GSprite.Util.Vector2D;

import java.util.ArrayList;
import java.util.List;

/**
 *  A sprite with a circle hitbox, can have a listener
 *
 *
 *
 */
public class CircleHitboxSprite extends PositionSprite implements HitboxSprite {

    protected boolean active = true;

    protected double size;
    protected CollideEventListener listener = null;

    private List<HitboxSprite> collidedWithLastFrame = new ArrayList<>();

    public CircleHitboxSprite(Vector2D position, GPanel panel, double size) {
        super(position, panel);
        this.size = size;
    }

    public CircleHitboxSprite(Vector2D position, GUtility util, double size) {
        super(position, util);
        this.size = size;
    }

    @Override
    public boolean collides(Vector2D vector) {
        return active && Math.pow(position.getX() - vector.getX(), 2) + Math.pow(position.getY() - vector.getY(), 2) > Math.pow(size, 2);
    }

    @Override
    public boolean collides(HitboxSprite hitbox) {
        if(!active || !hitbox.getActive()) return false;

        if(hitbox.getType() == HitboxType.CIRCLE){
            if(hitbox.getSize().getX()+size > Math.sqrt(Math.pow(hitbox.getHitboxPosition().getX()-position.getX(), 2)+ Math.pow(hitbox.getHitboxPosition().getY()-position.getY(), 2))){
                return true;
            }
            return false;
        }else{
            return hitbox.collides(this);
        }
    }

    @Override
    public HitboxType getType() {
        return HitboxType.CIRCLE;
    }

    @Override
    public Vector2D getSize() {
        return new Vector2D(size, size);
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
