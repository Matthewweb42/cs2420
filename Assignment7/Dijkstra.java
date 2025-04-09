import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        // 5x5 adjacency matrix
        int[][] graph = {
            {0, 10, 3, Integer.MAX_VALUE, Integer.MAX_VALUE}, // A's edges
            {Integer.MAX_VALUE, 0, 1, 2, Integer.MAX_VALUE},  // B's edges
            {Integer.MAX_VALUE, 4, 0, 8, 2}, // C's edges
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 7}, // D's edges
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, 0},  // E's edges
        };

        String[] nodeLabels = {"A", "B", "C", "D", "E"};
        
        //convert node labels to indices
        Map<String, Integer> labelToIndex = new HashMap<>();
        for (int i = 0; i < nodeLabels.length; i++) {
            labelToIndex.put(nodeLabels[i], i);
        }

        //scanner/Input buisness
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter source node label: ");
        String sourceLabel = scanner.nextLine().trim();
        
        System.out.println("Enter destination node label: ");
        String destLabel = scanner.nextLine().trim();

        int source = labelToIndex.get(sourceLabel);
        int destination = labelToIndex.get(destLabel);
        
        dijkstra(graph, nodeLabels, source, destination);
        

        scanner.close();
    }

    public static void dijkstra(int[][] graph, String[] nodeLabels, int source, int destination) {
        int numNodes = graph.length; //Number of nodes
        boolean[] visited = new boolean[numNodes]; //visited nodes
        int[] distances = new int[numNodes]; //distances from source for each node
        int[] previous = new int[numNodes]; //previous nodes

        //initialize distances and previous nodes
        Arrays.fill(distances, Integer.MAX_VALUE); //Infinity!
        Arrays.fill(previous, -1); //no node!
        distances[source] = 0; //source node is zero!

        //main part of Dijkstra's algorithm
        for (int i = 0; i < numNodes - 1; i++) {
            int u = minDistance(distances, visited); //Find minimum node 
            visited[u] = true; //adjust booleans

            for (int v = 0; v < numNodes; v++) {
                //case check for unvisited nodes, infinity, and distance
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v]; //update the distance
                    previous[v] = u; //update previous
                }
            }
        }

        //print the shortest path and distance
        printShortestPath(nodeLabels, previous, destination, distances[destination]);
    }

    //finds the node with the minimum distance that hasn't been visited yet
    private static int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE; //min is infinity to start
        int minIndex = -1; 

        for (int i = 0; i < distances.length; i++) { //check all nodes
            if (!visited[i] && distances[i] < min) { //if not visited and less than min
                min = distances[i]; //update min
                minIndex = i; 
            }
        }
        return minIndex;
    }

    //prints the shortest path and its distance
    private static void printShortestPath(String[] nodeLabels, int[] previous, int destination, int distance) {
        
        // print print print stuff
        List<String> path = new ArrayList<>();
        for (int des = destination; des != -1; des = previous[des]) {
            path.add(nodeLabels[des]);
        }
        Collections.reverse(path);

        System.out.println("Shortest path: " + String.join(" -> ", path));
        System.out.println("Total distance: " + distance);
    }
}