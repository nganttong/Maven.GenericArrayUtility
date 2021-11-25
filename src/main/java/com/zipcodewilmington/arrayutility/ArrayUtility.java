package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private ArrayList<T> newList;
    private T[] content;

    public ArrayUtility(T[] inputArray) {
        this.content = inputArray;
        this.newList = new ArrayList<T>();
        this.newList.addAll(Arrays.asList(inputArray));
    }

    private void mergeThisBadBoy(T[] arrayToMerge){
//        for (T item : arrayToMerge) {
//            newList.add(item);
//        }
        newList.addAll(Arrays.asList(arrayToMerge));
    }

    public HashMap<T,Integer> getDuplicates(){
        HashMap<T,Integer> map = new HashMap<>();
        for (T itemInList :
                newList) {
            //checking if duplicate
            if(map.containsKey(itemInList)){
                map.put(itemInList, map.get(itemInList) + 1);
            } else {
                map.put(itemInList, 1);
            }
        }
        return map;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        return null;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }


    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return getDuplicates().get(valueToEvaluate);
    }


    public T[] removeValue(T valueToRemove) {
        return null;
    }


}
