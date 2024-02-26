package modifier06_singleton;

//싱글턴 패턴을 이용해서 구현
//스코어를 관리하는 객체
public class ScoreManager {
	//객체 멤버 변수
	private int score;
	
	//2. 객체를 단 한 번만 생성해서 갖고 있는다.
	//5. static으로 만들어야 static으로 접근 가능
	private static ScoreManager instance = new ScoreManager();
	
	//1. 생성자를 private으로 막아서 외부에서 생성하지 못하도록 차다
	private ScoreManager() {
	}
	
	//3. 외부에서 접근할 수 있는 합법적 통로를 열어준다(getter & setter)
	//4. static으로 만들어서 객체 생성 없이 접근 가능하도록 만든다
	public static ScoreManager getInstance() {
		return instance;
	}
	
}
