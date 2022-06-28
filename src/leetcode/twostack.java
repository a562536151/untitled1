package leetcode;

import java.util.Stack;

public class twostack {

    Stack<Integer> A,B;
    public twostack(){
            A = new Stack<>();
            B = new Stack<>();
    }

    public void addfirst(int val){
        A.push(val);
    }

    public int deletelast(){
        if(!B.isEmpty()) return B.pop();
        if(B.isEmpty()&&A.isEmpty()) return 0;
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.pop();
    }

    public static void main(String[] args) {
        twostack stack = new twostack();
        stack.addfirst(1);
        stack.addfirst(2);
        stack.deletelast();
    }
}
