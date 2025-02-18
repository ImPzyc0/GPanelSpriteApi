package com.daniel.GSprite.Sprites.DrawableSprites.ImageSprites;

import ch.aplu.util.GPanel;
import com.daniel.GSprite.Sprites.DrawableSprites.DrawableSprite;
import com.daniel.GSprite.Sprites.HitboxSprites.RectangleHitboxSprite;
import com.daniel.GSprite.Util.GUtility;
import com.daniel.GSprite.Util.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A sprite with a hitbox and an image
 *
 *
 *
 */
public class RectangleImageHitboxSprite extends RectangleHitboxSprite implements ImageSprite, DrawableSprite {

    protected BufferedImage image;
    private String path;

    public RectangleImageHitboxSprite(Vector2D position, GPanel panel, Vector2D hitboxSize, String path) {
        super(position, panel, hitboxSize);

        this.path = path;
        setSize(hitboxSize);
    }

    public RectangleImageHitboxSprite(Vector2D position, GUtility util, Vector2D hitboxSize, String path) {
        super(position, util, hitboxSize);

        this.path = path;
        setSize(hitboxSize);
    }


    @Override
    public void draw() {
        if(this.image == null){return;}
        panel.image(image, position.getX()-hitboxSize.getX()/2, position.getY()-hitboxSize.getY()/2);
    }

    @Override
    public void setSize(Vector2D size) {
        this.hitboxSize = size;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert img != null;
        Image tmp = img.getScaledInstance((int)hitboxSize.getX(), (int)hitboxSize.getY(), Image.SCALE_SMOOTH);
        BufferedImage nImg = new BufferedImage((int)hitboxSize.getX(), (int)hitboxSize.getY(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = nImg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        this.image = nImg;
    }

    @Override
    public void setImage(String path) {
        this.path = path;
        setSize(hitboxSize);
    }

    @Override
    public String getPath() {
        return path;
    }


}
