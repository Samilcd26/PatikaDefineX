package org.example.business;

import org.example.data.MethodPattern;

import java.util.ArrayList;

public class Villa implements MethodPattern {
    private ArrayList<ArrayList> allVilla = new ArrayList<ArrayList>();
    @Override
    public ArrayList setEntity(ArrayList base) {
        allVilla.add(base);
        return allVilla.get(allVilla.size()-1);
    }

    @Override
    public ArrayList getEntity(ArrayList base) {
        return null;
    }

    @Override
    public double totalEntityPrice() {
        double totalPrice=0;

        for (int i=0;i<allVilla.size();i++){
            totalPrice+= (double) allVilla.get(i).get(4);
        }
        return totalPrice;
    }

    @Override
    public double avarageEntityArea() {
        double avarageM2=0;

        for (int i=0;i<allVilla.size();i++){
            avarageM2+= (double) allVilla.get(i).get(3);
        }
        return avarageM2/allVilla.size();
    }
}
