package com.sophia.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"bob","bb");
        HeroNode hero2 = new HeroNode(2,"sam","ss");
        HeroNode hero3 = new HeroNode(3,"lulu","ll");
        HeroNode hero4 = new HeroNode(4,"cici","cc");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }
}

class SingleLinkedList{
    //head
    private HeroNode head = new HeroNode(0,",","");


//adding
public void add(HeroNode heroNode){
    HeroNode temp = head;
    while(true){
        if(temp.next == null){
            break;
        }
        temp = temp.next;
    }
    temp.next = heroNode;
}

public void list(){
    if(head.next == null){
        return;
    }
    HeroNode temp = head.next;
    while(true){
        if(temp == null){
            break;
        }
        System.out.println(temp);
        temp = temp.next;
    }
}
}
class HeroNode{
    public  int no;
    public  String name;
    public String nickname;
    public HeroNode next;
//constructor
    public HeroNode(int no,String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickname = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
