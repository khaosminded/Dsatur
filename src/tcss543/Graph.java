/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcss543;

import java.util.ArrayList;

/**
 *
 * @author chuningwei
 */
public class Graph {

    public boolean G[][];
    public ArrayList<Vertex> verticesList;
    public ArrayList<Vertex> uncoloredList;
    public double density;

    public Graph() {
        verticesList = new ArrayList();
        uncoloredList = new ArrayList();
    }

    public Graph RandomGraph(double density, int numVer) {
        this.density=density;
        G = new boolean[numVer][numVer];
        for (int i = 0; i < numVer; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    G[i][j] = false;
                    continue;
                }
                if (Math.random() <= density) {
                    G[i][j] = G[j][i] = true;
                } else {
                    G[i][j] = G[j][i] = false;
                }
            }
        }
        for (int i = 0; i < G.length; i++) {
            int adjDegree = 0;
            for (int j = 0; j < G.length; j++) {
                if (G[i][j]) {
                    adjDegree++;
                }
            }
            verticesList.add(new Vertex(i, adjDegree));

        }
        uncoloredList.addAll(verticesList);
        return this;
    }

    public static void print(boolean[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] ? '#' : ' ');
            }
            System.out.print("\n");
        }
    }

}
