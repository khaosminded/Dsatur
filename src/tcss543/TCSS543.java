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
    final static int N_vertices[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    public static void main(String[] args) {

        runTest();

    }

    public static void runTest() {
        for (int i = 0; i < 4; i++) {
            for (int num : N_vertices) {
                //initialization
                TestSet set = new TestSet(N_graphs[i], Group[i][0], Group[i][1], num);
                //running sectoin
                long begin = java.lang.System.currentTimeMillis();
                for (Graph graph : set.graphList) {
                    Dsatur.howManyColorsWeNeed(graph);
                }
                long end = java.lang.System.currentTimeMillis();
                double duration = (end - begin) / 100.0;
                //section end
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
    }

}
