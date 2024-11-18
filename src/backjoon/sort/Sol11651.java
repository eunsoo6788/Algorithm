package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol11651 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken();    // 나이
            arr[i][1] = st.nextToken();    // 이름
        }


        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0].equals(e2[0])) {
                return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
            } else {
                return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
            }
        });
//
//        var result = Arrays.stream(arr)
//                .sorted((e1, e2) -> {
//                    if (e1[0].equals(e2[0])) {
//                        return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
//                    } else {
//                        return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
//                    }
//                });


    }


    /**
     * 두 코드 모두 배열을 정렬하지만, 성능과 정렬 알고리즘 측면에서 차이가 있습니다. 이를 자세히 비교해 보겠습니다.
     *
     * ### 1. 첫 번째 코드: `Arrays.sort(arr, (e1, e2) -> {...})`
     * ```java
     * Arrays.sort(arr, (e1, e2) -> {
     *     if (e1[0].equals(e2[0])) {
     *         return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
     *     } else {
     *         return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
     *     }
     * });
     * ```
     *
     * - 이 코드는 `Arrays.sort()`를 사용하여 배열을 정렬합니다.
     * - `Arrays.sort()`는 객체 배열에서 **TimSort** 알고리즘을 사용합니다. TimSort는 **합병 정렬(merge sort)**과 **삽입 정렬(insertion sort)**의 하이브리드 알고리즘입니다.
     * - **시간 복잡도:** O(n log n)
     * - TimSort는 일반적으로 데이터를 미리 정렬된 상태로 유지하려고 시도하는 데이터에서 매우 효율적입니다.
     * - **성능 최적화:** TimSort는 최악의 경우에도 O(n log n)의 성능을 보장하며, 데이터가 이미 어느 정도 정렬되어 있는 경우 추가적인 성능 이점을 제공할 수 있습니다.
     *
     * ### 2. 두 번째 코드: `Arrays.stream(arr).sorted((e1, e2) -> {...})`
     * ```java
     * var result = Arrays.stream(arr)
     *     .sorted((e1, e2) -> {
     *         if (e1[0].equals(e2[0])) {
     *             return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
     *         } else {
     *             return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
     *         }
     *     });
     * ```
     *
     * - 이 코드는 Java의 Stream API를 사용하여 배열을 스트림으로 변환하고, `sorted()`를 사용해 정렬합니다.
     * - `Stream.sorted()`는 내부적으로 **병합 정렬(merge sort)** 알고리즘을 사용합니다.
     * - Stream API의 `sorted()` 메서드 역시 **O(n log n)**의 시간 복잡도를 가집니다.
     * - **추가 메모리 사용:** Stream API는 배열을 스트림으로 변환하여 처리하기 때문에, 추가적인 메모리 및 연산 비용이 발생할 수 있습니다. 즉, Stream을 사용하는 과정에서 데이터가 중간 단계에서 복사되고, 이를 정렬하는 작업은 **추가 오버헤드**를 유발할 수 있습니다.
     *
     * ### 차이점 및 성능 비교:
     *
     * 1. **정렬 알고리즘**
     *    - 첫 번째 코드 (`Arrays.sort`)는 TimSort 알고리즘을 사용합니다.
     *    - 두 번째 코드 (`Stream.sorted`)는 병합 정렬을 사용합니다.
     *
     * 2. **성능**
     *    - **첫 번째 코드**는 추가 메모리 사용 없이 직접 배열을 정렬합니다. 따라서 성능 면에서 더 효율적일 수 있습니다.
     *    - **두 번째 코드**는 Stream API를 사용하여 배열을 스트림으로 변환한 후 정렬하는 과정에서 **추가 메모리**와 **중간 연산**이 필요하므로 성능이 더 느릴 수 있습니다. 특히, 대량의 데이터를 다룰 때 이러한 차이가 두드러집니다.
     *
     * 3. **사용 시나리오**
     *    - **첫 번째 코드**는 간단하게 배열을 직접 정렬할 때 더 적합합니다.
     *    - **두 번째 코드**는 스트림을 사용하여 추가적인 연산(필터링, 매핑 등)을 결합해야 할 때 유용할 수 있지만, 단순 정렬만을 목표로 한다면 비효율적일 수 있습니다.
     *
     * ### 결론:
     * - **첫 번째 코드(`Arrays.sort()`)가 더 성능적으로 우수합니다.** 추가적인 메모리나 오버헤드 없이 배열을 직접 정렬하며, 더 간단하고 효율적입니다.
     * - **두 번째 코드**는 Stream API의 유연성을 제공하지만, 순수 정렬 작업에서는 성능이 상대적으로 떨어질 수 있습니다.
     */
}
