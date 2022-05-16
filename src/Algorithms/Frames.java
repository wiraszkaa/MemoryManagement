package Algorithms;

import java.util.*;

public class Frames {
    int size;
    int currentIndex;
    HashMap<Integer, Integer> framesMap;
    public int[] framesArray;

    public Frames(int size) {
        this.size = size;

        framesMap = new HashMap<>();
        framesArray = new int[size];
        Arrays.fill(framesArray, -1);
    }

    public boolean contains(int index) {
        return framesMap.containsKey(index);
    }

    public boolean add(int reference) {
        if(currentIndex == size) {
            return false;
        }
        framesMap.put(reference, currentIndex);
        framesArray[currentIndex] = reference;
        currentIndex++;
        return true;
    }

    public void swap(int currReference, int newReference) {
        framesMap.put(newReference, framesMap.get(currReference));
        framesArray[framesMap.get(currReference)] = newReference;
        framesMap.remove(currReference);
    }

    public void randSwap(int newReference) {
        Random rd = new Random();
        int index = rd.nextInt(size);
        swap(framesArray[index], newReference);
    }

    public void optSwap(int[] array, int newReference) {
        int reference = framesArray[0];
        int duration = -1;
        for(int i: framesArray) {
            int temp = 0;
            for(int j: array) {
                if(i == j) {
                    break;
                }
                temp++;
            }
            if(temp > duration) {
                reference = i;
                duration = temp;
            }
        }
        swap(reference, newReference);
    }

    public int[] getFrames() {
        return framesArray;
    }
}
