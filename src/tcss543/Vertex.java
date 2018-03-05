/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcss543;

/**
 *
 * @author chuningwei
 */
public class Vertex {

    int id;
    int color;
    int adjcentDegree;
    int saturationDgree;

    public Vertex(int id, int adjcentDegree) {
        this.id = id;
        this.color = -1;
        this.adjcentDegree = adjcentDegree;
        this.saturationDgree = 0;
    }

}
