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
            FileReader warehouses = new FileReader("warehouses.txt");
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
                Warehouse w = new Warehouse();

                City c = graph.getCity(a[0]);
                System.out.println(s);
                c.warehouse = w;
                for(int i = 1; i < a.length; i++){
                    w.orders.add(new Cargo(Integer.parseInt(a[i]), i));
                }
                graph.cities.add(c);
            }

            for(City c: graph.cities){
                System.out.println(c.warehouse);
                if(c.warehouse != null){
                    graph.shortestPath(c);
                }

            }

            for(City c: graph.cities){
                System.out.println(c.name);
                for(int i = 0; i < c.distances.size(); i++){
                    System.out.println(c.names.get(i));
                    System.out.println(c.distances.get(i));
                }
                System.out.println();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
