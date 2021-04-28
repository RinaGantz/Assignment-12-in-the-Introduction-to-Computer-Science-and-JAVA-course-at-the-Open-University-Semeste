
/**
 *This class represents 2 methods. the methd "win" is a coin game that ensures Amir's victory,
 *and method "find triplet" that return the maximum multification of three numbers in the array.
 *
 * @author Rina Gantz
 * @version 18/04/2020
 */
public class Ex12
{
    /**
     *This method calculates a strategy that ensures Amir's victory in the currency game (or equality). Tamar
     *in her turn takes the more worth currency. Amir takes the highest sum between the odd and the even cells
     *the time complexity is O(n). linear complexity. n is the length of the given array.
     *the place Complications is O(1) 
     * @param  arr array that represent the given coins in the game.
     */

    public static void win(int [] arr){
        int even=0,odd=0,low=0, high=arr.length-1, amir;
        for (int i=0; i<arr.length; i+=2){
            even+=(i%2==0)?arr[i]:arr[i+1]; // count the integers in the even cells
            odd+=(i%2==0)?arr[i+1]:arr[i]; // count the integers in the odd cells
        }
        amir=(even>odd)? 0: 1; //The expected mod of the highest amount between the even cells and  the odd cells (or equality)
        while (low<high) //all the coins have not yet been taken by Amir or Tamar
            System.out.println("Amir took "+((low%2==amir)? arr[low++]: arr[high--])+ //Amir takes the cell in the even/ odd index (the higher or equal) 
                "\nTamar took "+((arr[high]>arr[low])? arr[high--]:arr[low++])); //Tamar took the cell worth more (if there is one)
        System.out.println("Final Sorce: "+"\nAmir total "+((even>odd)? even: odd)+ // Amir's total is the highest amount (or equal). He won (or equality)
            "\nTamar total "+((even<odd)? even: odd)); // Tamar's total is the low amount. She lost. 
    }

    /**
     *The method finds three numbers that multiply maximally
     *the method prints these numbers and returns the maximum multiplication
     *the time complexity is O(n). linear complexity. n is the length of the given array. 
     *the place Complications is O(1)
     * @param  arr array that represent array of integers.
     * @return the maximum multiplication
     */
    public static int findTriplet(int [] arr)
    {
        int max1=0, max2, max3, min1=0, min2, multiMax, multiMin;
        for (int i=1; i<arr.length; i++)
            if (arr[i]>=arr[max1]) //find the maximum number in the array
                max1=i;
        max2=(max1!=0)? 0: 1;
        for (int i=1; i<arr.length; i++)
            if (arr[i]>=arr[max2]&&i!=max1) //find the maximum secondary number in the array
                max2=i;
        max3=(max1!=0&&max2!=0)? 0: (max1!=1&&max2!=1)? 1: 2;
        for (int i=1; i<arr.length; i++)
            if (arr[i]>=arr[max3]&&i!=max1&&i!=max2) //find the maximum third number in the array
                max3=i;
        for (int i=1; i<arr.length; i++)
            if (arr[i]<=arr[min1]) //find the minimum number in the array 
                min1=i;
        min2=(min1!=0)? 0: 1;
        for (int i=1; i<arr.length; i++)
            if (arr[i]<=arr[min2]&&i!=min1) //find the minimum secondary number in the array
                min2=i;
        multiMax=arr[max1]*arr[max2]*arr[max3]; //the 3 maximums multiplication
        multiMin=arr[max1]*arr[min1]*arr[min2];  // the two minimums multiplication with the maximum
        System.out.println((multiMax>multiMin)? arr[max1]+" "+arr[max2]+" "+arr[max3]: arr[max1]+" "+arr[min2]+" "+arr[min1]);//print the higher multi
        return (multiMax>multiMin)?multiMax:multiMin; //return the higher multiplication
    } //end of method find triplet
} //end of class Ex12
