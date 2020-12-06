/**
 * 单链表node节点
 */
public class LNode<T> {
    public T data; //节点数据
    public LNode<T> next;//下一节点指针

    public LNode(){}

    public LNode(T data){
        this.data=data;
    }

    public LNode(T data, LNode<T> next){
        this.data=data;
        this.next=next;
    }

}