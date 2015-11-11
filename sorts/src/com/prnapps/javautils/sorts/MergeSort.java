package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class MergeSort<D> implements ISort<D> {

    @Override
    public List<D> sort(List<D> list) {
        if(list == null){
            return list;
        }
        if(list.size() < 2) {
            int mid = list.size() / 2;
            List<D> left = new ArrayList<>();
            List<D> right = new ArrayList<>();
            for(int i = 0; i < mid; i++) {
                left.add(list.get(i));
            }
            for(int i = mid; i < list.size(); i++) {
                right.add(list.get(i));
            }
            list.removeAll(left);
            list.removeAll(right);
            left = sort(left);
            right = sort(right);
            merge(left, right, list);
        }
        return list;
    }

    private void merge(List<D> left, List<D> right, List<D> list) {
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(compare(left.get(i), right.get(i)) == left.get(i)) {
                list.add(left.get(i++));
            } else {
                list.add(right.get(j++));
            }
        }
        while(i < left.size()) {
            list.add(left.get(i++));
        }
        while(j < right.size()) {
            list.add(right.get(j++));
        }
    }
}
