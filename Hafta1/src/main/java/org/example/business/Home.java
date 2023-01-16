package org.example.business;

import org.example.data.MethodPattern;

import java.util.ArrayList;

public class Home implements MethodPattern {
    private ArrayList<ArrayList> allHome = new ArrayList<ArrayList>();
    @Override
    public ArrayList setEntity(ArrayList base) {
        allHome.add(base);
        return allHome.get(allHome.size()-1);
    }

    @Override
    public ArrayList getEntity(ArrayList base) {
        return null;
    }

    @Override
    public double totalEntityPrice() {
        double totalPrice=0;

        for (int i=0;i<allHome.size();i++){
            totalPrice+= (double) allHome.get(i).get(4);
        }
        return totalPrice;
    }

    @Override
    public double avarageEntityArea() {
        double avarageM2=0;

        for (int i=0;i<allHome.size();i++){
            avarageM2+= (double) allHome.get(i).get(3);
        }
        return avarageM2/allHome.size();
    }
}
