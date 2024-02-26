package test04_abstract_method;

public class ChefTest {
    public static void main(String[] args) {
        Chef[] chefs = new Chef[2];
        
        chefs[0] = new KFoodChef();
        chefs[1] = new JFoodChef();
        
        for (Chef chef: chefs) {
        	chef.eat();
        	chef.cook(); //접근 가능 -> 다형성 활용 가능
        }
        
    }
}
