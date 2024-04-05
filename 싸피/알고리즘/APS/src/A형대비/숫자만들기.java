package A형대비;

public class 숫자만들기 {
	static int n,max,min;
	static int[] nums,op,result;
	static boolean[] visit;
	static void perm(int idx,int sum) {
		if(idx==n-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
