package com.ds.rani.algo;

/**
 * Given an array , I th number in an array is k distance apart from i-1 and i+1 number.(Array is sorted)
 * There is one number missing in the array find that element.
 */
public class MissingElement {

    //Time Complexity:o(log n) where n is number of element in an array
    //space complexity:o(1)
    /**
     * Find the missing element in an array
     * @param arr arry of integers, ith number in an array is arr[i-1]+k and arr[i+1]=arr[i]+k
     * @param k k is a distance between the neigbour elements
     * @return return the missing number else return -1
     */
    public static int findMissingElemnt(int [] arr,int k){
        //Binary search
        int left=0,right=arr.length-1;

        while(left<right){
            //To avoid integer flow
            int mid=left+(right-left)/2;

            //Check whether mid's next element is equal to arr[mid]+k,
            // if its not it means arr[mid]+k element is missing
            if(arr[mid]+k!=arr[mid+1])
                return arr[mid]+k;
            //difference between the indexes and the difference between element should be same if all numbers are present
            //if difference is same in left part then check in right part
            if(arr[mid]-arr[left]==(mid-left)*k){
                //search in right part
                left=mid+1;
            }else{
                //search in left part
                right=mid-1;
            }
        }
        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {

        int arr[] = {11, 14, 17, 20, 26};
        System.out.println( findMissingElemnt( arr,3 ) );

        int arr1[] = {1, 2, 3, 4, 5,6,8};
        System.out.println( findMissingElemnt( arr1,1 ) );
    }
}
