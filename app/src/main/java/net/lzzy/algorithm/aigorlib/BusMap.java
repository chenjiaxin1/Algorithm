package net.lzzy.algorithm.aigorlib;

import android.util.SparseArray;

import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap extends SimpleMap {
    private SparseArray<String> vertexes;
    private double minDistance;
    private int start, target;

    public BusMap(int v) {
        super(v);
        vertexes = new SparseArray<>();
        for (int i = 0; i < v; i++) {
            vertexes.append(i, String.valueOf(i));
        }
    }

    public void setStart(int start) {
        this.start = start;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void rename(int i,String name){
        vertexes.setValueAt(i,name);
    }
    private void tryWay(int curVertex,double distance){
        if (minDistance>0&& distance>minDistance){
            return;
        }
        if (curVertex==target){
            if (minDistance==0||minDistance>distance){
                minDistance=distance;
            }
            return;
        }
        List<Edge>vEdges=getConnectedEdges(curVertex);
        for (Edge edge:vEdges){
            if (visited.contains(edge.getTarhet())){
                continue;
            }
            visited.add(edge.getTarhet());
            tryWay(edge.getTarhet(),distance+edge.getDistance());
            visited.remove(edge.getTarhet());
        }
    }
    private double[][]floyd(){
        double[][]distances=new double[vertexCount][vertexCount];
        for (int i=0;i<vertexCount;i++){
            for (int j=0;j<vertexCount;j++){
                distances[i][j]=999999;
            }
        }
        for (Edge edge:edges){
            distances[edge.getSource()][edge.getTarhet()]=edge.getDistance();
        }
        for (int k=0;k<vertexCount;k++) {
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][i]) {
                        distances[i][j] = distances[i][k] + distances[k][i];
                    }
                }
            }
        }
        return distances;
    }
    private double[]dijkstra(int source){
        double[]distances=new double[vertexCount];
        for (int i=0;i<vertexCount;i++){
            distances[i]=999999;
        }
        distances[source]=0;
        List<Edge>vEdges=getConnectedEdges(source);
        for (Edge edge:vEdges){
            distances[edge.getTarhet()]=edge.getDistance();
        }
        visited.add(source);
        for (int i=1;i<vertexCount;i++){
            double shortDistance=999999;
            for (int j = 0; j<vertexCount; j++){
                if (visited.contains(j)||distances[j]>=shortDistance){
                    continue;
                }
                shortDistance=distances[j];
                shortVertex=j;
            }
            visited.add(shortVertex);
            List<Edge>shortVertexEdges=getConnectedEdges(shortVertex);
            for (Edge edge:shortVertexEdges){
                if (distances[edge.getTarhet()]>distances[shortVertex]+edge.getDistance()){
                    distances[edge.getTarhet()]=distances[shortVertex]=edge.getDistance();
                }
            }
        }
        return distances;
    }
    public double getMinDistance(int key) {
        visited = new ArrayList<>();
        switch (key) {

        }
    }