public class FibonacciRecurse {
	
	static int fib(int n) {
		if( n <= 1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	public static void main(String[] args) {
		if(args.length != 1) {
			return;
		}

		int n = Integer.parseInt(args[0]);
		System.out.println(fib(n));
	}
}
