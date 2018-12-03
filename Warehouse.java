import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class Warehouse
{
    PriorityQueue<Cargo>    orders = new PriorityQueue<Cargo>();
    City c;
    
    public Warehouse(City city)
    {
        c = city;
    }
}
