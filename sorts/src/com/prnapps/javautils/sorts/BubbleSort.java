package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class BubbleSort<D> implements ISort<D> {

    @Override
    public List<D> sort(List<D> list) {
        if(list == null){
            return list;
        }
        for(int i = 0; i < list.size(); i++) {
            for(int j = 1; j < list.size() - i; j++) {
                if(compare(list.get(j-1), list.get(j)) == list.get(j)) {
                    D temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
