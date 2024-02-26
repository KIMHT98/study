package modifier06_singleton;

public class ScoreTest {
    public static void main(String[] args) {
    	ScoreManager sm = ScoreManager.getInstance();
    	
    	//ScoreManager sm2 = new ScoreManager(); -> 객체를 생성할 수 없음
    	ScoreManager sm2 = ScoreManager.getInstance();
    	
    	System.out.println(sm==sm2);
    }
}
