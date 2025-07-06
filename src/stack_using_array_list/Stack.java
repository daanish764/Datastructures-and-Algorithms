package stack_using_array_list;

import java.util.ArrayList;
import java.util.List;

   
public class Stack {
    List<Integer> arrayList;
    int size;

    Stack(int size) {
        arrayList = new ArrayList<>(size);
        this.size = size;
    }

    void push(int x) {
        if(arrayList.size() == size) {
            System.out.println("Stack is full");
            return;
        }
        arrayList.add(x);
    }

    int pop() {
        if(arrayList.isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        return arrayList.remove(arrayList.size()-1);
    }

    int top() {
        if(arrayList.isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        }
        return arrayList.get(arrayList.size()-1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(3);
        System.out.println(stack.top());
        stack.push(4);
        System.out.println(stack.top());
        stack.push(5);
        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
