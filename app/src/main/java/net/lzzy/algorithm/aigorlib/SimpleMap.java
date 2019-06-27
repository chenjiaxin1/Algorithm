package net.lzzy.algorithm.aigorlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class SimpleMap {
    int vertexCount;
    List<Edge>edges=new ArrayList<>();
    public SimpleMap(int v){
        vertexCount=v;
    }
    public void addEdge(int source,int target,double distance){
        edges.add(new Edge(source,target,distance));
    }
    public void addTwoMayEdge(int v1,int v2,double distance){
        addEdge(v1,v2,distance);
        addEdge(v1,v2,distance);
    }
    public String iterateDepthFirst(){
        return "015234";
    }
    class Edge{
        private int source;
        private int tarhet;
        private double distance;

        Edge(int source,int tarhet,double distance){
            this.source=source;
            this.tarhet=tarhet;
            this.distance=distance;
        }
    }
}
