import java.util.*;

public class Dijkstra { 

	public static void main(String... args) {
		Dijkstra d = new Dijkstra();
		Map<String, Map<String, Integer>> graph = d.createGraph();
		
		for (var entry : graph.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());

		DijkstraResult result = d.dijkstraSearch(graph, "Book", "Piano");
		System.out.println(result.value + "\n" + result.path);
	}


	private DijkstraResult dijkstraSearch(Map<String, Map<String, Integer>> graph, String start, String end) {

		// Preparing map with shortest pathes
		Map<String, Integer> shortestPaths = new HashMap<>();
		for (var vertex : graph.keySet())
			shortestPaths.put(vertex, Integer.MAX_VALUE);
		shortestPaths.put(start, 0);

		// Preparing map with path by vertexes names
		Map<String, String> path = new HashMap<>();
		path.put(start, null);

		Stack<String> vertexes = new Stack<>();
		vertexes.push(start);

		System.out.println("Initial values of the vertexes stack " + vertexes);
		System.out.println("Initial values of the shortest paths map " + shortestPaths);

		while (vertexes.size() > 0) {
			String currentVertex = vertexes.pop();
			for (var neigh : graph.get(currentVertex).entrySet()) {
				String neighName = neigh.getKey();
				Integer neighCost = shortestPaths.get(currentVertex) + neigh.getValue();
				if (shortestPaths.get(neighName) > neighCost) {
					shortestPaths.put(neighName, neighCost); // Update cost
					path.put(neighName, currentVertex); // Update path
					vertexes.push(neighName); // Add new neighbour vertex for update
				}
			}
		}
		System.out.println("Final values of the shortest paths map " + shortestPaths);
		return new DijkstraResult(shortestPaths.get(end), restorePath(path, end)); 
	}


	private List<String> restorePath(Map<String, String> path, String endVertex) {
		List<String> resultPath = new ArrayList<>();
		String currentVertex = endVertex;
		while (currentVertex != null) {
			resultPath.add(currentVertex);
			currentVertex = path.get(currentVertex);
		}
		return resultPath;
	}


	private Map<String, Map<String, Integer>> createGraph() {
		Map<String, Map<String, Integer>> graph = new HashMap<>();

		graph.put("Book", new HashMap() {{ put("Vinyl Plate", 5); put("Poster", 0);}});
		graph.put("Vinyl Plate", new HashMap() {{ put("Bass Guitar", 15); put("Drum", 20); }}); // put("Poster", -7); Not works!
		graph.put("Poster", new HashMap() {{ put("Bass Guitar", 30); put("Drum", 35);}});
		graph.put("Bass Guitar", new HashMap() {{ put("Piano", 20);}});
		graph.put("Drum", new HashMap() {{ put("Piano", 10);}});
		graph.put("Piano", new HashMap() {{ }});

		return graph;
	}
	

	class DijkstraResult {
		public Integer value;
		public List<String> path;
		public DijkstraResult(Integer value, List<String> path) {
			this.value = value;
			this.path = path;
		}
	}
}

