package com.company;

public class Main {

    public static void main(String[] args) {
        final int POINTS = 2;
        Point2D[] points = new Point2D[POINTS];
        MaterialPoint2D[] materialPoints = new MaterialPoint2D[POINTS];

        points[0] = new Point2D(0.0, 0.0);
        points[1] = new Point2D(10.0, 10.0);

        materialPoints[0] = new MaterialPoint2D(0.0, 0.0, 10);
        materialPoints[1] = new MaterialPoint2D(10.0, 10.0, 100);

        Point2D geometricCenter = Calculations.positionGeometricCenter(points);
        Point2D massCenter = Calculations.positionCenterOfMass(materialPoints);

        System.out.println("Polozenie srodka masy: " + massCenter);
        System.out.println("Polozenie srodka geometrycznego: " + geometricCenter);
    }
}

public class Point2D {
    protected double x;
    protected double y;

    public Point2D(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        return "Point2D (" +
                "x = " + x +
                ", y= " + y +
                ")";
    }
}

public class MaterialPoint2D extends Point2D {
    protected double mass;
    public MaterialPoint2D(double x,double y,double mass){
        super(x,y);
        this.mass = mass;
    }

    @Override
    public String toString(){
        return "MaterialPoint2D (" +
                "x = " + x +
                ", y = " + y +
                ", mass = " + mass +
                ")";
    }
}

public class Calculations {
    public static Point2D positionGeometricCenter(Point2D[] point){
        double tmp_x = 0;
        double tmp_y = 0;

        for (int i=0;i<point.length;i++){
            tmp_x = tmp_x + point[i].x;
            tmp_y = tmp_y + point[i].y;
        }
        return new Point2D(tmp_x/point.length,tmp_y/point.length);
    }
    public static Point2D positionCenterOfMass(MaterialPoint2D[] materialPoint){
        double tmp_x = 0;
        double tmp_y = 0;
        double mass = 0;

        for (int i=0;i<materialPoint.length;i++){
            tmp_x = tmp_x + materialPoint[i].mass * materialPoint[i].x;
            tmp_y = tmp_y + materialPoint[i].mass * materialPoint[i].y;
            mass = mass + materialPoint[i].mass;
        }
        return new MaterialPoint2D(tmp_x/mass,tmp_y/mass,mass);
    }
}
