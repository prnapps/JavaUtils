package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class SelectionSort<D> implements ISort<D> {

    public List<D> sort(List<D> list) {
        if(list == null || list.size() < 2){
            return list;
        }
        for(int i = 0; i < list.size(); i++) {
            int first = i;
            for(int j = i+1; j < list.size(); j++) {
                if(compare(list.get(first), list.get(j)) < 0) {
                    first = j;
                }
            }
            if(first != i) {
                list = swap(list, first, i);
            }
        }
        return list;
    }

    protected List<D> swap(List<D> list, int index1, int index2) {
        D temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        return list;
    }
}
