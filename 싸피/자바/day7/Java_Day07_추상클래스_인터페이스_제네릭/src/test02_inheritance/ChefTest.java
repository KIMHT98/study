package test02_inheritance;

public class ChefTest {
    public static void main(String[] args) {
        Chef[] chefs = new Chef[2];
        
        chefs[0] = new KFoodChef();
        chefs[1] = new JFoodChef();
        
        for(Chef chef: chefs) {
        	chef.eat();//부모 클래스 타입으로 참조
        	chef.cook();//자식 객체의 행위가 실행
        }
        ((KFoodChef) chefs[0]).cook();

    }
}
