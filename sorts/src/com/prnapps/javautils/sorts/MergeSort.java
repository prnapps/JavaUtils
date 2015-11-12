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
        if(list == null || list.size() < 2){
            return list;
        }
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
        return merge(left, right, list);
    }

    protected List<D> merge(List<D> left, List<D> right, List<D> list) {
        int i = 0, j = 0;
        while(i < left.size() && j < right.size()) {
            if(compare(left.get(i), right.get(i)) < 0) {
                list.add(right.get(j++));
            } else {
                list.add(left.get(i++));
            }
        }
        while(i < left.size()) {
            list.add(left.get(i++));
        }
        while(j < right.size()) {
            list.add(right.get(j++));
        }
        return list;
    }
}
