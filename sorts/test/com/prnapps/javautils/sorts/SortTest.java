package com.prnapps.javautils.sorts;

import com.prnapps.javautils.sorts.interfaces.ISort;
import com.prnapps.javautils.sorts.mock.MockSortFactory;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 11/13/2015.
 */
public class SortTest extends TestCase {

    private MockSortFactory factory;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        factory = new MockSortFactory();
    }

    private void runSortTest(ISort sort) {
        // arrange
        int[] integers = {100, 1000, 1, 10};
        List<Integer> testList = new ArrayList<>();
        for (int integer : integers) {
            testList.add(integer);
        }

        // act
        List resultList = sort.sort(testList);

        // assert
        assertEquals(testList, resultList);
        assertEquals(1, (int) resultList.get(0));
        assertEquals(10, (int) resultList.get(1));
        assertEquals(100, (int) resultList.get(2));
        assertEquals(1000, (int) resultList.get(3));
    }

    public void testBubbleSort() {
        runSortTest(factory.createBubbleSort());
    }

    public void testHeapSort() {
        runSortTest(factory.createHeapSort());
    }

    public void testInsertionSort() {
        runSortTest(factory.createInsertionSort());
    }

    public void testMergeSort() {
        runSortTest(factory.createMergeSort());
    }

    public void testQuickSort() {
        runSortTest(factory.createQuickSort());
    }

    public void testSelectionSort(){
        runSortTest(factory.createSelectionSort());
    }

    public void testShellSort() {
        runSortTest(factory.createShellSort());
    }
}
