const a = [1, 2, 3, 4];
const b = [-3, -1, 0, 2];

const result = a.reduce((p, _, i) => p + a[i] * b[i], 0);
console.log("result", result);
