import java.util.Random;

public class Ex {


    public static void main(String[] args){
        int [] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(50);

        }
        for (int x:arr
        ) {
            System.out.print(x+" ");
        }
        sort(arr);
        System.out.println();
        for (int x : arr
             ) {
            System.out.print(x + " ");
        }
    }

    public static void sort( int [] array){
        for(int i = array.length/2 - 1; i >= 0; i--){
            sito(array, array.length, i);
        }
        for (int i = array.length -1; i >= 0 ; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            sito (array, i, 0);
        }
    }
    public static void sito( int [] array, int size, int index){

        int max = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (size > left && array[max]< array[left] ){
            max = left;
        }
        if (size> right && array[max]< array[right] ){
            max = right;
        }
        if (max != index){
            int temp = array[index];
            array[index] = array[max];
            array[max] = temp;
            sito(array, size, max);
        }
    }




}