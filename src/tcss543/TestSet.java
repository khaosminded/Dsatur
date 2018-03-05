/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcss543;

import java.util.ArrayList;

/**
 *
 * @author hanxinlei
 */
public class TestSet {
    public ArrayList<Graph> graphList;
    int Num_vertices;
    int Num_graphs;
    double DensityL;
    double DensityR;
    public TestSet(int Num_graphs, double DensityL, double DensityR,int Num_vertices)
    {
        this.Num_graphs=Num_graphs;
        this.DensityL=DensityL;
        this.DensityR=DensityR;
        this.Num_vertices=Num_vertices;
        for(int i=0;i<Num_graphs;i++)
        {
            Graph g=new Graph();
            g.RandomGraph(DensityL+Math.random()*DensityR, Num_vertices);
            graphList.add(g);
        }
    }
}
