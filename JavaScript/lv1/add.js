const absolutes = [4, 7, 12];
const signs = [true, false, true];

const abs = (num, isPlus) => (isPlus ? num : num * -1);

const result = absolutes.reduce((p, c, index) => {
  return p + abs(c, signs[index]);
}, 0);

console.log("result", result);
