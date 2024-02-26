package test09_generic_box;

//제네릭 클래스 -> 타입을 매개변수화 했다..
//<> : 타입 파라미터
class Box<T>{ //T : String, Double, Integer,...
    private T t;
    
    public T getT() {
        return t;
    }
    
    public void setT(T t) {
        this.t = t;
    }
}

public class BoxTest {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<Integer>();//Integer만 들어갈 수 있는 box
//        intBox.setT("Hh");//타입 체크를 해줌
        intBox.setT(11);
        
        int num = intBox.getT(); //꺼낼 때 형변화 필요 없다.
        
        Box<String> strBox = new Box<String>();//String에 들어갈 수 있는 box
        strBox.setT("Hi");
        String str = strBox.getT();
        
    }
}
