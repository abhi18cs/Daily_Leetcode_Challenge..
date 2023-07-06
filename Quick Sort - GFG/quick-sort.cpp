//{ Driver Code Starts
#include <stdio.h>
#include <bits/stdc++.h>
using namespace std;

/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

// } Driver Code Ends
class Solution
{
    public:
    //Function to sort an array using quick sort algorithm.
    void quickSort(int arr[], int low, int high)
    {
        // code here
   if(low < high){
            int index=partition(arr,low,high);  //from where we partition the array
            quickSort(arr,low,index-1); //recursive approch for sorting
            quickSort(arr,index+1,high);
        }
    }
    
    public:
    int partition (int arr[], int low, int high)
    {
       // Your code here
       int pivot=arr[high];     //last element as the pivot
       int i=low-1;     //make starting with the low-1 ie one less
       for(int j=low;j<high;j++)    //travels through the lower point to high
       {
           if(arr[j]<pivot)     //if the last element(pivot) is greater than the current then swap them and increase the front element 
           {
               i++; //to skip the current element while next iteration
               int temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp;
           }
       }
       i++;
       int temp=arr[i];
       arr[i]=pivot;
       arr[high]=temp;
       return i;
    }
};


//{ Driver Code Starts.
int main()
{
    int arr[1000],n,T,i;
    scanf("%d",&T);
    while(T--){
    scanf("%d",&n);
    for(i=0;i<n;i++)
      scanf("%d",&arr[i]);
      Solution ob;
    ob.quickSort(arr, 0, n-1);
    printArray(arr, n);
    }
    return 0;
}
// } Driver Code Ends