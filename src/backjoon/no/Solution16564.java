package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution16564 {

    /**
     * 백준 : 서버실 17245
     * 알고리즘 : 구현
     * not sol
     * 골드 5
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());

        long[] arr = new long[num];

        long low = 0;
        long high = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
            high = Math.max(high, arr[i] + target);
        }

        long answer = 0;
        while (low <= high) {


            long mid = (high + low) / 2;

            long sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < mid) {
                    sum += mid - arr[i];
                }

            }

            if (sum <= target) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

//            if (sum >= target) {
//                high = mid - 1;
//                answer = mid;
//            } else {
//                low = mid + 1;
//            }

        }

        System.out.println(answer);


    }


    /**
     * 질문해주신 두 가지 이분 탐색 조건문의 차이는 비교 조건(`<=` vs `>=`)과 탐색 방향의 차이입니다. 두 가지 접근 방식이 다른 결과를 낳게 되는 이유를 구체적으로 설명해보겠습니다.
     *
     * ### 두 가지 이분 탐색 조건문의 논리적 차이
     *
     * 1. **코드 A (처음 제안한 코드)**
     *     ```java
     *     if (sum <= target) {
     *         answer = mid;
     *         low = mid + 1;
     *     } else {
     *         high = mid - 1;
     *     }
     *     ```
     *
     *     - 이 코드의 목적은 `sum`이 `target` 이하인 경우, 목표 레벨을 높일 수 있는지 확인하기 위해 `low`를 증가시키는 것입니다.
     *     - `sum <= target`일 때, 현재 높이 `mid`까지 레벨을 올릴 수 있으며, 이 값을 가능한 결과로 설정 (`answer = mid`) 합니다.
     *     - `low`를 증가시켜 더 높은 `mid` 값을 탐색함으로써 목표 레벨을 최대화하려고 합니다.
     *     - 반대로, `sum`이 `target`보다 큰 경우에는 목표 레벨이 너무 높아 필요한 레벨 증가량이 `target`을 초과했기 때문에 `high`를 줄여야 합니다.
     *
     * 2. **코드 B (질문에서 제안한 코드)**
     *     ```java
     *     if (sum >= target) {
     *         high = mid - 1;
     *         answer = mid;
     *     } else {
     *         low = mid + 1;
     *     }
     *     ```
     *     - 이 코드에서는 `sum >= target`인 경우, 현재 `mid` 값을 정답으로 저장하고 `high`를 줄여 더 작은 값을 탐색합니다.
     *     - `sum >= target`일 때 조건을 만족하는 경우, 가능한 목표 레벨을 설정 (`answer = mid`)하고 `high`를 줄여 더 낮은 목표를 찾으려고 합니다.
     *     - 반대로, `sum`이 `target`보다 작으면 레벨이 부족하므로 `low`를 증가시킵니다.
     *
     * ### 왜 코드 B는 올바르지 않은가?
     *
     * 코드 B에서 `sum >= target`일 때 `high`를 줄이는 방식으로 목표 레벨을 찾으려고 하는 것은 **목표 레벨의 최댓값을 찾는 문제**의 특성과 맞지 않기 때문입니다. 여기서 중요한 목표는 **가능한 최대의 목표 레벨을 찾는 것**인데, 코드 B는 조건을 만족할 때마다 `high`를 줄여가며 더 작은 목표를 찾으려고 합니다. 이렇게 하면 목표 레벨을 너무 일찍 줄여버려서 최대 값이 아닌 더 작은 값이 선택될 수 있습니다.
     *
     * - **최댓값 탐색의 방향성**:
     *   - 문제의 목표는 목표 레벨 `T`를 최대한 크게 하는 것입니다. 이 때 `sum`이 `target` 이하일 경우 목표 레벨을 더 높여야 하기 때문에 `low = mid + 1`로 `low`를 올려 더 큰 범위를 탐색해야 합니다.
     *   - 반대로, 코드 B는 `sum >= target`일 때 `high`를 줄이면서 가능한 목표 레벨을 줄이도록 작동합니다. 이 경우 결과적으로 더 큰 목표 레벨을 찾지 못하고 낮은 값에 머물러 버릴 수 있습니다.
     *
     * ### 이분 탐색의 기본 논리
     * 이분 탐색의 목적은 최적의 값을 찾기 위해 **두 가지 범위를 점점 좁혀가는 과정**을 반복하는 것입니다. 이 때 목표가 최대값인 경우와 최소값인 경우에 탐색 방향이 다릅니다.
     *
     * - **최대 값을 찾을 때 (`sum <= target`이 만족하는 범위를 찾기 위해 탐색할 때)**:
     *   - 가능한 범위를 더 높이기 위해 `low = mid + 1`로 진행하고, `answer`를 갱신합니다.
     * - **최소 값을 찾을 때 (`sum >= target`이 만족하는 최소 범위를 찾기 위해 탐색할 때)**:
     *   - 조건이 만족되는 경우 `high = mid - 1`로 더 낮은 범위를 탐색해 나가며 최소값을 찾습니다.
     *
     * 하지만 이 문제에서는 최대 목표 레벨을 찾는 것이 목적이기 때문에, 가능한 경우 더 높은 값을 탐색하도록 하는 것이 중요합니다. 코드 B는 조건을 만족할 때 더 낮은 값을 탐색하기 때문에 올바른 결과를 얻지 못하게 됩니다.
     *
     * ### 결론
     * - **코드 A**는 가능한 목표 레벨을 최대화하는 방향으로 이분 탐색을 진행하므로, 최적의 값을 찾을 수 있습니다.
     * - **코드 B**는 조건을 만족할 때마다 `high`를 줄이는 방식으로 목표 레벨을 줄여가므로, 최종적으로 최댓값을 찾지 못하고 더 낮은 값에 머무를 수 있습니다.
     *
     * 따라서, 목표 레벨을 최대화하기 위해서는 조건을 만족할 때 `low`를 증가시키고 가능한 값(`answer`)을 갱신하는 방식(코드 A)이 올바른 접근입니다.
     */

}
