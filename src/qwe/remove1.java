package qwe;
import java.util.*;

public class remove1 {

    public static void main(String[] args) {

    }

    public class ShowMeBug {
        public boolean solution(int[] sequence) {
            Set<Integer> removeData = new HashSet<Integer>();
            for (int i=1; i<sequence.length-1; i++){
                //A=sequence[i-1]，B=sequence[i]，C=sequence[i+1]
                //A<B>=C 判断移除B或C
                if (sequence[i-1]<sequence[i]&&sequence[i]>=sequence[i+1]){
                    if (sequence[i-1]<sequence[i+1])
                        removeData.add(i);
                    else
                        removeData.add(i+1);
                }
                //A>=B<C 判断移除A或B
                if (sequence[i-1]>=sequence[i]&&sequence[i]<sequence[i+1]) {
                    if (sequence[i-1]>=sequence[i+1])
                        removeData.add(i-1);
                    else
                        removeData.add(i);
                }
                //A>=B>=C 该数组一定无法形成递增
                if (sequence[i-1]>=sequence[i]&&sequence[i]>=sequence[i+1]){
                    return false;
                }
            }

            if (removeData.size()>1) {
                return false;
            }

            return true;
        }
    }
}
