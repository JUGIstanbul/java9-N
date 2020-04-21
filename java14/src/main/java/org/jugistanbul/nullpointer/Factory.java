package org.jugistanbul.nullpointer;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 21.04.2020
 **/

public class Factory
{
    private String name;

    public Factory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
