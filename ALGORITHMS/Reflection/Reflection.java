import java.util.*;
import java.reflect.*;

public class Reflection {

	public static void main(String... args) {
		Set<Integer> testSet = new HashSet<>();
		Arrays.stream(testSet.getDeclaredMethods()).forEach(System.out::println);
	}
}