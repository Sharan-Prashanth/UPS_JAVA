class shape{
    public void area(){
        System.out.println("Implementation of Polymorphism");
    }
}

class circle extends shape{
    int r;
    circle(int r){
        this.r = r;
    }
    public void area(){
        System.out.println("Area of the circle: " + 3.17*(r*r));
    }
}

class rect extends shape{
    int l,b;
    public rect(int l,int b){
        this.l = l;
        this.b = b;
    }
    public void area(){
        System.out.println("Area of the Rectangle: " + 2 * (l + b));
    }
}

class tri extends shape{
    int l,b;
    public tri(int l,int b){
        this.l = l;
        this.b = b;
    }
    public void area(){
        System.out.println("Area of Triangle: " + 0.5 * (l*b));
    }
}

class Area{
    public static void main(String[] a){
        shape obj1 = new circle(10);
        shape obj2 = new rect(10,20);
        shape obj3 = new tri(10,20);
        obj1.area();
        obj2.area();
        obj3.area();
    }
}
