package com.sophia.queue;

import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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
class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxsize){
        maxSize = arrMaxsize;
        arr= new int[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isFull(){
        return rear == maxSize -1;
    }
    public boolean isEmpty(){
        return front == rear;
    }
    public void addQueue(int n){
        if(isFull()){
            System.out.println("Queue is full ,you cannot add data");
            return;
        }else{
            rear++;
            arr[rear] = n;
        }


    }
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.you cannot get data");
        }else{
            front++;
            return arr[front];
        }
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty,no data");
        }else{
            for (int i = 0; i< arr.length;i++){
                System.out.printf("arr[%d] = %d\n",i ,arr[i]);
            }
        }
    }
    public int headQueue(){
        if(isEmpty()){
           throw new RuntimeException("Queue is empty,no data");
        }else{
            return arr[front+1];
        }
    }

}
