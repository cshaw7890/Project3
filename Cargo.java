import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class Cargo implements Comparable<Cargo>
{
    int     weight;
    int     order_number;
    
    public Cargo(int w, int oN)
    {
        weight       = w;
        order_number = oN;
    }
    
    public int compareTo(Cargo c2)
    {
        return (this.weight = c2.weight);
    }
}
