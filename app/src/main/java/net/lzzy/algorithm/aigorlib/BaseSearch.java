package net.lzzy.algorithm.aigorlib;

import android.util.Pair;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public abstract class BaseSearch<T extends Comparable<? super T>>  {
    T[] items;
    private long duration;
    int compareCount;
    int swapCount;
    int moveStep;
    public Object directSort;

    BaseSearch(T[] items) {
        this.items=items;
        compareCount = 0;
        swapCount = 0;
        moveStep = 0;

    }
    public BaseSearch(){

    }
    boolean equal(T a,T b){
        compareCount++;
        return  a.compareTo(b)==0;
    }
    int compare(T a,T b){
        compareCount++;
        return  a.compareTo(b);
    }
   public abstract int search(T key);

    public long getDuration() {
        return duration;
    }

    void setDuration(long duration) {
        this.duration = duration;
    }

    public int getCompareCount() {
        return compareCount;
    }
    public void setCompareCount(int compareCount) {
        this.compareCount=compareCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public void setSwapCount(int swapCount) {
        this.swapCount = swapCount;
    }
}
