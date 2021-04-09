package com.tuyano.gradle;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JAVAprac {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c=i-> System.out.print(i+", ");
        Predicate<Integer> p=i->i%2==1;
        Function<Integer,Integer>f=i->i/10;//1의 자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEven(p,c,list);
        List<Integer>newList=doSomething(f,list);
        System.out.println(newList);
    }
    static <T> List<T> doSomething(Function<T,T>f,List<T>list){
        List<T> newList=new ArrayList<T>(list.size());

        for(T i:list){
            newList.add(f.apply(i));
        }
        return newList;
    }
    static<T> void makeRandomList(Supplier<T>s,List<T>list){
        for(int i=0;i<10;i++){
            list.add(s.get());
        }
    }
    static<T> void printEven(Predicate<T>p,Consumer<T>c,List<T> list){
        System.out.print("[");
        for(T i:list){
            if(p.test(i))c.accept(i);
        }
        System.out.println("]");
    }
}


