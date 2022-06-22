const d = [1, 3, 2, 5, 4];
const budget = 9;

let left_budget = budget;
let max = 0;
d.sort((a, b) => a - b).map((v) => {
  if (left_budget >= v) {
    left_budget -= v;
    max += 1;
  }
});

console.log("max", max);
