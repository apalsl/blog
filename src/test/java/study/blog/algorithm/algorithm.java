package study.blog.algorithm;


import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class algorithm {

    @Test
    void 그리디_거스름톤() {
        // 가장 적게 거스름돈을 주는 방법
        int n = 1260;
        int count = 0;

        int[] coin_types = {500,100,50,10};

        for (int coin_type : coin_types) {
            int value = n / coin_type;
            count += value;
            n = n % coin_type;
        }
        System.out.println(count);
    }

    @Test
    void 그리디_큰수구하기() {
        // 같은 숫자를 연달아 k번 반복가능, m만큼 나열했을때 가장 큰수
        int m = 8;
        int k =3;

        /**
         * 만약 값을 입력받는다면 List로 받아서 Collections 정렬을 하자.
         * 배열로 받아서 Arrays.sort는 reverseOrder가 까다로움.
         */

        List<Integer> list = Lists.newArrayList(2, 6, 4, 5, 4);
        list.sort(Collections.reverseOrder());
        System.out.println(list);


        /**
         * 1번 내 풀이
         * 큰 수를 정렬 후 (8/3)*3*첫번째 큰 수 + (8%2)*두번째 큰수 = 제일 큰 수 조합
         */
        System.out.println(list.get(1) * (m % k) + list.get(0) * (m / k)  * k);

        /**
         *  2번 풀이
         *  (m / (k + 1)) * (첫째 수 * k + 두번째 큰수) + (m % (k + 1) * 첫째 수)
         */
        int front = (list.get(0) * k) + list.get(1);
        int count = m / (k + 1);

        int back = (m % (k + 1)) * list.get(0);

        System.out.println(front * count + back);
    }

    @Test
    void 그리디_숫자_카드_게임() {
        // 배열의 한 행을 고르는데, 배열의 행에서 가장 작은값이 선택될 경우 가장 큰 값을 고르는 방법
        int n = 3;
        int m = 3;

        int[][] arr = {
                        {3,1,2},
                        {4,5,4},
                        {2,2,2}
        };

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int min = 100000;
            for (int j = 0; j < m; j++) {
                int value = arr[i][j];
                if (value < min) {
                    min = value;
                }
            }

            list.add(min);
        }

        /**
         * 정렬해서 구하지말고 min, max를 사용하자
         */

        Integer max = Collections.max(list);
        System.out.println(max);

        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }

    @Test
    void 결과가_1이_될_때까지() {
        // N을 K로 나누거나 -1을 해서 N을 1로 만든다. 다만 N을 K로 나눌때 꼭 맞아떨어져야 한다.
        int n = 25;
        int k = 5;
        int count = 0;

        while (n != 1) {
            count++;
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
        }

        System.out.println(count);
    }
}
