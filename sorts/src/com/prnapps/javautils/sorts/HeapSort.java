package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.List;

/**
 * Created by James on 11/12/2015.
 */
public abstract class HeapSort<D> implements ISort<D> {

    protected int total;

    @Override
    public List<D> sort(List<D> list) {
        if(list == null || list.size() < 2){
            return list;
        }
        total = list.size() - 1;
        for(int i = total/2; i >= 0; i--) {
            list = heapify(list, i);
        }
        for(int i = total; i > 0; i--) {
            list = swap(list, 0, i);
            total--;
            list = heapify(list, 0);
        }
        return list;
    }

    protected List<D> swap(List<D> list, int index1, int index2) {
        D temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        return list;
    }

    protected List<D> heapify(List<D> list, int i) {
        int left = i * 2;
        int right = left + 1;
        int last = i;
        if(left <= total && compare(list.get(left), list.get(last)) < 0) {
            last = left;
        }
        if(right <= total && compare(list.get(right), list.get(last)) < 0) {
            last = right;
        }
        if(last != i) {
            list = swap(list, i, last);
            list = heapify(list, last);
        }
        return list;
    }
}
