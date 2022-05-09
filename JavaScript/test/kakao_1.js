const survey = ["TR"]; // 비동의/동의
const choices = [1];

/**
 * R / T
 * C / F
 * J / M
 * A / N
 *
 */

//동일한 점수가 나오면 사전순으로 빠른 것
let score = {
  R: 0,
  T: 0,
  C: 0,
  F: 0,
  J: 0,
  M: 0,
  A: 0,
  N: 0,
};

//1점 -> -1+4 = 3점
//2점  -> -2+4 = 2점
//3점 -> -3+4 = 1점
//4점 리턴
//5점 -> 5 - 4 = 1점
choices.map((v, i) => {
  const negative = survey[i][0];
  const positive = survey[i][1];

  // if (v === 4) return;
  // const isAgree = v > 4 ? 1 : -1;// => 3
  if (v < 4) {
    score[negative] += v * -1 + 4;
  }
  if (v > 4) {
    score[positive] += v - 4;
  }
});

let answer = "";
answer = score["R"] >= score["T"] ? "R" : "T";
answer += score["C"] >= score["F"] ? "C" : "F";
answer += score["J"] >= score["M"] ? "J" : "M";
answer += score["A"] >= score["N"] ? "A" : "N";
console.log("answer", answer);
