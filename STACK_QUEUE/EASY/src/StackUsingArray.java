public class StackUsingArray {
    int [] arr= new int[10000];
    int top=-1;

    public void push(int x) {
        top++;
        arr[top]=x;
    }

    public int pop() {
        if(!isEmpty()){
            int x = arr[top];
            top--;
            return x;
        }
        return -1;
    }

    public int top() {
        if (!isEmpty()) {
            return arr[top];
        }
        return -1;
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public int size(){
        return top+1;
    }
}
