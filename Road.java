import java.util.*;
import java.io.*;
/**
 * CS150, Project 3
 * @author (Carson Shaw & Jason Wu)
 */
public class Road
{
    City u; //first end point
    City v; //second end point
    int  w; //weight

    public Road(City u, City v, int w)
    {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}
