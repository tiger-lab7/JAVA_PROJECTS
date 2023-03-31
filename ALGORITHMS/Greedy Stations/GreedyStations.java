import java.util.*;

public class GreedyStations {


	public static void main(String... args) {
		GreedyStations gr = new GreedyStations();
		var result = gr.greedy(gr.prepareStations());
		System.out.println(result);
	}

	private Set<String> greedy(Map<String, Set<String>> stations) {

		Set<String> statesNeeded = new HashSet<>();
		for (var st : stations.values()) {
			statesNeeded.addAll(st);
		}
		System.out.println("Needed: " + statesNeeded);

		String bestStation;

		Set<String> resultStations = new HashSet<>();

		while(statesNeeded.size() > 0) {
			bestStation = null;
			Set<String> statesCovered = new HashSet<>();
			for (var st : stations.entrySet()) {
				// perform currentCovered = statesNeeded & currentCovered operation
				Set<String> currentCovered = new HashSet<>() {{ addAll(statesNeeded); }}; 
				currentCovered.retainAll(st.getValue());

				if (currentCovered.size() > statesCovered.size()) {
					bestStation = st.getKey();
					statesCovered = currentCovered;
				}
			}
			resultStations.add(bestStation);
			statesNeeded.removeAll(statesCovered);
		}
		
		return resultStations;
	}

	private Map<String,Set<String>> prepareStations() {
		Map<String, Set<String>> st = new HashMap<>();
		st.put("kone", new HashSet<String>() {{ addAll(Arrays.asList(new String[] {"id","nv","ut"})); }});
		st.put("ktwo", new HashSet<String>() {{ addAll(Arrays.asList(new String[] {"wa","id","mt"})); }});
		st.put("kthree", new HashSet<String>() {{ addAll(Arrays.asList(new String[] {"or","nv","ka"})); }});
		st.put("kfour", new HashSet<String>() {{ addAll(Arrays.asList(new String[] {"nv","ut"})); }});
		st.put("kfive", new HashSet<String>() {{ addAll(Arrays.asList(new String[] {"ca","az"})); }});

		return st;
	}
}