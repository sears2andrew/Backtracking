/*
 * talked with mitchell and emily
 */
package project4;

import java.util.LinkedList;

/**
 *
 * @author andy
 */
public class EstateSplit {
    static boolean solve(int [] inputs, LinkedList<Integer> part1,LinkedList<Integer> part2){
        
        //call the extend method
        
        return extend(inputs, 0, part1, part2);
    }
    
    public static boolean extend(int [] inputs, int s, LinkedList<Integer> part1,LinkedList<Integer> part2){
        
        //calculate the totals for each linked list to allow exit condition checks
        
        int total1 = 0, total2 = 0;
        for(int i =0; i < part1.size(); i++){
            total1 += part1.get(i);
        }
        for(int l = 0;l < part2.size(); l++){
            total2 += part2.get(l);
        }
        
        //check if all the data points have been accounted for and if each list is equal
        
        if(s == inputs.length){
            return total1==total2;
        }
        
        //add the next input value to a part and try extending
        
        part1.add(inputs[s]);
        if(extend(inputs, s+1, part1, part2))
            return true;
        part1.removeLast();
        part2.add(inputs[s]);
        if(extend(inputs, s+1, part1, part2))
            return true;
        part2.removeLast();
        return false;
    }
}
