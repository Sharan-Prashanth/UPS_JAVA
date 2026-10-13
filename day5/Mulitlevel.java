class Animal{
    void sound(){
        System.out.println("Animal sound");
    }
    void eat(){
        System.out.println("Animal eats");
    }
}

class Herbi extends Animal{
    void sound(){
        System.out.println("Herbivore sound");
    }
    void eat(){
        System.out.println("Herbivore eats plants");
    }
}

class deer extends Herbi{
    void sound(){
        System.out.println("Deer sound");
    }
    void eat(){
        System.out.println("Deer eats grass");
    }
}

class Mulitlevel{
    public static void main(String[] args){
        Animal a = new Animal();
        a.sound();
        a.eat();

        Herbi h = new Herbi();
        h.sound();
        h.eat();

        Herbi d = new deer();
        d.sound();
        d.eat();
    }
}