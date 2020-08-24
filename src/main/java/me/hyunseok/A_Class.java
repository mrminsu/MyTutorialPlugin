package me.hyunseok;

public class A_Class {
    int byeonSu; // 변수

    public A_Class(int a){
        //객체 초기 설정 블럭
        byeonSu = a;
        ChildClass cc = new ChildClass();
        ParentClass pc = new ParentClass();

        pc.parentMethod();
        cc.parentMethod();

        //대표적인 상속관계 in minecraft
        // Entity - LivingEntity - HumanEntity - Player
        // 플레이어는, 엔티티이면서, 살아있는 엔티티면서, 사람 엔티티이다.
        //집합!!!!!!!!!!!
    }

    public void sex(){

    }

    public int getByeonSu(){
        return  byeonSu;
    }
}
