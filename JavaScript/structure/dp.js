//하향식(top-down)
const fiboArr = [];

const fiboTopDown = n => {
  if (n < 2) return n;
  if (fiboArr[n] === 0) fiboArr[n] = fiboTopDown(n - 1) + fiboTopDown(n - 2);
  return fiboArr[n];
};

//상향식(bottom-up)
const fiboBottomUp = n => {
  fiboArr[0] = 0;
  fiboArr[1] = 1;

  for (let i = 2; i <= n; i++) fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
  return fiboArr[n];
};

const n = 5;
for (let i = 0; i <= n; i++) {
  fiboArr[i] = 0;
}

fiboBottomUp(n);
console.log('fiboArr', fiboArr);
