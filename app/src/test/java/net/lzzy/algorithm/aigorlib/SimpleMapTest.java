package net.lzzy.algorithm.aigorlib;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class SimpleMapTest {

    @Test
    public void TestIterateDepthFirst() {
        SimpleMap map=new SimpleMap(6);
        map.addEdge(0,1,1);
        map.addEdge(1,5,1);
        map.addEdge(0,2,1);
        map.addEdge(0,3,1);
        map.addEdge(0,4,1);
        String expected="0,1,5,2,3,4,";
        assertEquals(expected,map.iterateDepthFirst());
    }

    @Test
    public void iterateDepthFirst() {
        SimpleMap map=new SimpleMap(6);
        map.addEdge(0,1,1);
        map.addEdge(1,5,1);
        map.addEdge(0,2,1);
        map.addEdge(0,3,1);
        map.addEdge(3,4,1);
        String expected="0,1,2,3,5,4,";
        assertEquals(expected,map.iterateDepthFirst());
    }
}