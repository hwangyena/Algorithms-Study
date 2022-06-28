/**
 * 예상 대진표
 * https://programmers.co.kr/learn/courses/30/lessons/12985?language=javascript
 *
 */

const n = 8;
const a = 4;
const b = 7;

const isOdd = (n) => n % 2 !== 0; //홀수

let next_a = a;
let next_b = b;
let round = 1;

while (true) {
  if (isOdd(next_a) && next_a + 1 === next_b) break;
  if (isOdd(next_b) && next_b + 1 === next_a) break;

  //이 다음 숫자
  next_a = isOdd(next_a) ? (next_a + 1) / 2 : next_a / 2;
  next_b = isOdd(next_b) ? (next_b + 1) / 2 : next_b / 2;
  round++;
}

console.log("round", round);
