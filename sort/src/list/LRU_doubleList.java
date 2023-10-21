package list;

import java.util.*;

public class LRU_doubleList {

        static class Node{
            int key,value;
            Node prev,next;
            public Node(int key,int val){
                this.key = key;
                this.value = val;
            }
        }

        //声明一个map、两个链表和缓存容量
        private Map<Integer,Node> map = new HashMap<>();
        private Node head = new Node(-1,-1);
        private Node tail = new Node(-1,-1);
        //这个k是要在LRU中使用的
        private int k;


        //  二维数组就是数组元素还是数组，而且可以是不规则数组元素
        //  k：缓存容量
        public int[] LRU (int[][] operators, int k) {
            // 先初始化
            this.k = k;
            head.next = tail;
            tail.prev = head;

            //统计get操作有几次，每次都要返回一个结果
            int len =(int) Arrays.stream(operators).filter(x->x[0] == 2).count();
            //定义结果数组，保存结果
            int[] ans = new int[len];

            //这个是结果下标
            int cnt = 0;

            //遍历输入的数据
            for(int i=0;i < operators.length ;i++){
                //如果是1，说明是添加缓存
                if(operators[i][0] == 1){
                    //set需要两个值，key和value
                    set(operators[i][1],operators[i][2]);

                //否则是取缓存，直接把结果存到ans数组中
                }else{
                                                //这个1是个位置下标，位置上的值是key值
                    ans[cnt++] = get(operators[i][1]);
                }
            }
            return ans;
        }

        //set：先判断是否存在当前key

        //双链表就是head链表和tail链表
        public void set(int key,int value){
            //value值大于-1，说明不在头尾，get获得的是map里面该key的值，也就是缓存里有没有这个key
            //若该key已存在，不需要存入map，只需要更新
            if(get(key) > -1){
                //先存进map,
                //不需要存入链表吗？
                //这里只是操作一下map


                //存缓存只有第一次需要移到head节点之后，之后再存的话因为已存在，所以
                //本来key存在应该什么都不做，但是要想到key可能还是那个key，但是值不一定相同，所以需要更新值
                map.get(key).value = value;
                //存完之后移动到head节点后面
                removeToHead(new Node(key,value));
            //否则就是该key不存在，需要存入
            }else{
                //当map已达到缓存容量，需要进行节点删除

                if(map.size() == k ){
                //需要移除的节点就是紧邻tail的前一个节点

                    //先保存一下key，然后在map中删除这个键
                    int rk = tail.prev.key;
                    map.remove(rk);

                    //要让链表和map操作同步
                    //操作待删除结点前面的节点，将tail和其连接起来
                    tail.prev.prev.next = tail;
                    //操作tail，将tail的prev指向
                    tail.prev = tail.prev.prev;
                }
                //不过无论map满不满，都需要做将该key存入map和移到紧邻head节点后
                //当map还未满，可以直接存入
                //新建一个节点，存进缓存，并移到head节点后面
                Node node = new Node(key,value);
                map.put(key,node);
                removeToHead(node);
            }
        }


        //get方法实现比较单一，只是判断是否缓存存在，不存在直接返回，存在的话需要移动到head节点之后
        // 也可以认为就是缓存的value
        public int get(int key){
            //利用map，方便找到缓存是否存在，这个寻找是O（1）
            if(map.containsKey(key)){
                //如果存在，需要把map里的数据的前后指针进行调整，把找到的节点调整到紧邻head节点

                //如果存在，创建一个临时节点，把缓存赋值给临时节点，最终返回
                Node node = map.get(key);

                //要注意这并没有操作链表，因为map其实保存了链表的前后指针，这是为了让map里的数据和链表保持一致
                //为了保持一致，后面的removeToHead操作了链表

                //因为node节点要被移动到头节点后面，所以为了保持链表连续，需要将找到的node节点的前后节点连接起来
                node.prev.next = node.next;
                node.next.prev = node.prev;

                //移到head节点后面
                //removeToHead操作的是链表，因为这个方法操作的是head和tail
                removeToHead(node);
                //直接返回value
                return node.value;
            }
            return -1;
        }

        public void removeToHead(Node node){

        //第一阶段：让node节点和紧邻head的节点成链
            //第一步：对node操作，让node的next指向紧邻在head后面的节点
            node.next = head.next;

            //第二部：对紧邻head的节点进行操作，让其指向node节点
            //目的就是让最初head后面紧邻的节点处于node节点之后
            head.next.prev = node;

        //第一阶段：让node节点和head节点成链
            //第三步：让head的next指向node节点
            head.next = node;

            //第四步：最后让node节点的prev指向head
            node.prev = head;
        }
}