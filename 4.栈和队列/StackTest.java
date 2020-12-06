import java.util.Arrays;

public class StackTest {

    public static void main(String[] args) {
       SeqStack<Integer> seqStack = new SeqStack<>();
       seqStack.push(1);
       seqStack.push(2);
       seqStack.push(3);
       System.out.println(seqStack.pop());
       System.out.println(seqStack.pop());
       System.out.println(seqStack.peek());
       System.out.println(seqStack.isEmpty());
       System.out.println(seqStack.pop());
    }
}
