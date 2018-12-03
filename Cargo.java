import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class Cargo implements Comparable<Cargo>
{
    Integer     weight;
    int     order_number;
    Warehouse warehouse;
    
    public Cargo(int w, int oN, Warehouse ware)
    {
        weight       = w;
        order_number = oN;
        warehouse    = ware;
    }
    
    public int compareTo(Cargo c2)
    {
        return this.weight.compareTo(c2.weight);
    }
}
