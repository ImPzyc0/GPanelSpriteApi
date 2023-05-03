package com.daniel.GSprite.Sprites;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

/**
 * The super of all sprites, has a position, a panel and a possible util
 *
 *
 *
 */
public abstract class PositionSprite {
    protected Vector2D position;
    protected final GPanel panel;
    protected GUtility util;

    public PositionSprite(Vector2D position, GPanel panel){
        this.position = position;
        this.panel = panel;
        this.util = null;
    }

    public PositionSprite(Vector2D position, GUtility util){
        this.position = position;
        this.panel = util.getPanel();
        this.util = util;
        util.addSprite(this);
    }

    public abstract void move(Vector2D vec);


    public void setPosition(Vector2D vec){
        this.position = vec;
    }
    public Vector2D getPosition() {
        return new Vector2D(position);
    }

    public void remove(){
        if(util != null) this.util.removeSprite(this);
    }

    public void setUtil(GUtility util){
        if(util.getPanel() != panel) return;

        this.util = util;
    }

}
