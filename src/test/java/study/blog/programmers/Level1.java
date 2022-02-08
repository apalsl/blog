package study.blog.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class Level1 {

    @Test
    void K번째수() {

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        int[] solution = solution(array, commands);

        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int count = 0;

        for (int[] comm : commands) {

            int[] arr = Arrays.copyOfRange(array, comm[0]-1, comm[1]);

            Arrays.sort(arr);

            System.out.println("sa");

            answer[count++] = arr[comm[2]-1];


        }

        return answer;
    }

    @Test
    void 정렬3() {

        int[] arr = {0,1,2,3,5,6,7};
        int index = 0;
        if (arr.length % 2 == 0) {
            index = arr.length/2-1;
        } else {
            index = arr.length/2;
        }

        Arrays.sort(arr);



        for (int i=index; i >= 0; i--) {

            System.out.println("arr i : " + arr[i] + "   index " + i);

           if (arr[i] >= i+1) {
               System.out.println(arr[i]);
               return;
           }
        }
    }

}
