package com.ds.rani.algo;

/**
 * Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
 * Accessing an element out of bounds throws exception.
 * If the number occurs multiple times, return the index of any occurrence. If its not present then return -1.
 */
public class SearchInSortedArray {
    public static int searchInArray(int [] nums,int target){
        //I will take 2 variables, forst is pointing to 0th element, 1st is pointing 1st element
        int slow=0;
        int fast=1;

        while(nums[fast]<target){
            slow=fast;
            fast=fast*2;
        }
        return binarySearch(nums,target,slow,fast);
    }

    public static int binarySearch(int[]nums, int target,int l,int r){

        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(target<nums[mid]) {
                r = mid - 1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int nums[]={0,1,24,5,6,7,10,12,14};
        int target=0;
        System.out.println(searchInArray(nums,target));
        target=3;
        System.out.println(searchInArray(nums,target));
    }
}
