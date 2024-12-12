import java.util.ArrayList;
import java.util.Arrays;

public class C13_BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2 ,4 , 8 ,9 , 10, 10 , 10, 12};
        ArrayList<Integer> indexex = binarySearchWithReapeatedElements(nums, 2);
        System.out.println(indexex);
    }


    static int binarySearch(int[] arr, int target){
        // commienzo del arreglo
        int left = 0;

        // final del arreglo
        int right = arr.length - 1;

        while (left <= right){

            //forma de calcular el indice medio de un algoritmo de busqueda binaria y evitar deboramiento
            int mid = left + (right - left) / 2;

            //Verificamos si el punto medio es el target
            if(arr[mid] == target){
                return mid;
            }

            //Si el valor objetivo es menor que el de la mitad tomamos la mitad de la izquierda
            if(arr[mid] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        // Si no se encuentra el valor retornamos -1
        return -1;
    }

    static ArrayList<Integer> binarySearchWithReapeatedElements(int[] arr, int target){
        ArrayList<Integer> indices = new ArrayList<>();
        // commienzo del arreglo
        int left = 0;

        // final del arreglo
        int right = arr.length - 1;

        while (left <= right){

            //forma de calcular el indice medio de un algoritmo de busqueda binaria y evitar desbordamiento
            int mid = left + (right - left) / 2;

            //Verificamos si el punto medio es el target
            if(arr[mid] == target){
                indices.add(mid);
                int index1 = mid + 1;
                int index2 = mid -1;

                while (arr[index1] == target ){
                    indices.add(index1++);
                }

                while (arr[index2] == target ){
                    indices.add(index2--);
                }

                return indices;
            }

            //Si el valor objetivo es menor que el de la mitad tomamos la mitad de la izquierda
            if(arr[mid] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        // Si no se encuentra el valor retornamos -1
        return null;
    }
}
