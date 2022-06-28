// const numbers = [3, 30, 34, 5, 9]; // 32가 들어오면 3 -> 32 순으로 들어가야함
// const numbers = [9, 99, 331, 362, 3004, 331, 6, 3]; //98331,19,1
const numbers = [0, 0];
const solution = (numbers) => {
  let answer = "";

  const arr = numbers.map((v) => String(v)).sort((a, b) => b + a - (a + b));
  const isZero = arr.every((v) => v === "0");

  arr.map((v) => (answer += v));

  if (isZero) return "0";
  return answer;
};

console.log(solution(numbers));
