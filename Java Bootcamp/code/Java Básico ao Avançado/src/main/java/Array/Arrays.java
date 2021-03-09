package Array;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        System.out.println(arr.length);

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        int[][] mtx = {{1,2,3,4}, {5,6,7}};
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[i].length; j++) {
                System.out.printf("%d ", mtx[i][j]);
            }
            System.out.println();
        }
    }
}
