class Vehicle{
    int speed;
    vehicle(int speed){
        this.speed = speed;
    }
    
    void engine(){
        System.out.println("Vehicle engine");
    }
    void wheels(){
        System.out.println("Vehicle wheels");
    }
    void color(){
        System.out.println("Vehicle color");
    }
    void fuel(){
        System.out.println("Vehicle fuel");
    }
}

class Car extends Vehicle{
    void engine(){
        System.out.println("Car engine");
    }
    void wheels(){
        System.out.println("Car wheels");
    }
    void color(){
        System.out.println("Car color");
    }
}

class Single{
    public static void main(String[] args){
        Vehicle v = new Car();
        v.engine();
        v.wheels();
        v.color();
        v.fuel();

        Car c = new Car();
        c.engine();
        c.wheels();
        c.color();
    }
}