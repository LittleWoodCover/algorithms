package com.concur.zk.algorithm.tree;

public class RBTree<K extends Comparable<K>, V> {


    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int length;

    public int size() {
        return length;
    }

    private boolean isRed(Node node) {

        if (node == null) return false;
        return node.color == RED;
    }

    private boolean isBlack(Node node) {

        if (node == null) return false;
        return node.color == false;
    }

    public V get(K key){

        return get(root,key);
    }

    private V get(Node root,K key){
        if(root==null){
            return null;
        }
        int cmp= key.compareTo(root.key);

        if(cmp>0){
            return get(root.right,key);
        }else if(cmp<0){
            return get(root.left,key);
        }else{
            return root.value;
        }
    }
    public void put(K key,V value){

        root=put(root,key,value);
        root.color=RED;
    }


    public Node put(Node h,K key,V value){

        //如果为空，说明是一颗空的树
        if(h==null){
            length++;
            return new Node(key,value,null,null,BLACK);
        }
        //如果不为空，就找到要插入的位置：
        int cmp=key.compareTo(h.key);
        if(cmp>0){
            //递归插入
            h.right=put(h.right,key,value);
        }else if(cmp<0){
            h.left=put(h.left,key,value);
        }else{
            h.value=value;
        }
        //因为采用的递归思想。先把最下面的节点进行旋转。
        // 然后依次往上对上面的节点进行旋转
        //妙啊
        if(isBlack(h.left)&&isRed(h.right)){
            h=rotateLeft(h);
        }

        if(isRed(h.left)&&isRed(h.left.left)){
            h=rotateRight(h);
        }

        if(isRed(h.left)&&isRed(h.right)){
            flipColor(h);
        }

        return h;
    }

    /**
     * 左旋：成为其右子节点的左子节点
     *              \                          \
     *              E                          S
     *            /  \\         left:        // \
     *           A     S       <===>        E     >s
     *                /  \     right       / \
     *               <s   >s             <e   >e
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {

        //获取右子节点
        Node x = h.right;
        //成为右子节点的左子节点。
        x.left=h;
        //右子节左子节点成为h的右子节点（比H大）
        h.right=x.left;
        //让x的颜色=h的color
        x.color=h.color;
        h.color=RED;
        return x;
    }

    /**
     * 右旋：成为其右子节点的左子节点
     *            \              \
     *            S              E
     *          // \           /  \\
     *         E     >s       A     S
     *       // \                  /  \
     *      <e   >e              e<_<s   >s
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h){

        //找到左子节点
        Node x=h.left;
        //成为其左子节点的右字节点
        x.right=h;
        h.left=x.right;
        x.color=h.color;
        h.color=RED;
        return x;
    }

    private void flipColor(Node h){

        h.color= RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    public class Node {

        public K key;
        public V value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(K key, V value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
