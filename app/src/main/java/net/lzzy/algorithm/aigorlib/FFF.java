package net.lzzy.algorithm.aigorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class FFF {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInstance(int key, T[] items) {
        BaseSearch<T>sort;
        switch (key){
            case 0:
                sort=new DirectSearch<>(items);
                break;
            case 1:
                sort=new BinarySearch<>(items);
                break;
            default:
                return null;
        }
        return sort;

    }
    public static String[]getSoryNames(){
        return new String[]{"顺序查找","二分查找","二叉排序处"};
    }

}

