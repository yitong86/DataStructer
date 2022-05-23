package com.sophia.stack;

import java.util.Scanner;

public class ArrayStack {
    public static void main(String[] args) {
        ArrayStackDemo stack = new ArrayStackDemo(4);
        String key = "";
        boolean loop = true;//control if it exits
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:");
            System.out.println("exit:");
            System.out.println("push: add an item");
            System.out.println("pop:remove an item");
            System.out.println("please enter :");
            key = scanner.next();
            switch (key){
                case"show":
                    stack.list();
                    break;
                case"push":
                    System.out.println("please enter:");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;

                case"pop":
                    try{
                        int res = stack.pop();
                        System.out.printf("%d\n",res);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case"exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("ending");
    }

    static class ArrayStackDemo {
        private int maxSize;
        private int[] stack;
        private int top = -1;//no data,initial

        //constructor
        public ArrayStackDemo(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[this.maxSize];
        }
        public boolean isFull(){
            return top == maxSize -1;
        }
        public boolean isEmpty(){
            return top == -1;
        }
       //add
        public void push(int value){
            if(isFull()){
                System.out.println("stack is full");
                return;
            }
            top++;
            stack[top] = value;
        }
        //remove
        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("Empty");
            }
            int value = stack[top];
            top--;
            return value;
        }
        //show stack
        public void list(){
            if(isEmpty()){
                System.out.println("Empty");
                return;
            }
            for(int i = top;i >=0;i--){
                System.out.printf("stack[%d] = %d\n",i,stack[i]);
            }

        }

    }
}