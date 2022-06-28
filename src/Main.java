import java.util.*;


public class Main {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int  m= sc.nextInt();
            int[] nums=new int[m];
            for (int i = 0; i < m; i++) {
                nums[i]=sc.nextInt();
            }
            leftRightWay(nums);
        }

        private static void leftRightWay(int[] arr){
            int len = arr.length;
            int[] right = new int[len];
            int[] left = new int[len];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < len; i++) {
                while(!stack.empty() && arr[i] <= arr[stack.peek()]) {
                    int tempTop = stack.pop();
                    left[tempTop] = stack.empty() ? -1 : stack.peek();
                    right[tempTop] = i;
                }
                stack.push(i);
            }

            while(!stack.empty()) {
                int tempTop = stack.pop();
                left[tempTop] = stack.empty() ? -1 : stack.peek();
                right[tempTop] = -1;
            }

            for(int i = 0; i < len; i++) {
                System.out.println(left[i] + " " + right[i]);
            }
        }
    }





