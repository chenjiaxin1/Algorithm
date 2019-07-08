package net.lzzy.algorithm.aigorlib;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.transform.Result;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class SimpleMap {
    protected int start;
    int vertexCount;
    List<Edge>edges=new ArrayList<>();
    List<Integer>visited;

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
    private void iterateDepth(int v){
        if (!visited.contains(v)){
            visited.add(v);
        }
        if (visited.size()==vertexCount){
            return;
        }
        List<Edge> vEges=getConnectedEdges(v);
        for (Edge edge:vEges){
            if (visited.contains(edge.getTarhet())){
                continue;
            }
            iterateDepth(edge.getTarhet());
        }
    }


    public String iterateDepthFirst(){
//        return "015234";
//        visited=new ArrayList<>();
        StringBuilder result=new StringBuilder();
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(0);
        int head=0,tail=1;
        while (head<tail){
            Integer curcor=queue.poll();
            if (curcor==null){
                break;
            }
            result.append(curcor).append(",");
            List<Edge>vEdges=getConnectedEdges(curcor);
            for (Edge edge:vEdges){
                if (!queue.contains(edge.getTarhet())){
                    queue.offer(edge.getTarhet());
                        tail++;
                    }
                    if (tail>vertexCount){
                        break;
                    }
                }
                head++;
            }
            while (queue.size()>0){
                result.append(queue.poll().append(","));
            }
            return  result.toString();
        }

    List<Edge> getConnectedEdges(Integer curcor) {
    }

}
    class Edge{
        private int source;
        private int tarhet;
        private double distance;

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getTarhet() {
            return tarhet;
        }

        public void setTarhet(int tarhet) {
            this.tarhet = tarhet;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        Edge(int source, int tarhet, double distance){
            this.source=source;
            this.tarhet=tarhet;
            this.distance=distance;

        }
    }
}
