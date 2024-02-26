package test08_normal_box;

class Box {
    private Object obj;//모든 클래스의 조상, 모든 값이 들어갈 수 있음
    
    public Object getObj() {
        return obj;
    }
    
    public void setObj(Object obj) {
        this.obj = obj;
    }
}

public class BoxTest {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObj("Hi");
        box.setObj(11);
        box.setObj(1.111);
        //타입별로 설계도를 만들던지 Object로 설계도를 만든다
        //=> 넣을 때 편하지만 뺄때는 번거로움
        
        //항상 Object를 반환 -> 형변환 필요
        Object obj = box.getObj();
        double d = (double) obj;//형변환이 귀찮다..
       
        //Double은 double 자료형의 Wrapper 클래스 
        if (obj instanceof Double) {
        	System.out.println("실수에요");
        }else if(obj instanceof String) {
        	System.out.println("문자열 입니다");
        }else {
        	System.out.println("알수 없음");
        }
    }
}