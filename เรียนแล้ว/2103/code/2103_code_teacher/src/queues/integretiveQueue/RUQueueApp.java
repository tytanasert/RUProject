
package integretiveQueue;

public class RUQueueApp {

    public static void main(String args[]) {
        RUCirQueue cirqueue = new RUCirQueue(10);
        RUDQueue dequeue = new RUDQueue(10);
        RUPriQUEUE priorityqueue = new RUPriQUEUE(10);
        int data1 = 5, pri1 = 5;
        int data2 = 10, pri2 = 4;
        int data3 = 15, pri3 = 1;
        int data4 = 20, pri4 = 3;
        //Using RUCirQueue
        System.out.println("----- Using Circular Queue ----");
        cirqueue.QINSERT(data1);
        cirqueue.QINSERT(data2);
        cirqueue.QINSERT(data3);
        cirqueue.QINSERT(data4);
        cirqueue.showDatainQueue();
        System.out.println("Remove 1:" + cirqueue.QDELETE());
        System.out.println("Remove 2:" + cirqueue.QDELETE());
        cirqueue.showDatainQueue();
        //Using RUDQueue
        System.out.println("----- Using Dequeue ----");
        dequeue.insertfront(data1);
        dequeue.insertfront(data2);
        dequeue.insertrear(data3);
        dequeue.insertrear(data4);
        dequeue.showDatainQueue();
        System.out.println("Remove 1:" + dequeue.deletefront());
        System.out.println("Remove 2:" + dequeue.deletefront());
        //Using RUPriQueue
        System.out.println("----- Using Priority Queue ----");
        priorityqueue.QINSERT(data1, pri1);
        priorityqueue.QINSERT(data2, pri2);
        priorityqueue.QINSERT(data3, pri3);
        priorityqueue.QINSERT(data4, pri4);
        priorityqueue.showDatainQueue();
        System.out.println("Remove 1:" + priorityqueue.QDELETE());
        System.out.println("Remove 2:" + priorityqueue.QDELETE());
    }

}
