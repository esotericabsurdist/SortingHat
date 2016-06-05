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
	ArrayList<Integer> mData;
	
	//====================================================================================================================
	SortingHat()
	{
		this.mData = new ArrayList<Integer>();
	}
	//====================================================================================================================
	SortingHat(ArrayList<Integer> tData)
	{
		this.mData = tData; 
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
					swap(j-1, j);
				}
			}
		}
	}
	//====================================================================================================================
	public void selectionSort()
	/*
	 * Selection sort is O(n^2), in-place, stable, adaptive. 
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
				if(this.mData.get(j) < this.mData.get(tCurrentMin))  tCurrentMin = j;
			}
			
			// now that we have the smallest element, swap the element to the back of the sorted end of the array. 
			swap(i, tCurrentMin); 
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
						swap(j, j-1);
				}
			}
		}
	
	//====================================================================================================================
	private void swap(int tIndexX, int tIndexY)
	{
		// Simple swap
		int tValX = this.mData.get(tIndexX);
		int tValY = this.mData.get(tIndexY);
		
		this.mData.set(tIndexX, tValY);
		this.mData.set(tIndexY, tValX);
	}
	//====================================================================================================================
	public void printData()
	{
		System.out.print("\nValues:\n");
		
		for(Integer val : this.mData)
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
