package com.prnapps.javautils.sorts.mock;

import com.prnapps.javautils.sorts.*;

/**
 * Created by James on 11/13/2015.
 */
public class MockSortFactory {

    public BubbleSort createBubbleSort() {
        return new BubbleSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }

    public HeapSort createHeapSort() {
        return new HeapSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }

    public InsertionSort createInsertionSort() {
        return new InsertionSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }

    public MergeSort createMergeSort() {
        return new MergeSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }

    public QuickSort createQuickSort() {
        return new QuickSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }

    public SelectionSort createSelectionSort() {
        return new SelectionSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }

    public ShellSort createShellSort() {
        return new ShellSort<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
    }
}
