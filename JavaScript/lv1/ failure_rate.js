const N = 5;
const stages = [2, 1, 2, 6, 2, 4, 3, 3];

const success = {};
Array.from({ length: N }).map((_, i) => (success[i + 1] = 0));

stages.map((v) => {
  if (v > N) return;
  success[v] += 1;
});

let total = stages.length;
let failure_match = {}; //key랑 묶인 실패율
let failure = [];

let index = 1;
for (const key in success) {
  // console.log(`실패율: ${success[key]}/${total}`);

  const rate = success[key] / total;
  failure_match[rate] = failure_match[rate]
    ? [...failure_match[rate], index]
    : [index];

  failure = [...failure, rate];
  if (success[key] > 0) total -= success[key];
  index += 1;
}

failure = Array.from(new Set(failure)).sort((a, b) => b - a); //실패율 중복 제거
for (const key in failure_match) {
  failure_match[key] = failure_match[key].sort((a, b) => a - b); //실패율 - key 오름차순 정렬
}

const result = [];
failure.map((v) => result.push(...failure_match[v]));
console.log("result", result);

// 3,4,2,1,5
