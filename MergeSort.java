
/**
 *
 * @author Sam McAnelly
 */

public class MergeSort {
    
    private static double[] temp;
    private static double[] listToSort;
    private static long startTime;
    private static long endTime;

    public static void main(String[] args){
        
    }
    
    public static double[] sort(double[] arr) throws Exception{
        startTime = System.currentTimeMillis();
        temp = new double[arr.length];
        listToSort = arr;
        sort(arr, 0, arr.length - 1);
        return listToSort;
    }
    
    private static void sort(double[] arr, int low, int high) throws Exception{
        endTime = System.currentTimeMillis();
        if ((endTime - startTime) >= 20000){
            throw new Exception("Merge Sort: Time has exceeded 20 seconds");
        }
        if ( high <= low ) return;
        int middle = low + (high - low)/2;
        sort(arr, low, middle);
        sort(arr, middle+1, high);
        merge(arr, low, middle, high);
    }
    
    private static void merge(double[] arr, int low, int middle, int high){
        int i = low;
        int j = middle + 1;
        
        for (int k = low; k <= high; k++) {
            temp[k] = arr[k];
        }
        
        for (int k = low; k <= high; k++){
            if ( i > middle)
                arr[k] = temp[j++];
            else if (j > high)
                arr[k] = temp[i++];
            else if (temp[j] < temp[i])
                arr[k] = temp[j++];
            else
                arr[k] = temp[i++];
        }
    }

}