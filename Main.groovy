package com.company

class Main {
    static void main(String[] args) {
        final int POINTS = 2;
        def points = new Point2D[POINTS];
        def materialPoints = new MaterialPoint2D[POINTS];

        points[0] = new Point2D(0.0, 0.0);
        points[1] = new Point2D(10.0, 10.0);

        materialPoints[0] = new MaterialPoint2D(0.0, 0.0, 10);
        materialPoints[1] = new MaterialPoint2D(10.0, 10.0, 100);

        Point2D geometricCenter = Calculations.positionGeometricCenter(points);
        Point2D massCenter = Calculations.positionCenterOfMass(materialPoints);

        println("Polozenie srodka masy: " + massCenter);
        println("Polozenie srodka geometrycznego: " + geometricCenter);
    }
}

class Point2D {
    protected double x;
    protected double y;

    Point2D(double x,double y){
        this.x = x;
        this.y = y;
    }

    @Override
    String toString(){
        "Point2D (" + "x = " + x + ", y= " + y + ")";
    }
}

class MaterialPoint2D extends Point2D {
    protected double mass;
    MaterialPoint2D(double x,double y,double mass){
        super(x,y);
        this.mass = mass;
    }

    @Override
    String toString(){
        "MaterialPoint2D (" + "x = " + x + ", y = " + y + ", mass = " + mass + ")";
    }
}

class Calculations {
    static Point2D positionGeometricCenter(Point2D[] point){
        double tmp_x = 0;
        double tmp_y = 0;

        for (int i = 0; i < point.length; i++){
            tmp_x = tmp_x + point[i].x;
            tmp_y = tmp_y + point[i].y;
        }
        new Point2D(tmp_x/point.length,tmp_y/point.length);
    }
    static Point2D positionCenterOfMass(MaterialPoint2D[] materialPoint){
        double tmp_x = 0;
        double tmp_y = 0;
        double mass = 0;

        for (int i = 0; i < materialPoint.length; i++){
            tmp_x = tmp_x + materialPoint[i].mass * materialPoint[i].x;
            tmp_y = tmp_y + materialPoint[i].mass * materialPoint[i].y;
            mass = mass + materialPoint[i].mass;
        }
        new MaterialPoint2D(tmp_x / mass,tmp_y / mass,mass);
    }
}