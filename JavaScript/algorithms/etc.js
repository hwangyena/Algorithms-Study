/** 문자열 수식 계산 */
function evil(fn) {
  return new Function("return " + fn)();
}

/** 소수인가? */
const isPrime = (num) => {
  for (let i = 2, s = Math.sqrt(num); i <= s; i++)
    if (num % i === 0) return false;
  return num > 1;
};

/** 숫자만 꺼내기 */
const v = "12abcd".replace(/[^0-9]/g, "");

/** 배열 -> 문자열로 */
const str = arr.join("");

/** 조합 ->  - 넣기 */
const getCombination = (arr, start) => {
  for (let i = start; i < arr.length; i++) {
    let combi = JSON.parse(JSON.stringify(arr));
    combi[i] = "-";

    getCombination(combi, i + 1);

    console.log("combi", combi);
  }
};
// getCombination(["a", "b", "c"], 0);

/** 이차원 배열 중복제거 */
function removeDup(arr) {
  return [...new Set(arr.join("|").split("|"))]
    .map((v) => v.split(","))
    .map((v) => v.map((a) => +a));
}

console.log(
  JSON.stringify(
    removeDup([
      [1, 2],
      [1, 2],
    ])
  )
);
