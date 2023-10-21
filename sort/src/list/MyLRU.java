package list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyLRU {

    static class Node{
        int key,value;
        Node prev,next;
        public Node(int k,int v){
            this.key = k;
            this.value = v;

        }
    }

    private Map<Integer,Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);


    private int k;

    public int[] LRU(int[][] operators,int k){

        this.k = k;
        head.next = tail;
        tail.prev = head;

        int len = (int)Arrays.stream(operators).filter(x->x[0] == 2).count();
        int[] ans = new int[len];
        int cnt = 0;

        for(int i=0;i<operators.length;i++){
            if(operators[i][0]==1){
                set(operators[i][1],operators[i][2]);
            }else{
                ans[cnt++] = get(operators[i][1]);
            }
        }
        return ans;
    }


    public void set(int k,int v){
        if(get(k)>-1){
            map.get(k).value = v;
        }else{
            if(map.size()==k){
                int rk = tail.prev.value;
                map.remove(rk);

                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }

            Node node = new Node(k,v);
            map.put(k,node);
            removeToHead(node);
        }
    }

    public int get(int k){
        if(map.containsKey(k)){
            Node node = map.get(k);

            node.prev.next = node.next;
            node.next.prev = node.prev;

            removeToHead(node);
            return node.value;

        }
        return -1;



    }

    public void removeToHead(Node node){
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;


    }


}
