package swea;

public class SWEA_D3_3131_100만이하의모든소수 {
    
	private static final int N = 1000000;
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
    	boolean[] arr = new boolean[N+1];
        int n = 2;
        while (n <= N) {
        	if (!arr[n]) {
        		arr[n] = true;
        		for (int i = 2; n*i <= N; i++) {
        			arr[n*i] = true;
        		}
        		sb.append(n).append(" ");
        	}
        	n++;
        }
        System.out.println(sb);
    }
}