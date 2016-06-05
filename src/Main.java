
/*
 * Robert W. Mitchell
 * June 2016
 * 
 */
import java.util.*;
import java.io.*;



public class Main {
	
	//====================================================================================================================
	public static void main(String args[])
	{
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the file name of the numerical data to be sorted");
		String tFileName = keyboard.nextLine();
	
		readFile(tFileName, data);
		
		SortingHat greatSorter = new SortingHat(data);
		
		greatSorter.printData();
		greatSorter.Bubblesort();
		greatSorter.printData();
		
		greatSorter.randomizeData();
		
		greatSorter.printData();
		greatSorter.selectionSort();
		greatSorter.printData();
		
		greatSorter.randomizeData();
		
		greatSorter.printData();
		greatSorter.insertionSort();
		greatSorter.printData();
		
		keyboard.close();
	}
	//====================================================================================================================
	public static void readFile(String tFileName, ArrayList<Integer> tData) // why does this need to be declared static?
	{
		Scanner fileReader;
		try
		{
			fileReader = new Scanner(new File("input.txt"));
	
			while(fileReader.hasNext())
			{
				tData.add(fileReader.nextInt());
			}
		}
		catch(Exception e){
			System.out.println("Error Reading File");
			return;
		}
		
		fileReader.close();
	}
	//====================================================================================================================
	public static void printData(ArrayList<Integer> tData)
	{
		System.out.println("Values: \n");
		
		for(Integer val : tData)
		{
			System.out.print(val+" ");
		}
		
		System.out.println();
	}
	//========================================================================================================================

}
//============================================================================================================================

