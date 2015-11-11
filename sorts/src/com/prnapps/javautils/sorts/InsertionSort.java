package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class InsertionSort<D> implements ISort<D> {

    @Override
    public List<D> sort(List<D> list) {
        if(list == null){
            return list;
        }
        for(int i = 1; i < list.size(); i++) {
            for(int j = i; j > 0; j--) {
                if(compare(list.get(j-1), list.get(j)) == list.get(j)) {
                    D temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, temp);
                }
            }
        }
        return list;
    }
}
