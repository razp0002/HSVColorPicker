package model;

import java.util.Observable;

/**
 * Created by stan on 2016-10-24.
 */

public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final Float MAX_HUE = 359f;
    public static final Float MAX_SATURATION = 1.0f;
    public static final Float MAX_VALUE = 1.0f;
    public static final Float MIN_HUE = 0f;
    public static final Float MIN_SATURATION = 0f;
    public static final Float MIN_VALUE = 0f;

    // INSTANCE VARIABLES
    private Float hue;
    private Float saturation;
    private Float value;

    public HSVModel() {
        this(MAX_HUE, MAX_SATURATION, MAX_VALUE);
    }

    public HSVModel(Float hue, Float saturation, Float value) {
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    public void asBlack() {this.setHSV(0.0f, 0.0f, 0.0f);}
    public void asRed() {this.setHSV(0.0f, 1.0f, 1.0f);}
    public void asLime() {this.setHSV(120.0f, 1.0f, 1.0f);}
    public void asBlue() {this.setHSV(240.0f, 1.0f, 1.0f);}
    public void asYellow() {this.setHSV(60.0f, 1.0f, 1.0f);}

    public void asCyan() {this.setHSV(180.0f, 1.0f, 1.0f);}
    public void asMagenta() {this.setHSV(300.0f, 1.0f, 1.0f);}
    public void asSilver() {this.setHSV(0.0f, 0.0f, 0.75f);}
    public void asGray() {this.setHSV(0.0f, 0.0f, 0.5f);}
    public void asMaroon() {this.setHSV(0.0f, 1.0f, 0.5f);}

    public void asOlive() {this.setHSV(60.0f, 1.0f, 0.5f);}
    public void asGreen() {this.setHSV(120.0f, 1.0f, 0.5f);}
    public void asPurple() {this.setHSV(300.0f, 1.0f, 0.5f);}
    public void asTeal() {this.setHSV(180.0f, 1.0f, 0.5f);}
    public void asNavy() {this.setHSV(240.0f, 1.0f, 0.5f);}

    //Getters
    public Float getHue() { return hue; }
    public Float getSaturation() {return saturation;}
    public Float getValue() {return value;}

    //Setters
    public void setHue( float hue ) {
        this.hue = hue;

        this.updateObservers();
    }

    public void setSaturation( float saturation ) {
        this.saturation = saturation;

        this.updateObservers();
    }

    public void setValue( float value ) {
        this.value = value;

        this.updateObservers();
    }


    public void setHSV( float hue, float saturation, float value ) {
        this.hue   = hue;
        this.saturation = saturation;
        this.value  = value;

        this.updateObservers();
    }

    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "HSV [h=" + hue + " s=" + saturation + " v=" + value + "]";
    }

}
