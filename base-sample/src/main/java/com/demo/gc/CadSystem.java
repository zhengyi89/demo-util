package com.demo.gc;

public class CadSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] ls = new Line[3];

    CadSystem(int i) {
        super(i + 1);
        for (int j = 0; j < ls.length; j++) {
            ls[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        System.out.println("combined constructor");

    }

    @Override
    public void dispose() {
        System.out.println("cadsystem dispose");
        t.dispose();
        c.dispose();
        for (int i = ls.length - 1; i > 0; i--) {
            ls[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CadSystem x = new CadSystem(47);
        try {

        } finally {
            x.dispose();
        }
    }

}

class Shape {
    Shape(int i) {
        System.out.println("Shape consttuctor");
    }

    void dispose() {
        System.out.println("shape dispose");
    }
}

class Circle extends Shape {
    Circle(int i) {
        super(i);
        System.out.println("drawing circle");
    }

    @Override
    void dispose() {
        System.out.println("erasing circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        System.out.println("drawing Triangle");
    }

    @Override
    void dispose() {
        System.out.println("erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("drawing Line :" + start + "," + end);
    }

    @Override
    void dispose() {
        System.out.println("erasing Line: " + start + "," + end);
        super.dispose();
    }
}
