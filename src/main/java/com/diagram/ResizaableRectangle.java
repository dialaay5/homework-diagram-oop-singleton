package com.diagram;

public class ResizaableRectangle extends Rectangle implements Resizeable{
    public ResizaableRectangle(double width, double length) {
        super(width, length);
    }

    @Override
    public void resize(int percent) {
        width *= percent/100.0;
        length *= percent/100.0;
        System.out.println("new width = " + this.width );
        System.out.println("new length = " + this.length);

    }
}
