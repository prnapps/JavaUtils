package com.prnapps.javautils.sorts.interfaces;

import java.util.List;

/**
 * Created by James on 11/11/2015.
 */
public interface ISort<D> {
    List<D> sort(List<D> list);
    int compare(D first, D second);
}
