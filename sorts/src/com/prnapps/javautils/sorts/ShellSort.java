package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;

import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public abstract class ShellSort<D> implements ISort<D> {

    @Override
    public List<D> sort(List<D> list) {
        if(list == null){
            return list;
        }
        for(int increment = list.size()/2; increment > 0; increment /= 2) {
            for(int i = increment; i < list.size(); i++) {
                D temp = list.get(i);
                int j;
                for(j = i; j >= increment; j -= increment) {
                    if(compare(temp, list.get(j-increment)) == list.get(j-increment)) {
                        list.set(j, list.get(j-increment));
                    } else {
                        break;
                    }
                }
                list.set(j, temp);
            }
        }
        return list;
    }
}
