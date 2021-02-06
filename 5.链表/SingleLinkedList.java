/**
 * 单链表，不带头节点实现
 */
public class SingleLinkedList<T> {
    private LNode head;

    public SingleLinkedList() {
    }

    public SingleLinkedList(LNode head) {
        this.head = head;
    }


    public boolean isEmpty() {
        //不带头节点，直接判断head是否为空
        return this.head == null;
    }

    /**
     * 按位序插入
     *
     * @param i    index 从1开始
     * @param data
     * @return
     */
    public boolean insert(int i, T data) {
        if (data == null || i < 1) {
            return false;
        }
        if (i == 1) {
            //不带头节点需要更改单链表节点指向
            LNode newNode = new LNode(data, this.head);
            this.head = newNode;
            return true;
        }
        //找到第index - 1个节点之后，插入元素
        LNode p = getNode(i - 1);
        if (p == null) { //i不合法，i-1节点是null,自然也无法插入i节点
            return false;
        }
        return insertNextNode(p, data);
    }

    /**
     * 尾插法，每次都从头遍历到尾节点，时间复杂度n^2
     * 需要优化，思路：增加一个记录尾节点的指针，插入尾节点后，更新指针
     * @param data
     * @return
     */
    public boolean add(T data) {
        if (data == null) {
            return false;
        }
        if (this.head == null) {
            this.head = new LNode<T>(data, this.head);
            return true;
        }
        LNode<T> p = this.head;
        while (p.next != null) {
            p = p.next;
        }
        insertNextNode(p, data);
        return true;
    }

    /**
     * 指定节点后插入元素
     *
     * @param p
     * @param data
     * @return
     */
    public boolean insertNextNode(LNode p, T data) {
        if (p == null) {
            return false;
        }
        //创建新节点，同时指向p的next节点
        LNode newNode = new LNode(data, p.next);
        //将新节点挂在p节点后
        p.next = newNode;
        return true;
    }

    /**
     * 指定节点前插入元素
     *
     * @param p
     * @param data
     * @return
     */
    public boolean insertPriorNode(LNode p, T data) {
        if (p == null) {
            return false;
        }
        //单链表没有前驱节点所以可以把新节点和p节点的数据互换
        //复制p节点插入p节点之后
        LNode newNode = new LNode(p.data, p.next);
        //将新节点挂在p节点后
        p.next = newNode;
        //将p节点数据更新为插入节点数据，实现前插
        p.data = data;
        return true;
    }

    /**
     * 按位删除节点
     *
     * @param i 从1开始
     * @return
     */
    public T delete(int i) {
        if (i < 1) {
            return null;
        }
        T old;
        if (this.head != null && i >= 1) {
            if (i == 1) {
                old = (T) this.head.data;
                this.head = this.head.next;
                return old;
            }

            //找到第index - 1个节点之后，删除元素
            LNode p = getNode(i - 1);

            if (p == null || //i不合法，i-1节点是null,自然也无法删除i节点
                    p.next == null) { //p节点之后没有其它节点
                return null;
            }
            LNode q = p.next;//获取待删除的节点
            old = (T) q.data;// 返回删除节点的值
            p.next = q.next; // 将p的next指针指向删除节点的next指针，断开链接
            return old;
        }
        return null;

    }

    /**
     * 按位序查找
     *
     * @param i 从1开始
     * @return
     */
    public LNode getNode(int i) {
        if (i < 1) {// 位序不合法
            return null;
        }
        if (this.head != null && i >= 1) {
            if (i == 1) {
                return this.head;
            }
            //找到第i个节点
            LNode p;//指向当前扫描的节点
            int j = 1;//当前p指向的是第几个节点
            p = this.head; //从第一个节点开始扫描
            while (p != null && j < i) { //循环找到i个节点
                p = p.next;
                j++;
            }
            return p;
        }
        return null;
    }

    public T get(int i) {
        LNode node = getNode(i);
        if (node != null) {
            return (T) node.data;
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "(";
        LNode<T> pre = this.head;
        while (pre != null) {
            str += pre.data;
            pre = pre.next;
            if (pre != null) {
                str += ", ";
            }
        }
        return str + ")";
    }

    /**
     * 按值查找
     *
     * @param data
     * @return
     */
    public LNode locateNode(T data) {

        if (this.head != null && data != null) {
            LNode<T> p = this.head;
            while (p != null && !data.equals(p.data)) {
                p = p.next;
            }
            return p;
        }
        return null;
    }

    /*
     获取单链表长度
     */
    public int length() {
        int length = 0;
        LNode<T> p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }


}