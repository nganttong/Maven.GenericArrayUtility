package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
        for (T itemInList : newList) {
            //checking if duplicate
            if(map.containsKey(itemInList)){
                map.put(itemInList, map.get(itemInList) + 1);
            } else {
                map.put(itemInList, 1);
            }
        }
        return map;
    }

//    public Integer countDuplicates(T valueToEvaluate) {
//        HashMap<T, Integer> dupes = getDuplicates();
//        return dupes.getOrDefault(valueToEvaluate, 0);
//    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        mergeThisBadBoy(arrayToMerge);
        HashMap<T, Integer> dupes = getDuplicates();
        return dupes.getOrDefault(valueToEvaluate, 0);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer maxAmountOfTimesOccured = 0;
        T value = null;
        mergeThisBadBoy(arrayToMerge);
        HashMap<T,Integer> valueCounter = getDuplicates();
        for (T item : newList){
            Integer count = valueCounter.getOrDefault(item, 0);
            if (count > maxAmountOfTimesOccured){
                maxAmountOfTimesOccured = count;
                value = item;
            }
        }
        return value;
    }


    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        return getDuplicates().get(valueToEvaluate);
    }


    public T[] removeValue(T valueToRemove) {
        Integer removeCounter = getNumberOfOccurrences(valueToRemove);
        Integer counter =0;
        T[] newArray = Arrays.copyOf(this.content, this.content.length - removeCounter);
        for (T item : newList){
            if(!item.equals(valueToRemove)){
            newArray[counter++] = item;
            }
        }
        return newArray;
    }


}
