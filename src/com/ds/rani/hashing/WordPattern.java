package com.ds.rani.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class WordPattern {

    /**
     * @param pattern Pattern string
     * @param str String with multiple words seperated by space
     * @return true if str follows pattern else return false
     */

    //Time complexity:o(n) where n is pattern length or number of words in str.
    //We are visiting every character in pattern and every word in string if number of characters in pattern is equal to number of words in str
    //Therefore time complexity=o(n+m)=>o(n+n)=>o(2n)=>o(n)

    //Space complexity:o(n)
    public  static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return false;

        String[] strArr = str.split( "\\s" );
        if (pattern.length() != strArr.length)
            return false;
        if (generateCharPattern( pattern ).equals( generateStringPattern( strArr ) ))
            return true;
        else
            return false;

    }

    /**
     * Helper method to create pattern of string. eg input ="egg"->011
     *
     * @param s input string
     * @return pattern string
     */
    private static String generateCharPattern(String s) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char ch : s.toCharArray()) {
            if (!map.containsKey( ch )) {
                map.put( ch, count++ );
            }
            sb.append( map.get( ch ) );
        }
        return sb.toString();
    }

    /**
     * Helper method to create pattern of array of string. eg input =[egg ,egg]->00
     *
     * @param arr input array of strings
     * @return pattern string
     */
    private static String generateStringPattern(String[] arr) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String str : arr) {
            if (!map.containsKey( str )) {
                map.put( str, count++ );
            }
            sb.append( map.get( str ) );
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println( wordPattern(pattern,str));
        System.out.println( wordPattern("abba","dog cat cat fish"));
    }
}