import java.util.Scanner;

public class Myque {
    int capacity=4;
    int[]q= new int[capacity];
    int front=0; int rear=-1; int current_size=0;
    void enqueue(int item){
        if (isfull()) System.out.println("queue is full cannot enqueue");
        else {
            rear=(rear+1)%capacity;
            q[rear]=item;
            current_size++;
        }
    }
    void dequeue(){
        if (isempty()) System.out.println("queue is empty ,cannt dequeue");
        else {
            front=(front+1)%capacity;
            current_size--;
            System.out.println("the item that was delete is:"+q[front-1]);
        }
    }
    void beforme(int item){
        int cnt=0; int f=0; int c;
        if (isempty()) System.out.println("queue is empty");
        else {
            for ( c=front; cnt<current_size; c++,cnt++ ) {
                if (c == capacity) c = 0;
                if (q[c] == item){f=1;break;}
            }
                if (f==0) System.out.println("number not found");
                else System.out.println(cnt+"client before you");


        }

    }


    void  size(){
        System.out.println("size is "+current_size+"available space"
        +(capacity-current_size));
    }
    void print(){
        if (!isempty())for (int i=0; i<current_size; i++)
            System.out.println(q[(i+front)%capacity]+",");
    }
    boolean isfull(){
        if (current_size==capacity)return true;
        else return false;
    }
    boolean isempty(){
        if (current_size==0)return true;
        else return false;
    }
}
class A{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Myque que=new Myque();
        boolean exit=true;
        System.out.println("1-enqueu 2-dequeue 3-size 4-print 5-beforeme 6-exit/n");
        do {
            System.out.println("enter your choice");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("enter your number you want enqueue");
                    que.enqueue(scanner.nextInt());break;
                case 2:que.dequeue();break;
                case 3:que.size();break;
                case 4:que.print();break;
                case 5:
                    System.out.println("for which number?");
                    que.beforme(scanner.nextInt());break;
                default:exit=!exit;

        }
    }while (exit);
}
}