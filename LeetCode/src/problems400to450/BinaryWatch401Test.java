package problems400to450;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch401Test {

	public static void main(String args[]) {
		BinaryWatch401 obj = new BinaryWatch401();
		List<String> result = obj.readBinaryWatch(3);
		for (String time : result) {
			System.out.println(time);
		}

	}

}
