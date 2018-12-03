import java.util.*;
import java.io.*;
/**
 * Write a description of class Graph here.
 * @author ()
 */
public class Graph
{
    //Vertex [] V = new Vertex[100];
    List<City> cities = new ArrayList<City>();
    Map<String, City> vertexMap = new HashMap<String, City>();

    /* Add a directed or undirected edge */
    public void addRoad(String start, String end, int w)
    {
        City u = getCity(start);
        City v = getCity(end);
        u.nbs.add(new Road(u, v, w));
        v.nbs.add(new Road(v, u, w));

        //for undirected graphs......
        //u.nbs.add(new Edge(u, v, w));
        //v.nbs.add(new Edge(v, u ,w));
    }

    /* retrieve the vertex associated with the given name */
    public City getCity(String name)
    {
        City v = vertexMap.get(name);
        if(v == null)
        {
            v = new City(name);
            vertexMap.put(name, v);
            cities.add(v);
        }
        return v;
    }

    // public void bfs(City startVertex)
    // {
    // Queue<City> q = new ArrayDeque<City>();
    // q.add(startVertex);
    // startVertex.dist = 0;

    // while(!q.isEmpty())
    // {
    // Vertex u = q.poll();
    // System.out.println(u.name);

    // for(Edge e : u.nbs)
    // {
    // Vertex v = e.v;
    // if(v.dist != Integer.MAX_VALUE)
    // {
    // q.add(v);
    // v.dist = u.dist + 1;
    // }
    // }
    // }
    // }
    // /

    // /* run a dfs start from a given vertex using explicit stack */
    // public void dfs(Vertex startVertex)
    // {
    // Deque<Vertex> s= new ArrayDeque<Vertex>();
    // s.push(startVertex);
    // startVertex.visited = true;

    // while(!s.isEmpty())
    // {
    // Vertex u = s.pop();
    // System.out.println(u.name);
    // for(Edge e : u.nbs)
    // {
    // Vertex v = e.v;
    // if(!v.visited)
    // {
    // s.push(v);
    // v.visited = true;
    // }
    // }
    // }
    // }

    // /* run a dfs using recursive calls and implicit stack */
    // public void recursiveDfs(Vertex u)
    // {
    // u.visited = true;
    // System.out.println(u.name);
    // for(Edge e : u.nbs)
    // {
    // Vertex v = e.v;
    // if(!v.visited) recursiveDfs(v);
    // }
    // }

    /* compute the weighted distance from a given start vertex */
    public void shortestPath(City startCity)
    {
        reset();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        PriorityQueue<City> q = new PriorityQueue<City>();
        q.add(startCity);
        startCity.dist = 0;
        while( !q.isEmpty() )
        {
            City u = q.poll();
            if( u.visited ) continue;
            u.visited = true;
            if(u.warehouse != null){
                int n = 0;
                while(n < distances.size() && u.dist > distances.get(n)){
                    n++;
                }
                while(n < distances.size() && u.dist == distances.get(n) && u.name.compareTo(names.get(n)) > 0){
                    n++;
                }
                names.add(n, u.name);
                distances.add(n, u.dist);
            }
            for(Road e : u.nbs)
            {
                City v = e.v;
                if( v.dist > u.dist + e.w )
                {
                    v.dist = u.dist + e.w;
                    v.prev = u;

                    q.add(v);
                }
            }
        }
        startCity.names = names;
        startCity.distances = distances;

    }

    /* reset instace vars of every vertex */
    public void reset()
    {
        for( City v : vertexMap.values() )
        {
            v.dist = Integer.MAX_VALUE;
            v.visited = false;
            v.prev = null;
        }
    }

    /* Main method */
    //   public static void main(String[] args) throws IOException
    //   {
    //      Scanner in = new Scanner(new FileReader("graph.txt"));
    //      Graph g = new Graph();
    //     while(in.hasNext())
    //     {
    //         String [] line = in.nextLine().split(" ");
    //        if(line.length == 3)
    //        {
    //          int w = Integer.parseInt(line[2]);
    //       }
    //    }
    //  }
}
