import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class Truck
{
    City    current_city;
    int     capacity = 500;
    
    int     number;
    int     distance_travelled;
    int     recent_travelled;
    
    public Truck(int n)
    {
        current_city = graph.getCity(center);
        //capacity is 500
        number = n;
        distance_travelled = 0;
    }
    
    public boolean proceed()
    {
        City c = this.current_city;
        Warehouse wh = c.warehouse;
        
        //Current place does not have anymore appropriate cargo order done
        for(int i = 0; i < c.names.size(); i++)
        {
            City next_stop = graph.getCity(c.names.get(i));
            if(next_stop.warehouse.orders.size() > 0 && next_stop.warehouse.orders.peek() < truck.capacity)
            {
                distance_travelled += distances.get(i);
                recent_travelled = distance.get(i);
                this.current_city = next_stop;
                return true;
            }
        }
        
        //Can deliver no more order in any place, return false and the truck will go back
        return false;
    }
    
    public void deliver()
    {   
        City c = this.current_city;
        Warehouse wh = c.warehouse;
        
        int total_weight = 0;
        String mission = "([";
        
        while(this.capacity >= wh.orders.peek())
        {
            Cargo m = wh.orders.poll();
            total_weight += m.weight;
            this.capacity -= m.weight;
            mission += c.name + "(" + m.order_number + "): " + m.weight + ", ";
        }
        
        mission = mission.substring(0, mission.length - 2);
        mission += "])"
        
        String sum = "Deliver to warehouse " + c.name + " total weight: " + total_weight + " "
            + mission + " dist: " + this.recent_travelled;
        System.out.println(sum);
    }
    
    public void goBack()
    {
        City c = this.current_city;
        for(int i = 0; i < c.names; i++)
        {
            if(c.names[i].equals(center))
            {
                this.distance_travelled += c.distances[i];
                System.out.println("Distance traveled + " + this.distance_travelled);
                this = new Truck(number++);
            }
        }
    }
}
