package com.diagram;

public class ResizaableCircle extends Circle implements Resizeable{


    public ResizaableCircle(double radius) {
        super(radius);
    }


    @Override
    public void resize(int percent) {
        radius *= percent/100.0;
        System.out.println("new radius = " + this.radius);
    }
}
