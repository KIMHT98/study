package day16_백트래킹_순열;

public class 순열_1 {
	static int[] nums;
	static int n;
	public static void main(String[] args) {
		nums = new int[] {0,1,2};
		n = nums.length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i!=j) {
					for(int k=0;k<n;k++) {
						if(i!=k&& j!=k) {
							System.out.printf("%d %d %d\n",nums[i],nums[j],nums[k]);
						}
					}
				}
			}
		}
	}
}
