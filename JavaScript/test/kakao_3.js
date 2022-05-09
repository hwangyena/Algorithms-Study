const alp = 10;
const cop = 10;
const problems = [
  [10, 15, 2, 1, 2],
  [20, 20, 3, 3, 4],
];

/**
 * 모든 문제를 풀 필요가 없다 -> 모든 문제들보다 높은 코딩&알고력을 지니면 된다
 */

const max_alp = Math.max(...problems.map((v) => v[0]));
const max_cop = Math.max(...problems.map((v) => v[1]));

/**
 * 1) 문제풀이 = 부족한 알고력 + 문제 푸는 시간
 * 2) 알고력 1당 시간 1
 *
 * 문제를 풀었을 때가 안 풀었을때보다 더욱 좋은 방안이라고 생각한다.
 * 가장 효율이 좋은 문제가 무엇인지?
 *
 * 1. 둘 다 부족하다 -> 둘 다 높일 수 있는 방안을 찾아본다.
 * 2. 하나가 부족하다 -> 그 하나를 높일 수 있는 가장 효율적인 문제 & 방안을 찾아본다.
 *  2-1. 문제를 돌며, 현재 풀 수 있는 문제중 부족한 부분을 채울 수 있는 문제를 찾아본다.
 *  2-2.
 * 3. 문제의 효율계산 -> 어떤 문제를 풀기까지 필요한 효율을 계산한다.
 * 이때, 문제를 2의 경우를 예측하고 해당 문제를 풀때 높일 수 있는 최대 경우의 수를 생각한다.
 * 문제를 풀었을때
 */

/** compare to problem vs just 1 hour */
const compare_time = () => {};

let time = 0;
let my_alp = alp;
let my_cop = cop;

while (my_alp < max_alp && my_cop < max_cop) {}

problems.map((v) => {
  const cur_alp = v[0];
  const cur_cop = v[1];
  const alp_rwd = v[2]; //문제를 풀었을 때 증가하는 알고력
  const cop_rwd = v[3]; //문제를 풀었을 때 증가하는 코딩력
  const solving_time = v[4]; // 문제푸는 시간

  if (my_alp >= max_alp && my_cop >= max_cop) return;
  if (cur_alp <= my_alp && cur_cop <= my_cop) {
  } else {
    //문제를 풀 수 없음
    if (cur_alp > alp) {
      //알고력 필요
    }
    if (cur_cop > cop) {
      //코딩력 필요
    }
  }
});
