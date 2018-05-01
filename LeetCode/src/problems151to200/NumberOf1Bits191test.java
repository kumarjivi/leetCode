package problems151to200;

public class NumberOf1Bits191test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOf1Bits191 obj = new NumberOf1Bits191();
		int n = Integer.parseUnsignedInt("2147483648");
		System.out.println(Math.abs(n));
		System.out.println("binary string: "+Integer.toBinaryString(-2147483648));
		int i = obj.hammingWeight(n);
		System.out.println(i);
		i = obj.hammingWeight(654654);
		System.out.println(i);
		i = obj.hammingWeight(32);
		System.out.println(i);
		i = obj.hammingWeight(1025);
		System.out.println(i);
	}
}
