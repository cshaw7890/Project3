import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class City implements Comparable<City>
{
    String            name; //name or label
    List<Road> nbs  = new ArrayList<Road>(); //neighbors, using adjacency lists to initialize the graphs
    int               dist; //distance
    boolean visited = false; //visited
    City              prev;
    Warehouse         warehouse;
    List<City> distances = new ArrayList<City>();
    
    public City (String n)
    {
        name = n;
        dist = Integer.MAX_VALUE;
    }

    public int compareTo(City v)
    {
        return this.dist - v.dist;
    }
}
