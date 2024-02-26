package jumpFloor;

public class Solution {
    public int JumpFloor(int number) {
        if (number <= 0)
            return 0;
        if (number == 1)
            return 1;
        if (number == 2)
            return 2;
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= number; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public int JumpFloorII(int target) {
        if(target<=0 ||target==1){
            return 1;
        }
        return JumpFloorII(target-1)+JumpFloorII(target-2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.JumpFloor(0));
        System.out.println(s.JumpFloor(1));
        System.out.println(s.JumpFloor(2));
        System.out.println(s.JumpFloor(3));
        System.out.println(s.JumpFloor(4));
        System.out.println(s.JumpFloor(5));
        System.out.println(s.JumpFloorII(6));
    }
}
