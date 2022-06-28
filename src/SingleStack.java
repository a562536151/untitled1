import java.util.*;
public class SingleStack {
        public int[][] foundMonotoneStack (int[] arr){
            int len = arr.length;
            int[] right = new int[len];
            int[] left = new int[len];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < len; i++) {
                while(!stack.empty() && arr[i] < arr[stack.peek()]) {
                    int tempTop = stack.pop();
                    left[tempTop] = stack.empty() ? -1 : stack.peek();
                    right[tempTop] = i;
                }
                stack.push(i);
            }
            while(!stack.empty()) {
                int tempTop = stack.pop();
                if(!stack.empty()&&arr[tempTop]==arr[stack.peek()]){
                    left[tempTop] = -1;
                }
                else{
                    left[tempTop] = stack.empty() ? -1 : stack.peek();
                }
                right[tempTop] = -1;
            }
            int[][] ans = new int[len][2];
            for(int i = 0;i<right.length;i++){
                ans[i][0] = left[i];
                ans[i][1] = right[i];
            }
            return ans;
            // write code here
        }
}
