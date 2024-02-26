package test04_finally;

public class FinallyTest1 {
    public static void main(String[] args) {
    	//예외 발생 시 : 1, 3, 4, 5
    	//정상 작동 시 : 1, 2, 4, 5
    	//예외 미처리 시 : 1, 4 (중단)
    	//catch문에 return이 들어가면(예외 발생시) : 1, 3, 4
    	//try문에 return이 들어가면?(정상 실행시) : 1, 2, 4
//    	int[] nums = {10};
        int num = 1;
        
        try {
            System.out.println("1");
            int i = 1 / num;
//            nums[3]=1;
            System.out.println("2");
            return;//함수를 여기서 종료
        } catch (ArithmeticException e) {
            System.out.println("3");
           
        } finally {
            System.out.println("4");
        }
        System.out.println("5");
    }

}
