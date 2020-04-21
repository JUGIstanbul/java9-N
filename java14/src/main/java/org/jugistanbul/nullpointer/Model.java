package org.jugistanbul.nullpointer;

import org.jugistanbul.nullpointer.Factory;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 21.04.2020
 **/

public class Model
{
    private int year;
    private Factory factory;

    public Model(){ }

    public Model(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
