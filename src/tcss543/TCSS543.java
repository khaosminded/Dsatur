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
public class TCSS543 {

    final static double Group[][] = {{0.73, 0.82}, {0.61, 0.72}, {0.44, 0.59}, {0.26, 0.34}};
    final static int N_graphs[] = {100, 100, 100, 100};
    final static int N_vertices[] = {1,10, 20, 30, 40, 50, 60, 70, 80, 90, 100,200,300,
            400,500,600,700,800,900,1000,2000,3000};

    public static void main(String[] args) {

        //runTest();
        TestSet set = new TestSet(N_graphs[2], Group[2][0], Group[2][1], 100);
        for(Graph graph:set.graphList)
        {
            System.out.println(graph.density);
        }


    }

    public static void runTest() {
        for (int i = 0; i < 4; i++) {
            for (int num : N_vertices) {
                //initialization
                TestSet set = new TestSet(N_graphs[i], Group[i][0], Group[i][1], num);
                long avgColor=0;
                //running sectoin
                long begin = java.lang.System.currentTimeMillis();
                for (Graph graph : set.graphList) {
                    avgColor+=Dsatur.howManyColorsWeNeed(graph);
                }
                long end = java.lang.System.currentTimeMillis();
                double duration = (end - begin) / 100.0;
                avgColor/=100;
                //section end
                if(num!=1)
                System.out.println("Group:"+(i+1)+" num_vertices:"+num+" duration:"+duration+" avg_color:"+avgColor);
            }
        }
    }

    private static void debug() {
        Graph g = new Graph();
        g.RandomGraph(0.3, 10);

        int result = Dsatur.howManyColorsWeNeed(g);
        g.verticesList.forEach((v) -> {
            System.out.println(v.color);
        });
        Graph.print(g.G);
        System.out.println(result);
        TestSet set = new TestSet(N_graphs[0], Group[0][0], Group[0][1], 100);
        for(Graph graph:set.graphList)
        {
            System.out.println(graph.density);
        }
    }

}
