package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

import javax.xml.transform.Templates;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
//                directSort();
                intsertSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现

        for (int i = 0;i<items.length-1;i++){
            int minPos=i;
            for (int j=i+1;j < items.length;j++){
                if (items[minPos].compareTo(items[j])>0){
                    minPos = j;
                }
            }
            swap(minPos,i);
        }
        
//        int temp;
//        for (i= 0;i<items.length-1;i++){
//            for(j=0;j<items.length-1;j++){
//                if (items[j]>items[j+1]){
//                    temp=items[j];
//                    items[j]=items[j+1];
//                    items[j+1]=temp;
//                }
//            }
//        }
    }
    private void intsertSort(){
        //todo:直接插入排序
        for (int i=1;i<items.length;i++){
            if (items[i]<items[i-1]){
                int temp=items[i];//监视哨temp
                int k=i-1;//k表示为有序区的最后一位
                for (int j=k;j>=0&&temp<items[j];j--){//从第i-1为向前并移动，直到找到小于第i位停止
                    items[j+1]=items[j];
                    k--;//有序区域的位置减少
                }
                items[k+1]=temp;
            }
        }
    }

    private void swap(int m, int n) {
        int tmp=items[m];
        items[m]=items[n];
        items[n]=tmp;
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
