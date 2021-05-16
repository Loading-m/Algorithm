/**
 * 顺序表实现栈：静态数组实现，并且记录栈顶指针
 */
public class SeqStack<T>{

    /**
     * 栈顶指针,-1代表空栈
     */
    private int top = -1;

    /**
     * 容量大小默认为10
     */
    private int capacity = 10;

    /**
     * 存放元素的数组
     */
    private T[] array;

    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public SeqStack() {
        array = (T[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean push(T data) {
        if (top == capacity - 1) {
            //栈满返回失败或进行数组扩容
            return false;
        }
        //指针+1,加入新元素
        array[++top] = data;
        return true;
    }

    public T peek() {
        if(isEmpty()){
            return null;
        }
        return array[top];
    }

    public T pop() {
        if(isEmpty()){
            return null;
        }
        //返回栈顶元素，指针-1
        //逻辑删除
        return array[top--];
    }
}