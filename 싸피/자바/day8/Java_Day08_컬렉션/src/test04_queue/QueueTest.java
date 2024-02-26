//Queue
//-FIFO
//-Queue interface
//-LinkedList class
package test04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        
        //큐에 순차적으로 값 넣기
        for(int i=0;i<5;i++) {
        	queue.offer(i);
        }
        
        //큐에서 값 제거
        while(!queue.isEmpty()) {
        	System.out.println(queue.poll());//0 1 2 3 4
        }
    }
}
