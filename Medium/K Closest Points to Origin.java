class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] arr = new int[k][2];
        sort(points,0,points.length - 1);
        for (int i = 0; i < arr.length; i++){
            arr[i] = points[i];
        }
        return arr;
    }

    public void sort(int[][] arr, int f, int l){
        if (l > f){
            int m = (f + l ) / 2;

            sort(arr,f,m);
            sort(arr,m+1,l);
            merge(arr,f,m,l);
        }
    }

    public void merge(int[][] arr, int f, int m, int l){
        int s1 = m - f + 1;
        int s2 = l - m;
        int[][] arr1 = new int[s1][2];
        int[][] arr2 = new int[s2][2];

        for (int i = 0; i < arr1.length; i++){
            arr1[i] = arr[f + i];
        }
        for (int i = 0; i < arr2.length; i++){
            arr2[i] = arr[m + 1 + i];
        }

        int k = f;
        int i = 0;
        int j = 0;
        while (i < s1 && j < s2){

            if (compareArr(arr1[i],arr2[j]) < 0){
                arr[k] = arr1[i++];
            }
            else {
                arr[k] = arr2[j++];

            }

            k++;
        }
        while (i < s1){
            arr[k++] = arr1[i++];
        }
        while (j < s2){
            arr[k++] = arr2[j++];
        }
    }

    public int compareArr(int[] arr1, int[] arr2){
        int val1 = (((arr1[0] - 0) * (arr1[0] - 0)) + ((arr1[1] - 0) * (arr1[1] - 0)));
        int val2 = (((arr2[0] - 0) * (arr2[0] - 0)) + ((arr2[1] - 0) * (arr2[1] - 0)));
        return val1 - val2;
    }
}