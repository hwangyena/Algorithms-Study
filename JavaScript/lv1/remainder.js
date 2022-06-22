const n = 10;

const find_remainder = (num) => {
  for (let i = 2; i < num; i++) {
    if (num % i === 1) return i;
  }
};

const result = find_remainder(n);
console.log("result", result);
