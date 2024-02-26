package listNode;

import java.util.Arrays;

public class ListNodeDemo {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }


    //递归反转链表
    public static ListNode reverseList(ListNode head) {
        if (head ==
    private static void bubbleSort(int[] arr) {
         for (int i = 0; i < arr.length - 1; i++) {
             for (int j = 0; j < arr.length - 1 - i; j++) {
                 if (arr[j] > arr[j + 1]) {
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
                 }
             }
         }

     }
 ] = arr[j + 1];
                     arr[j + 1] = temp;
                 }
             }
         }

     }
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        //快慢指针算法
       /* int[] arr = {1,2,3,3,4,4,5};
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        System.out.println(i+1);*/
        //寻找数组的中心索引
     /*   int[] nums={1,7,3,6,5,6};
        int left=0;
        int total=0;
        int sum = Arrays.stream(nums).sum();
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            if(total==sum){
                left=i;
                System.out.println(left);
                break;
            }
            sum-= nums[i];
        }*/

        //滑动窗口算法
        //二分查找算法
        int x = 24;
        int index = -1;
        int l = 0, r = x;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(index);
        //线性算法 求数组中三个数的乘积最大值
        int[] arr = {-9, -7, 3, 22, 19, -4, 5, 6, -7, 8, 9};
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }
            if (i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
        }
        System.out.println(Math.max(min1*min2*max1, max1*max2*max3));

        //分治算法
        //动态规划算法
        //贪心算法
        //回溯算法
        //分支限界算法
        //随机算法
        //位运算算法
        //字符串匹配算法
        //排序算法
        //查找算法
        //搜索算法
        //图算法
        //树算法


    }

}
