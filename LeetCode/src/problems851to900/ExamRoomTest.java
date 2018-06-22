package problems851to900;

public class ExamRoomTest {

	public static void main(String[] args) {
		int N = 10;
		ExamRoom855 obj = new ExamRoom855(N);
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		obj.leave(0);
		obj.leave(4);
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		System.out.println(obj.seat());
		obj.leave(0);
		obj.leave(4);
		System.out.println(obj.seat());
		System.out.println(obj.seat());
	}

}
