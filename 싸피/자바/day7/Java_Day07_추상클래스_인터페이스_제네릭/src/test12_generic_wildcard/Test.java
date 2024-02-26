package test12_generic_wildcard;

class Box<T> {
    T t;
    void setT(T t) {
        this.t = t;
    }
    
    T getT() {
        return t;
    }
}



public class Test {
    public static void main(String[] args){
    
       Box<?> b1; 
//       Box<? extends Bird> b1;
//       Box<? super Duck> b1;
       

       
       
       Box<Duck> b2 = new Box<>();
       b2.setT(new Duck());
       
       Box<Butterfly> b3 = new Box<>();
       b3.setT(new Butterfly());
       
       Box<Bird> b4 = new Box<>();
       b4.setT(new Bird());
       
       Box<String> b5 = new Box<>();
       b5.setT("Hahaha");
       
       
       b1 = b2;
       System.out.println(b1.getT().toString());       
       
       b1 = b3;
       System.out.println(b1.getT().toString());
       
       b1 = b4;
       System.out.println(b1.getT().toString());
       
       b1 = b5;
       System.out.println(b5.getT().toString());
        
    }
}
