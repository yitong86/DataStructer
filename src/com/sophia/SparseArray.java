package com.sophia;

public class SparseArray {
    public static void main(String[] args) {
        // output Two dimensional array
        int array[][] = new int [11][11];// 2D integer array with 11 rows and 11 columns
        array[1][2] = 1;
        array[2][3] = 2;
        for(int[] row:array){
            for(int data:row){
                //\t next line
                //%d  interger
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        ////Two dimensional array to sparse array
        //iterate Two dimensional to get numbers except 0

        int sum = 0;
        for (int i = 0;i < array.length;i++){
            for(int j = 0 ;j < array.length;j++){
                if(array[i][j] != 0){
                    sum++;
                }
            }

        }

        System.out.println();



        //create sparse array
        //row clum val
        //11   11    2
        //1    2    1
        //2    3    2
        int sparArray[][] = new int[sum+1][3];
        sparArray[0][0] = 11;
        sparArray[0][1] = 11;
        sparArray[0][2] = sum;

        int count = 0;
        for (int i = 0;i < array.length;i++){
            for(int j = 0 ;j < array.length;j++){
                if(array[i][j] != 0){
                    //array[1][2] = 1 !=0
                    count++;//1
                    sparArray[count][0] = i;//0 ->clum
                    sparArray[count][1] = j;
                    sparArray[count][2] = array[i][j];
                }
            }

        }
        for(int i = 0; i< sparArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparArray[i][0],sparArray[i][1],sparArray[i][2]);
        }
        System.out.println();


        //Sparse array to two-dimensional array
        int array2[][] = new int[sparArray[0][0]][sparArray[0][1]];

        for(int i = 1;i < sparArray.length;i++){
            array2[sparArray[i][0]][sparArray[i][1]] = sparArray[i][2];

        }

        //output 2d array
        for(int[] row:array2){
            for(int data:row){
                //\t next line
                //%d  interger
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
//Because the array is initialized with all zeroes, we can save a lot of memory by only storing the numbers that have been set,
// similar to how you might store a sparse matrix or sparse file.
// If a value trying to be retrieved is not in our dictionary, then we can treat it as 0.