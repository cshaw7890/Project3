import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class ExperimentController
{
    String    center;
    Graph     graph;
    
    public void read()
    {
        try
        {
            File center     = new File("center.txt");
            File roads      = new File("roads.txt");
            File warehouses = new File("warehouses.txt");
            Scanner s1      = new Scanner(center);
            
            this.center     = s1.nextLine();
            
            graph = new Graph();
            s1 = new Scanner(roads);
            s1.nextLine();
            while(s1.hasNext())
            {
                String s = s1.nextLine();
                String[] a = s.split(" ");
                graph.addRoad(a[0],a[1],Integer.parseInt(a[2]));
            }
            
            s1 = new Scanner(warehouses);
            s1.nextLine();
            while(s1.hasNext())
            {
                String s = s1.nextLine();
                String [] a = s.split(" "); 
            }
            
        }
        catch(Exception e)
        {
        }
    }
}
