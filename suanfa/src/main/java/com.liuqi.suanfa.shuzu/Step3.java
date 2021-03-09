package com.liuqi.suanfa.shuzu;

import java.util.ArrayList;
import java.util.List;

;

/**
 * 按顺时针的方向，从外到里打印矩阵的值。
 *
 * @auther liuqi
 * @create 2020-12-18  16:21
 */
//例如下面矩阵：打印的结果应该是 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
//一层一层从外到里打印，观察可知每一层打印都有相同的处理步骤，唯一不同的是上下左右的边界不同了。因此使用四个变量 r1, r2, c1, c2 分别存储上下左右边界值，从而定义当前最外层。打印当前最外层的顺序：从左到右打印最上一行->从上到下打印最右一行->从右到左打印最下一行->从下到上打印最左一行。应当注意只有在 r1 != r2 时才打印最下一行，也就是在当前最外层的行数大于 1 时才打印最下一行，这是因为当前最外层只有一行时，继续打印最下一行，会导致重复打印。打印最左一行也要做同样处理。
/*
-----------------
| 1 | 2 | 3 | 4 |
-----------------
| 5 | 6 | 7 | 8 |
-----------------
| 9 | 10| 11| 12|
-----------------
| 13| 14| 15| 16|
-----------------
      ||
      \/
-----------------
| 1 | 2 | 3 | 4 |
-----------------
| 5 |       | 8 |
-----       -----
| 9 |       | 12|
-----------------
| 13| 14| 15| 16|
-----------------
       +
    ---------
    | 6 | 7 |
    ---------
    | 10| 11|
    ---------
 */
public class Step3 {
    public static void main(String[] args) {
        int[][] juzheng=new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List list=PrintMatrixClockwise(juzheng);
        System.out.println("----------------------------------------");
        System.out.print("|");
        for (int i=0; i < list.size(); i++) {
            int o=(Integer) list.get(i);
            System.out.print(o);
            System.out.print("|");
        }
        System.out.println();
        System.out.println("----------------------------------------");

    }





    public static List PrintMatrixClockwise(int[][] juzheng) {
        //定义起始行和最后一行的索引
        int r0=0;
        int rmax=juzheng.length - 1;
        //定义起始列和最后一列的索引
        int c0=0;
        int cmax=juzheng[0].length - 1;
        ArrayList<Object> list=new ArrayList<>();
        while (r0 <= rmax && c0 <= cmax) {
            //上
            for (int i=c0; i <= cmax; i++) {

                list.add(juzheng[r0][i]);

            }
            //右
            for (int i=r0 + 1; i <= rmax; i++) {
                list.add(juzheng[i][cmax]);
            }
            //判断有最后一行才打印
            if (r0 != rmax) {
                //下
                for (int i=cmax - 1; i >= c0; i--) {
                    list.add(juzheng[rmax][i]);
                }
            }
            //判断有最右一列才打印
            if (c0 != cmax) {
                //右
                for (int i=rmax - 1; i >= r0 + 1; i--) {
                    list.add(juzheng[i][c0]);
                }
            }
            r0++;
            rmax--;
            c0++;
            cmax--;
        }
        return list;
    }
}
