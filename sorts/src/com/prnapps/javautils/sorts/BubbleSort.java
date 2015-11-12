package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class BubbleSort<D> implements ISort<D> {

    @Override
    public List<D> sort(List<D> list) {
        if(list == null || list.size() < 2){
            return list;
        }
        for(int i = 0; i < list.size(); i++) {
            for(int j = 1; j < list.size() - i; j++) {
                if(compare(list.get(j-1), list.get(j)) < 0) {
                    list = swap(list, j-1, j);
                }
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
