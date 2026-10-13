class animal{
    String sound(){
        return "Animal sound";
    }
    String eat(){
        return "Animal eats";
    }
}

class cat extends animal{
    String sound(){
        return "Cat sound";
    }
    String eat(){
        return "Cat eats mice";
    }
}

class dog extends animal{
    String sound(){
        return "Dog sound";
    }
    String eat(){
        return "Dog eats meat";
    }
}

class poly{
    public  int add(int a, int b){
        return a+b;
    }
    public  int add(int a, int b, int c){
        return a+b+c;
    }


    public static void main(int a, int b){
        poly p = new poly();
        System.out.println(a+b);
    }

    public static void main(String[] args){
        animal a = new animal();
        System.out.println(a.sound());
        System.out.println(a.eat());

        animal c = new cat();
        System.out.println(c.sound());
        System.out.println(c.eat());

        animal d = new dog();
        System.out.println(d.sound());
        System.out.println(d.eat());
        main(10,20);
    }
    
}