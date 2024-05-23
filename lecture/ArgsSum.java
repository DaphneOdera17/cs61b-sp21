public class ArgsSum {
	public static void main(String[] args) {
		int idx = 0;
		int sum = 0;
		while(idx < args.length) {
			sum += Integer.parseInt(args[idx]);
			idx ++;
		}
		System.out.println(sum);
	}
}