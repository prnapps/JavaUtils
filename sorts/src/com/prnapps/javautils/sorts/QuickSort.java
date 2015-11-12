package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.List;

/**
 * Created by James on 11/12/2015.
 */
public abstract class QuickSort<D> implements ISort<D> {

    @Override
    public List<D> sort(List<D> list) {
        if(list == null || list.size() < 2){
            return list;
        }
        return quicksort(list, 0, list.size()-1);
    }

    protected List<D> swap(List<D> list, int index1, int index2) {
        D temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        return list;
    }

    protected List<D> quicksort(List<D> list, int index1, int index2) {
        int i = index1;
        int j = index2;
        D pivot = list.get(index1 + (index2 - index1)/2);
        while(i <= j) {
            while(compare(list.get(i), pivot) > 0) {
                i++;
            }
            while(compare(pivot, list.get(j)) > 0) {
                j++;
            }
            if(i <= j) {
                list = swap(list, i, j);
                i++;
                j++;
            }
        }
        if(index1 < j) {
            list = quicksort(list, index1, j);
        }
        if(i < index2) {
            list = quicksort(list, i, index2);
        }
        return list;
    }
}
