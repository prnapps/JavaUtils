package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class SelectionSort<D> implements ISort<D> {

    public List<D> sort(List<D> list) {
        if(list == null){
            return list;
        }
        for(int i = 0; i < list.size(); i++) {
            int first = i;
            for(int j = i+1; j < list.size(); j++) {
                if(compare(list.get(first), list.get(j)) == list.get(j)) {
                    first = j;
                }
            }
            if(first != i) {
                D temp = list.get(i);
                list.set(i, list.get(first));
                list.set(first, temp);
            }
        }
        return list;
    }
}
