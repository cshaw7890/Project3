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
    
    public Truck(int n)
    {
    //    current_city = graph.getCity(center);
        //capacity is 500
        number = n;
        distance_travelled = 0;
    }
    
    // public void proceed()
    // {
        // City c = this.current_city;
        
        // //Current place does not have anymore appropriate cargo order done
        // for(int i = 0; i < c.names.size(); i++)
        // {
            // City next_stop = graph.getCity(c.names.get(i));
            // if(next_stop.warehouse.order.size() > 0 && next_stop.warehouse.peek() < truck.capacity)
            // {
                // distance_travelled += distances.get(i);
                // this.current_city = next_stop;
            // }
        // }
    // }
}
