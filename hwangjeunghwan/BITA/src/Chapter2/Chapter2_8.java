package Chapter2;

import java.util.Scanner;

//�ؼ����� �������� �� �ϰڽ��ϴ�.
public class Chapter2_8 {
	
final static int MOD = 1000000007;	

static long C(int n, int r) {
	long a = 1, b = 1;

    // a = n! / (n-r)!
    // b = r!
    for (int i = 0; i < r; ++i) {
        a = a * (n - i) % MOD;
        b = b * (i + 1) % MOD;
    }

    // nCr = a / b = a * b^-1
    return a * fpow(b, MOD - 2) % MOD;
}

static long fpow(long b, int n) {
	long ret = 1;
	// n�� �������� �����Ͽ� �ش� ��Ʈ�� �����Ǵ� a^(2^k)�� ���Ѵ�
    while (n>0) {
        if ((n&1)==0) {
        	ret = ret * b % MOD;
        	}
        b =  b * b % MOD;
        n >>= 1;
    }
    return ret;
}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		 // ������ġ -> ���丮
	    long a = C(x1 + y1, x1);
	    // ���丮 -> ������ġ
	    long b = C(N - x1 + M - y1, N - x1);

	    // ������ġ -> ���丮�� ������ �ִ� ���
	    if (x2 <= x1 && y2 <= y1)
	        a -= C(x2 + y2, x2) * C(x1 - x2 + y1 - y2, x1 - x2) % MOD;

	    // ���丮 -> ������ġ�� ������ �ִ� ���
	    if (x1 <= x2 && y1 <= y2)
	        b -= C(x2 - x1 + y2 - y1, x2 - x1) * C(N - x2 + M - y2, N - x2) % MOD;

	    // ������ �ƴٸ� ����� ����� �ش�
	    if (a < 0) a += MOD;
	    if (b < 0) b += MOD;

	    

	    System.out.println(a*b%MOD);
		
		
	}
}
