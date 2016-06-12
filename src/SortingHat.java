/*
 *  Robert W. Mitchell
 *  June 2016
 *  
 *  The SortingHat class provides a simple implementation of several sorting algorithms. 
 *  
 */

import java.util.ArrayList;
import java.util.Collections;

public class SortingHat 
{
	ArrayList<Integer> mData; // Used for storing unsorted and sorted data in the case of in-place sorts
	ArrayList<Integer> mHeap; // Used for heap sort. 
	
	//====================================================================================================================
	SortingHat()
	{
		this.mData = new ArrayList<Integer>();
		this.mData = new ArrayList<Integer>();
	}
	//====================================================================================================================
	SortingHat(ArrayList<Integer> tData)
	{
		this.mData = tData; // give it the data for sorting.
		this.mHeap = new ArrayList<Integer>(); // Don't give it any data, save that for buildHeap();
	}
	//====================================================================================================================
	public void Bubblesort()
	/*
	 *  Bubble sort is O(n^2), in-place, stable (with modification), adaptive (with modification)
	 *  Beginning with the first element, it is swapped upwards until it is greater than all preceding elements. 
	 *  This is done for each element in the array. In this manner, each element rises upwards like a bubble, hence its
	 *  name. 
	 */
	{
		for(int i = 0; i < this.mData.size(); i++)
		{
			for(int j = 1; j < (this.mData.size() - i); j++)
			{
				if(this.mData.get(j-1) > this.mData.get(j))
				{
					swap(this.mData, j-1, j);
				}
			}
		}
	}
	//====================================================================================================================
	public void selectionSort()
	/*
	 * Selection sort is O(n^2), in-place, stable, not-adaptive. 
	 * It works by selecting the smallest element in the array and placing it at the front.  It then finds the next smallest
	 * element and places it in the location adjacent and so on until the array is sorted. 
	 */
	{ 
		int tCurrentMin; // stores the index of the current smallest element in the container.
		
		for(int i = 0; i < this.mData.size(); i++)
		{
			
			tCurrentMin = i;
				
			// starting from i, find the location of the smallest element
			for(int j = i; j < this.mData.size(); j++)
			{
				if(this.mData.get(j) < this.mData.get(tCurrentMin))  
				{
					tCurrentMin = j;
				}
				
			}
			// now that we have the smallest element, swap the element to the back of the sorted portion of the array. 
			// in the case that consecutive values are equal, swapping i and tCurrentMin will make this sort unstable.
			// if we make a check to compare i and tCurrentMin, we can make this algorithm stable. 
			swap(this.mData, i, tCurrentMin); 
			
			
		}
	}	
	//====================================================================================================================
		public void insertionSort()
		/*
		 * Insertion sort is O(n^2), in-place, stable, adaptive. 
		 * It works by growing a list of sorted values at the beginning of the array. With each value it adds to the sorted
		 * portion of the array, it will insert it in the proper location.
		 */
		{
			for(int i = 0; i < (this.mData.size()-1); i++) 
			{
				for(int j = i+1; j > 0; j--) 
				{
					/*
					 * starting at position i+1, swap the element from i+1 to a position less than i+1 until elements 0 to i+1 
					 * are ordered).
					 * this maintains a sorted list at the front of the array. For each value of i, the sorted 
					 * list at the front of the array grows by 1 element until the entire array is sorted. 
					 */
					if(this.mData.get(j) < this.mData.get(j-1)) 
						swap(this.mData, j, j-1);
				}
			}
		}
	//====================================================================================================================
	public void quickSort()
	/*
	 * This function merely starts the quicksort algorithm such that sort can be invoked without the need 
	 * for passing arguments.
	 */
	{
		quickSort(1, this.mData.size());
	}
	//====================================================================================================================
	private void quickSort(int lo, int hi)
	{
		/*
		 * TODO
		 */
	}
	//====================================================================================================================
	public void mergeSort()
	/*
	 * This is an iterative implementation of merge sort.  It should deliver better performance than a recursive one by 
	 * elimination of the call stack.  
	 * 
	 * Mergesort is n*log(n), non-adaptive, stable(with modification, merge the left element first when two equal elements are 
	 * merged), inplace (if using linked lists, rearrange the pointers, otherwise not)
	 */
	{
		for(int i = 1; i <= (this.mData.size()/2); i *= 2)
			/*
			 * For each iteration, we merge another "level", so we count by doubling the index, hence i*=2
			 * i follows: 1, 2, 4, 8, 16, ... , number of elements/2
			 * 
			 * Here we are sorting inplace, so we conceptually define the "levels" by mapping the indices. If we are on the 
			 * lowest level, such that the number of subarrays is equal to n, then i = 1, if we go up one "level", i=2 and so on.
			 * The second to highest level, i=n/2.
			 */
		{
			for(int j = i; j < this.mData.size(); j += 2*i)
				/*
				 * For an iteration of i, merge another "level", this translates wholly to: 
				 * merge elements in groups of i, that is merge in groups of 1, then in groups of 2, then in groups of 4 an so on.
				 * To increment j by groups of size i, we count by 2*i, thus j+=2*i.
				 */
				
			{
				/*
				 * TODO MERGE
				 */
			}
			
		}
	}
	//====================================================================================================================
	public void heapSort()
	/*
	 * This function sorts data stored in the heap. Heap sort is an in-place algorithm. Worst case is n*log(n). 
	 * It sorts by swapping the last element, the n-1 element in the array to the front of the array, then reheapifies
	 * (reheap down) until the heap property is restored, but only restored as a heap of size n.  Then the n-2 element is
	 * swapped to the front and then reheapifies as an array of size n-2, then the same is carried out for n-3 and so on, 
	 * up to the n-n element. At this point the array will be ordered. This is better understood visually.  
	 * The heap must be initialized and built to call this function. 
	 * To build the heap, call buildHeap( data ) where data is an arraylist of the values to be placed in the heap.
	 */
	{
		for(int i = this.mHeap.size()-1; i > 0; i--)
		{
			swap(this.mHeap, 0, i);
			reheapDown(0, i);
		}
	}
	//====================================================================================================================
	public void buildHeap(ArrayList<Integer> tData)
	/*
	 * Constructs a maximum heap from tData
	 */
	{
		for(int i = 0; i < tData.size(); i++)
		{
			this.mHeap.add(tData.get(i));
			reheapUp(this.mHeap.size()-1); 
		}
	}
	//====================================================================================================================
	private void reheapUp(int tCurrentIndex)
	/*
	 * This takes the element from the tCurrentIndex position (the last inserted element in our case) and swaps it upwards 
	 * recursively until the heap property is restored. 
	 * The heap property in this case is a maximum heap, parents always have smaller values than children nodes. 
	 */
	{
		int tParentIndex = (tCurrentIndex - 1)/2; 
		
		if(this.mHeap.get(tParentIndex) < this.mHeap.get(tCurrentIndex))
		{
			swap(this.mHeap, tParentIndex, tCurrentIndex);
			reheapUp(tParentIndex);
		}
		
	}
	//====================================================================================================================
	private void reheapDown(int tCurrentIndex, int tHeapLimit)
	{
		
		// Find the index in the heap of each child based on the current parent. 
		int tLeftChild = (tCurrentIndex*2)+1;
		int tRightChild = (tCurrentIndex*2)+2;

		if( (tCurrentIndex < tHeapLimit) && (tRightChild < tHeapLimit) ) // don't access a child that isn't there.
		{
			// save data into temporary variables to reduce function calls and enhance clarity of code. 
			int	tLeftChildData = this.mHeap.get(tLeftChild);
			int tRightChildData = this.mHeap.get(tRightChild);
			int tCurrentIndexData = this.mHeap.get(tCurrentIndex);
			
			if( (tLeftChildData >= tRightChildData) && (tCurrentIndexData < tLeftChildData) ) 
			/*
			 *  if left child is greater or equal than right child and current is less than the child, swap them,
			 *  then check again. 
			 */
			{
					swap(this.mHeap, tLeftChild, tCurrentIndex);
					reheapDown(tLeftChild, tHeapLimit);
			}
			else if( (tLeftChildData < tRightChildData) && (tCurrentIndexData < tRightChildData) )
			/*
			 * If right child is greater than left child and current is less than the child, swap then,
			 * then check again. 
			 */
			{
					swap(this.mHeap, tRightChild, tCurrentIndex);
					reheapDown(tRightChild, tHeapLimit);
			}
		}
	}
	//====================================================================================================================
	private void swap(ArrayList<Integer> tData, int tIndexX, int tIndexY)
	{
		// Simple swap
		int tValX = tData.get(tIndexX);
		int tValY = tData.get(tIndexY);
		
		tData.set(tIndexX, tValY);
		tData.set(tIndexY, tValX);
	}
	//====================================================================================================================
	public void printData()
	{
		System.out.print("\nData:\n");
		
		for(Integer val : this.mData)
		{
			System.out.print(val + " ");
		}
		
		System.out.print("\nHeap:\n");
		
		for(Integer val : this.mHeap)
		{
			System.out.print(val + " ");
		}
		
		
	}
	//====================================================================================================================
	public void randomizeData()
	{
		Collections.shuffle(this.mData);
	}
	//====================================================================================================================
}
