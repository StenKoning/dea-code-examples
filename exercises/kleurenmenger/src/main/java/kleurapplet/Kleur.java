package kleurapplet;


import kleurapplet.grnuminput.NumberListener;

import java.awt.*;
import java.util.Observable;

public class Kleur extends Observable implements NumberListener{
    // Variables
    private int roodval;
    private int groenval;
    private int blauwval;
    private float[] hsbvalues;

    public Kleur() {
        roodval = 127;
        groenval = 127;
        blauwval = 127;
    }

    @Override
    public void numberChanged(String naam, double v) {
        if ( naam.equals("Rood") )
        {	roodval = (int)v;		// harde cast!! v loopt van 0 tot 255 met 0 decimalen!
            adjustHSBValues();
        } else if ( naam.equals("Groen") )
        {	groenval = (int)v;
            adjustHSBValues();
        } else if ( naam.equals("Blauw") )
        {	blauwval = (int)v;
            adjustHSBValues();
        } else if ( naam.equals("Tint") )
        {	hsbvalues[0] = (float)v;	// harde cast!! v loopt van 0 tot 1 met 3 decimalen!
            adjustRGBValues();
        } else if ( naam.equals("Verzadiging") )
        {	hsbvalues[1] = (float)v;
            adjustRGBValues();
        } else 	// must be "Helderheid"
        {	hsbvalues[2] = (float)v;
            adjustRGBValues();
        }

        setChanged();
        notifyObservers(dataObject());
    }

    /**
     * Bij verandering van RGB moet HSB worden aangepast
     */
    private void adjustHSBValues()
    {
        hsbvalues = Color.RGBtoHSB(roodval, groenval, blauwval, hsbvalues);
    }

    /**
     * Bij verandering van HSB moet RGB worden aangepast
     */
    private void adjustRGBValues()
    {
        Color c = Color.getHSBColor(hsbvalues[0], hsbvalues[1], hsbvalues[2]);
        roodval = c.getRed();
        groenval = c.getGreen();
        blauwval = c.getBlue();
    }

    public KleurUpdate dataObject(){
        adjustHSBValues();
        return new KleurUpdate(roodval, groenval, blauwval, hsbvalues[0], hsbvalues[1], hsbvalues[2]);
    }

    class KleurUpdate{
        public int roodval;
        public int groenval;
        public int blauwval;
        public float hue;
        public float saturation;
        public float brightness;

        private KleurUpdate(int r, int g, int b, float hue, float saturation, float brightness){
            roodval = r;
            groenval = g;
            blauwval = b;
            this.hue = hue;
            this.saturation = saturation;
            this.brightness = brightness;
        }
    }
}