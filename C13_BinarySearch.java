import java.util.ArrayList;

public class C13_BinarySearch {


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

            //Si el valor objetivo es mayor que el de la mitad tomamos la mitad de la derecha
            if(arr[mid] > target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        // Si no se encuentra el valor retornamos -1
        return -1;
    }

    static int[] binarySearchWithReapeatedElements(int[] arr, int target){
        ArrayList<Integer> indices = new ArrayList<>();
        // commienzo del arreglo
        int left = 0;

        // final del arreglo
        int right = arr.length - 1;

        while (left <= right){

            //forma de calcular el indice medio de un algoritmo de busqueda binaria y evitar deboramiento
            int mid = left + (right - left) / 2;

            //Verificamos si el punto medio es el target
            if(arr[mid] == target){
                indices.add(mid);
                int index1 = mid + 1;
                int index2 = mid -1;

                while (arr[index1] == target ){
                    indices.add(index1);
                    index1++;
                }

                while (arr[index2] == target ){
                    indices.add(index2);
                    index2--;
                }
            }

            //Si el valor objetivo es mayor que el de la mitad tomamos la mitad de la derecha
            if(arr[mid] > target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        // Si no se encuentra el valor retornamos -1
        return null;
    }
}
