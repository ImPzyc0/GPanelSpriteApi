package com.daniel.GSprite.Util;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.DrawableSprite;
import com.daniel.GSprite.Sprites.HitboxSprites.HitboxSprite;
import com.daniel.GSprite.Sprites.PositionSprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Basically a manager with a panel for all sprites, needs PositionSprites, will check the collides with .updateHitboxListener
 *
 *
 *
 */
public class GUtility {

    private final GPanel panel;

    private final ArrayList<PositionSprite> sprites;

    private final ArrayList<DrawableSprite> drawableSprites;

    private final ArrayList<HitboxSprite> hitboxSprites;

    public GUtility(int width, int height){
        panel = new GPanel();
        panel.windowSize(width,height);
        panel.window(0, panel.getWindow().getWidth(), 0, panel.getWindow().getHeight());
        panel.resizable(false);

        this.sprites = new ArrayList<>();
        this.hitboxSprites = new ArrayList<>();
        this.drawableSprites = new ArrayList<>();
    }

    public GPanel getPanel(){return panel;}

    public ArrayList<PositionSprite> getSprites(){
        return (ArrayList<PositionSprite>) sprites.clone();
    }

    public void draw(){
        for(DrawableSprite sprite : drawableSprites){
            sprite.draw();
        }
    }

    public void addSprite(PositionSprite... sprite){
        sprites.addAll(Arrays.asList(sprite));
        for(PositionSprite temp : sprite) {if(temp instanceof HitboxSprite) hitboxSprites.add((HitboxSprite)temp); }
        for(PositionSprite temp : sprite) {if(temp instanceof DrawableSprite) drawableSprites.add((DrawableSprite) temp); }
    }
    public void addSprite(int pos, PositionSprite sprite){
        this.sprites.add(pos, sprite);
        if(sprite instanceof HitboxSprite) hitboxSprites.add((HitboxSprite) sprite);
        if(sprite instanceof DrawableSprite) drawableSprites.add((DrawableSprite) sprite);

    }

    public void removeSprite(PositionSprite sprite){
        this.sprites.remove(sprite);
        if(sprite instanceof HitboxSprite) hitboxSprites.remove((sprite));
        if(sprite instanceof DrawableSprite) drawableSprites.remove((sprite));
    }

    public void updateHitboxListeners() {

        HashMap<HitboxSprite, List<HitboxSprite>> hits = new HashMap<>();

        for (HitboxSprite sprite : hitboxSprites) {
            if (sprite.isListening()) {
                List<HitboxSprite> temp = new ArrayList<>();
                for (HitboxSprite sprite2 : hitboxSprites) {
                    if (sprite.collides(sprite2)) {
                        temp.add(sprite2);
                    }
                }
                hits.put(sprite, temp);
            }
        }

        for(HitboxSprite spr : hits.keySet()){
            spr.updateListener(hits.get(spr));
        }
    }

}
