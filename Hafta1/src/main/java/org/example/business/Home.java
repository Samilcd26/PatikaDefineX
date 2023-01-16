package org.example.business;

import org.example.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class Home {
    public static ArrayList<ArrayList> allHome = new ArrayList<ArrayList>();
    public Home(){

    }

    public static List<BaseEntity> setHome(ArrayList<BaseEntity> base){
        allHome.add(base);

        System.out.println(allHome.get(0).get(4));
        return allHome.get(allHome.size()-1);
    }

    public static void totalHomePrice(){
        double totalPrice=0;

        for (int i=0;i<allHome.size();i++){
            totalPrice= (double) allHome.get(i).get(4);
        }
        System.out.println(totalPrice);
    }

    public static void avarageHomeArea(){
        double avaragem2=0;

        for (int i=0;i<allHome.size();i++){
            avaragem2= (double) allHome.get(i).get(3);
        }
        System.out.println(avaragem2/allHome.size());
    }
}
