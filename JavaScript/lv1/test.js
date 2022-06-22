const answers = [1, 3, 2, 4, 2, 3, 2];

const first = [1, 2, 3, 4, 5];
const second = [2, 1, 2, 3, 2, 4, 2, 5];
const third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

let score = [0, 0, 0];

answers.map((v, i) => {
  if (first[i % 5] === v) score[0] += 1;
  if (second[i % 8] === v) score[1] += 1;
  if (third[i % 10] === v) score[2] += 1;
});
const max = Math.max(...score);
console.log("max", max);

const result = [];

score.map((v, i) => {
  if (v === max) result.push(i + 1);
});

console.log("result", result);
