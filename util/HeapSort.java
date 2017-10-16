package csc202.FinalProject.util;

public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        GenericHeap<E> heap = new GenericHeap<>();

        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }

    public static <E extends Comparable<E>> void heapSort(MyArrayList<E> list){
        GenericHeap<E> heap = new GenericHeap<>();

        for (int i = 0; i < list.size(); i++)
            heap.add(list.get(i));
        for (int i = list.size() - 1; i >= 0; i--)
            list.set(i,heap.remove());


    }
}