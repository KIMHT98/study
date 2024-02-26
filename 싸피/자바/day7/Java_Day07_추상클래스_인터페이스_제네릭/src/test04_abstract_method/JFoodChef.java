package test04_abstract_method;

// 만약 추상클래스를 상속받은 자식 클래스인 경우
//1. 해당 추상메서드를 반드시 오버라이드 한 경우 -> 자기 자신이 완전한 클래스가 됨
//2. 해당 추상메서드를 오버라이드 하지 않은 경우 -> 자기 자신도 추상클래스가 됨. -> 객체 생성 불가.
public class JFoodChef extends Chef {
    
    // @Override
    public void cook() {
        System.out.println("일식을 조리한다.");
    }
}
