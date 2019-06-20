package net.lzzy.algorithm.aigorlib;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class intsertSort<T extends Comparable<? super T>> extends BaseSort<T> {
    public intsertSort(T[] items) {
        super(items);
    }

    public void Sort() {
        //todo:直接插入排序
        for (int i = 1; i < items.length; i++) {
            if (bigger(items[i],items[i-1])) {
                T temp = items[i];//监视哨temp
                int k = i - 1;//k表示为有序区的最后一位
                for (int j = k; j >= 0 && bigger(items[j],temp); j--) {//从第i-1为向前并移动，直到找到小于第i位停止
                    items[j + 1] = items[j];
                    k--;//有序区域的位置减少
                }
                items[k + 1] = temp;
            }
        }

    }
}