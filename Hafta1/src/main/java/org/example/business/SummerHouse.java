package org.example.business;

import org.example.data.MethodPattern;

import java.util.ArrayList;

public class SummerHouse implements MethodPattern {
    private ArrayList<ArrayList> allSummerHouse = new ArrayList<ArrayList>();
    @Override
    public ArrayList setEntity(ArrayList base) {
        allSummerHouse.add(base);
        return allSummerHouse.get(allSummerHouse.size()-1);
    }

    @Override
    public ArrayList getEntity(ArrayList base) {
        return null;
    }

    @Override
    public double totalEntityPrice() {
        double totalPrice=0;

        for (int i=0;i<allSummerHouse.size();i++){
            totalPrice+= (double) allSummerHouse.get(i).get(4);
        }
        return totalPrice;
    }

    @Override
    public double avarageEntityArea() {
        double avarageM2=0;

        for (int i=0;i<allSummerHouse.size();i++){
            avarageM2+= (double) allSummerHouse.get(i).get(3);
        }
        return avarageM2/allSummerHouse.size();
    }
}
