import java.util.*;

public class KNearest {

	public static void main(String... args) {
		var kn = new KNearest();
		var result = kn.calculateDistances(kn.prepareData(), "Prijanka");
		System.out.println(result);
	}

	private Map<String, Double> calculateDistances(Map<String, Map<String, Integer>> data, String target) {
		
		Map<String, Double> distances = new HashMap<>();
		for (var neub : data.entrySet()) {
			Double sum = 0.0;
			for (var feature : neub.getValue().keySet()) {
				int diff = data.get(target).get(feature) - data.get(neub.getKey()).get(feature);
				sum += Math.pow(diff, 2);
			}
			distances.put(neub.getKey(), Math.sqrt(sum));
		}
		return distances;

	}

	private Map<String, Map<String, Integer>> prepareData() {
		Map<String, Map<String, Integer>> data = new HashMap<String, Map<String, Integer>>();
		//Arrays.stream(new String[] {"Prijanka", "Justin", "Morpheus"}).forEach(n -> {data.put(d, null);});
		
		var tastes = new HashMap<String, Integer>() {{ put("Comedy", 3); put("Action", 4); put("Drama", 4); put("Horror", 1); put("Melo", 4);}};
		data.put("Prijanka", tastes);

		var tastes1 = new HashMap<String, Integer>() {{ put("Comedy", 4); put("Action", 3); put("Drama", 5); put("Horror", 1); put("Melo", 5);}};
		data.put("Justin", tastes1);

		var tastes2 = new HashMap<String, Integer>() {{ put("Comedy", 2); put("Action", 5); put("Drama", 1); put("Horror", 3); put("Melo", 1);}};
		data.put("Morpheus", tastes2);

		return data;
	}
}