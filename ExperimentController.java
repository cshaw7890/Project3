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
    Truck     truck;

    public static void main(String[] args){
        ExperimentController ec = new ExperimentController();
        ec.read();
    }

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

                City c = graph.getCity(a[0]);
                Warehouse w = new Warehouse(c);
                for(int i = 1; i < a.length; i++){
                    w.orders.add(new Cargo(Integer.parseInt(a[i]), i, w));

                }
                c.warehouse = w;
                graph.cities.add(c);
            }

            City cent = graph.getCity(this.center);
            cent.warehouse = new Warehouse(cent);
            graph.shortestPath(cent);

            for(City c: graph.cities){
                //  System.out.println(c.warehouse);
                if(c.warehouse != null){
                    graph.shortestPath(c);
                }

            }

            // for(City c: graph.cities){
            // System.out.println(c.name);
            // for(int i = 0; i < c.distances.size(); i++){
            // System.out.println(c.names.get(i));
            // System.out.println(c.distances.get(i));
            // }
            // System.out.println();
            // }

            // for(City c: graph.cities){
            // if(c.warehouse != null){
            // for(Cargo cargo : c.warehouse.orders){
            // System.out.println(cargo.weight);
            // }
            // }

            // }

            //start to work
            boolean stop = false;
            int truckNumber = 1;
            int totalDistance = 0;

            System.out.println(graph.getCity("v2075").names);
            System.out.println(graph.getCity("v2075").distances);

            while(!stop){
                truck = new Truck(truckNumber);
                City c = graph.getCity(this.center);   
                truck.current_city = c;
                int n = 0;
                stop = true;
                while(n < c.names.size()){
                    c = truck.current_city;
                    City next = graph.getCity(c.names.get(n));
                    if(next.warehouse.orders.size() > 0 && next.warehouse.orders.peek().weight <= truck.capacity){
                        System.out.println("Truck " + truckNumber + ": Deliver to warehouse " + next.name + ". Weight: " + next.warehouse.orders.peek().weight + ". Dist: " + c.distances.get(n));
                        //  System.out.println(c.names.get(n+1));
                        truck.capacity -= next.warehouse.orders.poll().weight;                 
                        if(!next.equals(truck.current_city)){
                            truck.distance_travelled += c.distances.get(n);
                            totalDistance += c.distances.get(n);
                        }                 
                        stop = false;
                        truck.current_city = next;
                        n = 0;

                    }
                    else{
                        n++;
                    }

                }
                if(!stop){
                    int i = truck.current_city.names.indexOf(this.center);
                    truck.distance_travelled += truck.current_city.distances.get(i);
                    totalDistance += truck.current_city.distances.get(i);
                    System.out.println("Truck " + truckNumber + ": Return to logistics center. Dist: " + truck.current_city.distances.get(i));
                    System.out.println("Truck " + truckNumber + " total distance: " + truck.distance_travelled);
                    System.out.println();
                }
                truckNumber++;

            }
            System.out.println("Total distance: " + totalDistance);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
