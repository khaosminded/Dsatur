/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcss543;

/**
 *
 * @author hanxinlei
 */
public class Dsatur {

    public static int howManyColorsWeNeed(Graph graph) {
        int result = 0;

        while(!graph.uncoloredList.isEmpty())//#1
        {
            int maxs=Integer.MIN_VALUE;
            int maxa =Integer.MIN_VALUE;
            int ptr=-1;
            /**@firstSection**/
            //choose V with most saturation, if equals, choose one with max adj
            for(Vertex v : graph.uncoloredList)//#2
            {
                int satur=v.saturationDgree;
                maxs=satur>maxs?satur:maxs;
            }
            for(int i=0;i<graph.uncoloredList.size();i++)
            {
                Vertex v=graph.uncoloredList.get(i);
                int adj=v.adjcentDegree;
                if(v.saturationDgree==maxs && maxa<adj)
                {
                    maxa=adj;
                    ptr=i;
                }
            }
            
            /**@secondSection**/
            Vertex currentVertex=graph.uncoloredList.get(ptr);
            //color the chosen V with lowest color
            boolean []colorList = new boolean[graph.verticesList.size()];
            for(int i=0;i<colorList.length;i++)
                colorList[i]=false;
            
            int currentVerID= currentVertex.id;//#3
            for(int i=0;i<graph.G.length;i++)
            {
                if(graph.G[currentVerID][i]&& graph.verticesList.get(i).color>=0)
                {//i is adjcent to currentVertex
                    int colorIndex=graph.verticesList.get(i).color;
                    colorList[colorIndex]=true;
                }
            }

            for(int i=0;i<colorList.length;i++) //#4
                    if(colorList[i]==false)
                        currentVertex.color=i;
            //reset colorList preparing for next usage
            for(int i=0;i<colorList.length;i++)
                colorList[i]=false;
            
            for(int i=0;i<graph.G.length;i++) //#5
                if(graph.G[currentVerID][i])
                {
                    //each adj vertex of uncoloredList[ptr]
                    Vertex adj=graph.verticesList.get(i);
                    if(adj.color >=0)continue;
                    for(int j=0;i<graph.G.length;i++)
                        if(graph.G[i][j])
                        {
                            //each neighbor of adj
                            Vertex adj_adj=graph.verticesList.get(j);
                            if(adj_adj.color>=0)
                                colorList[adj_adj.color]=true;
                        }
                    int satur=0;
                    for(boolean b :colorList)
                        satur+=(b)?1:0;
                    //update saturation degree
                    adj.saturationDgree=satur;
                }
                    
            
            graph.uncoloredList.remove(ptr);
        }
        //traverse and sum up color consumption
        boolean []colorList = new boolean[graph.verticesList.size()];
        for(int i=0;i<colorList.length;i++)
            colorList[i]=false;
        graph.verticesList.forEach((v) -> {
            colorList[v.color]=true;
        });
        for(boolean b:colorList)
            result+=(b)?1:0;
        return result;
    }
}
