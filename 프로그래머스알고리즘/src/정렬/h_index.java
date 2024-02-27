package 정렬;

public class h_index {
//	public static int[] selectSort(int[] arr) {
//		int n = arr.length;
//		for(int i = 0;i<n;i++) {
//			int minidx = i;
//			for(int j=i+1;j<n;j++) {
//				if(arr[minidx]>arr[j]) {
//					minidx = j;
//				}
//			}
//			int tmp = arr[i];
//			arr[i] = arr[minidx];
//			arr[minidx] = tmp;
//		}
//		return arr;
//	}
    public static int solution(int[] citations) {
//        int[] arr = selectSort(citations);
    	int answer = 0;
        int n = citations.length;
        int max = 0;
        for(int i =0 ;i<n ;i++) {
        	max = Math.max(max, citations[i]);
        }
        int[] count = new int[max+1];
        for(int i=0;i<n;i++) {
        	count[citations[i]]++;
        }
        for(int i = 0;i<count.length;i++) {
        	int upper=0;
        	for(int j=i;j<count.length;j++) {
        		upper += count[j]; 
        	}
        	
        	if(upper>=i) {
        		answer = Math.max(answer, i);
        	}
        }

        	return answer;
    }
    public static void main(String[] args) {
		int[] arr = {3,0,6,1,5};
		System.out.println(solution(arr));
	}
}