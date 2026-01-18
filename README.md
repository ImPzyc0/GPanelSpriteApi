Zum Aufbau von meiner Aplu-Library, damit der Code der GPanelSpriteApi Sinn ergibt
        Alles ist aufgebaut in Sprites, 2D Objekten, die auf dem GPanel gemalt werden
        Man erstellt eine Util, also einen Manager für die Sprites, welcher alle Sprites und ihren Typen beinhalten
         Sprites - jegliche Objekte
         HitboxSprites - Sprites mit Hitbox, können auch Unsichtbar sein, damit man die neue Kollisionen überprüfen kann
         DrawableSprites - Sprites mit Bild oder Farbe, damit diese in der draw() Methode gemalt werden können
         Außerdem hat der Manager das GPanel, auf welchem gemalt wird
         1. Linie ist also immer: GUtility util = new GUtility(500, 500);
        Danach kommen die Sprites, also die Objekte auf dem Screen
        Davon gibt es: CircleColoredHitbox, RectangleColoredHitbox, RectangleImageHitbox, CircleHitbox und RectangleHitbox Sprite
         Diese erstellt man, sagt zu welcher Util die gehören im Manager und bam, beim nächsten draw() werden diese angezeigt
         Jegliche Listener für die Collides, also wenn eine HitboxSprite eine andere berührt, kann man den Sprites geben
         Diese macht man mit HitboxSprite.setListener(CollideEventListener) - CollideEventListener ist ein Interface mit HitboxEnter, Stay und Exit, welche implementiert werden müssen
         Diese werden aufgerufen wenn man util.updateHitboxListeners() benutzt
        Jetzt kommt die Game-Loop:
        Einen Timer, der eine ständige FPS Anzahl gibt
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            //Code der davor kommt
            //Dann kommt das checken von den Hitboxen, die Listeners werden dann automatisch aufgerufen
            util.updateHitboxListeners()
            //Code für das normale Spiel
            //Und ganz zum Schluss
            util.getPanel().clear(); //Alles entfernen
            util.draw(); // Alles sprites malen
        }, 0, 1000/fps);
        Und so kann man ganz einfach Spiele machen. Yippi
        Das Projekt ist auf Englisch. Ich finde es komisch Sachen auf Deutsch zu benennen. Vielleicht veröffentlichte ich den Code irgendwo ja ?? (I did indeed)
      
