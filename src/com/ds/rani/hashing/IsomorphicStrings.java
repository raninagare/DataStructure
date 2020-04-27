package com.ds.rani.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {
    //Time complexity:o(n) where n is length of string s or t.
    // we are scanning both strings if there length is same and therefore it is o(n+m)==>o(n+n)==>o(2n)==>o(n)
    //Space complexity:o(n)

    /**
     * check whether two strings are isomorphic or not.
     *
     * @param s first string
     * @param t second string
     * @return true if s and t are isomorphic, else return false
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        return generatePattern( s ).equals( generatePattern( t ) );
    }

    /**
     * Helper method to create pattern of string. eg input ="egg"->011
     *
     * @param s input string
     * @return pattern string
     */
    private static String generatePattern(String s) {
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

    public static void main(String[] args) {
        String s = "abba", t = "lmml";
        System.out.println( isIsomorphic( s, t ) );
        System.out.println( isIsomorphic( "lmnn", "pqrs" ) );
    }
}

