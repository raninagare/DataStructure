package com.ds.rani.hashing;

import java.util.*;

//Approach: Use hashmap to group anagrams,sort string use it as key,
// if two strings are anagram of each other then their sorted strings should be same and group them.
public class GroupAnagrams {
    //Time Complexity:o(n* k log k): where n is number of strings in input
    // and k is the average length of the input strings. I am sorting every string thats why (n* k log k)
    //Space complexity:
    /**
     * Given an array of strings, group all the anagrams together.
     * @param strs input strings
     * @return List of list of anagram strings
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        //Edge case
        if (strs == null || strs.length == 0)
            return result;

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //Take on string from the input at a time sort it and check whether sorted string is available in map as a key
        //If its already available in map then just add original string as a value in map.
        //else add sorted string as a key and original string in new list as a value.
        for (String str : strs) {
            char arr[] = str.toCharArray();
            Arrays.sort( arr );
            String key = String.valueOf( arr );

            List<String> list;
            if(!map.containsKey( key )) {
                list = new ArrayList<String>();
            } else {
                list = map.get( key );

            }
            list.add( str );
            map.put( key, list );
        }
        for (List<String> list : map.values()) {
            result.add( list );
        }
        return result;
    }

    /**
     * Helper method to print  lists
     * @param input
     */
    private static void printList(List<List<String>> input){
        for(List<String> innerList:input){
            for(String str:innerList){
                System.out.print(str+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        printList(groupAnagrams(input));
    }
}