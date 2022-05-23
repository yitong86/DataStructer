package com.sophia.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show): ");
            System.out.println("e(exit): ");
            System.out.println("a(add): ");
            System.out.println("g(get): ");
            System.out.println("h(head): ");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("output");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case'g':
                    try{
                        int result = queue.getQueue();
                        System.out.printf("%d\n",result);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int result = queue.headQueue();
                        System.out.printf("%d\n",result);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("ending");
    }
}
class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxsize){
        maxSize = arrMaxsize;
        arr = new int[maxSize];
    }
    public boolean isFull(){

        return (rear + 1) % maxSize == front;
        //(0 + 1) % 4 = 1 != front=0 return false
        //(1 + 1) % 4 = 2 != front =0 return false
        //(2 + 1) % 4 = 3 != front =0 return false
        // (3 + 1) % 4 = 0 = front = 0 return true->isfull/rear = 3,front = 0

    }
    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("Queue is full ,you cannot add data");
            return;
        }else{
           arr[rear] = n;
           rear = (rear + 1) % maxSize;
        }
    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.you cannot get data");
        }else{
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty,no data");
        }else{
            for (int i = front; i< front + size() ;i++){
                System.out.printf("arr[%d] = %d\n",i  % maxSize,arr[i  % maxSize]);
            }
        }
    }
    public  int size(){//rear= 2 front = 1 maxsize =3
        return (rear + maxSize -front) % maxSize;
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty,no data");
        }else{
            return arr[front];
        }
    }

}