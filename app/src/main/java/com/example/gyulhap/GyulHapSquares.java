package com.example.gyulhap;

public class GyulHapSquares {
    private String shape;
    private String shapeColour;
    private String bkgColour;
    private String img;

    public GyulHapSquares(String shape, String shapeColour, String bkgColour, String img) {
        this.shape = shape;
        this.shapeColour = shapeColour;
        this.bkgColour = bkgColour;
        this.img = img;
    }
    public void setBkgColour(String bkgColour) {
        this.bkgColour = bkgColour;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setShapeColour(String shapeColour) {
        this.shapeColour = shapeColour;
    }

    public String getBkgColour() {
        return bkgColour;
    }

    public String getShape() {
        return shape;
    }

    public String getShapeColour() {
        return shapeColour;
    }

    public String getImg() {
        return img;
    }
}
