package com.concur.zk.algorithm.tree;


import com.concur.zk.algorithm.linear.queue.Queue;

/**
 * 二叉查找树
 */
public class BinaryTree<K extends Comparable<K>, V> {

    public Node root;

    public int length;

    public int size() {
        return length;
    }

    public BinaryTree() {

        length = 0;
        root = null;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void put(K key, V value) {

        Node node = new Node(key, value, null, null);
        put(root, node);
    }

    private void put(Node curr, Node node) {

        if (isEmpty()) {
            root = node;
            length++;
        } else {
            if (node.key.compareTo(curr.key) < 0) {
                if (curr.left != null) {
                    curr = curr.left;
                    put(curr, node);
                } else {
                    curr.left = node;
                    length++;
                }
            } else if (node.key.compareTo(curr.key) > 0) {
                if (curr.right != null) {
                    curr = curr.right;
                    put(curr, node);
                } else {
                    curr.right = node;
                    length++;
                }
            } else {
                curr.value = node.value;
            }
        }
    }

    public V get(K key) {

        if (isEmpty()) {
            return null;
        } else {
            return (V) get(root, key).value;
        }
    }

    private Node get(Node root, K key) {

        Node cur = root;
        while (cur != null && cur.key.compareTo(key) != 0) {
            if (cur.key.compareTo(key) < 0) {
                cur = cur.right;
            } else if (cur.key.compareTo(key) > 0) {
                cur = cur.left;
            }
        }
        return cur == null ? null : cur;
    }

    private Node getPre(Node root,K key){

        Node cur = root;
        Node pre = root;
        while (cur != null && cur.key.compareTo(key) != 0) {
            if (cur.key.compareTo(key) < 0) {
                pre=cur;
                cur = cur.right;
            } else if (cur.key.compareTo(key) > 0) {
                pre=cur;
                cur = cur.left;
            }
        }
        return pre == null ? null : pre;
    }

    public void remove(K key) {

        remove(root,key);
    }

    private Node remove(Node x,K key){

        //x==null没找到元素删除失败
        if(x==null){
            return null;
        }
        //找元素：
        int cmp= key.compareTo((K)x.key);
        if(cmp>0){
            x.right=remove(x.right,key);
        }else if(cmp<0){
            x.left=remove(x.left,key);
        }else{
            if(x.right==null){
                return x.left;
            }
            if(x.left==null){
                return x.right;
            }
            Node min=x.right;
            Node pre=null;
            while(min.left!=null){
                pre=min;
                min=min.left;
            }
            if(pre!=null) pre.left=null;
            min.left=x.left;
            min.right=x.right;
            x=min;
        }
        return x;
    }

    public Queue<K> preTravel(){

        Queue<K> queue=new Queue<>();
        queue=preTravel(root,queue);
        return queue;
    }

    public Queue<K> preTravel(Node node, Queue<K> queue){
        if(node==null){
            return queue;
        }
        queue.enqueue((K) node.key);
        preTravel(node.left,queue);
        preTravel(node.right,queue);
        return queue;
    }

    public Queue<K> midTravel(){

        Queue<K> queue=new Queue<>();
        queue=midTravel(root,queue);
        return queue;
    }

    public Queue<K> midTravel(Node node, Queue<K> queue){
        if(node==null){
            return queue;
        }
        if(node.left!=null){
            midTravel(node.left,queue);
        }
        queue.enqueue((K) node.key);
        if(node.right!=null){
            midTravel(node.right,queue);
        }
        return queue;
    }
    public Queue<K> afterTravel(){

        Queue<K> queue=new Queue<>();
        queue=afterTravel(root,queue);
        return queue;
    }

    public Queue<K> afterTravel(Node node, Queue<K> queue){
        if(node==null){
            return queue;
        }
        afterTravel(node.left,queue);
        afterTravel(node.right,queue);
        queue.enqueue((K) node.key);
        return queue;
    }

    public Queue<K> layerTravel(){

        Queue<Node> temp=new Queue<>();

        Queue<K> result=new Queue<>();
        temp.enqueue(root);
        return layerTravel(temp,result);
    }

    private Queue<K> layerTravel(Queue<Node> temp, Queue<K> result){
        while(!temp.isEmpty()){
            Node node=temp.dequeue();
            if(node.left!=null){
                temp.enqueue(node.left);
            }
            if(node.right!=null){
                temp.enqueue(node.right);
            }
            result.enqueue((K) node.key);
        }
        return result;
    }


    private class Node<K extends Comparable<K>, V> {

        public Node left;
        public Node right;
        public K key;
        public V value;

        public Node(K  key, V value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }

    }
}
