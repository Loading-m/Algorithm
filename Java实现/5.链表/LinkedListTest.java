public class LinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list=new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());

        list.insert(2,22);
        System.out.println(list.toString());

        System.out.println(list.delete(3));
        System.out.println(list.toString());
    }
}
