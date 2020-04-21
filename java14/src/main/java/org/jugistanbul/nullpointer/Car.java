package org.jugistanbul.nullpointer;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 21.04.2020
 **/

public class Car
{
    private String color;
    private Model model;

    public Car(String color, Model model) {
        this.color = color;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
