const array = [1, 30, 4, 21, 100000];

const commands = [
  [2, 5, 3],
  [4, 4, 1],
  [1, 7, 3],
];

const result = commands.map((v) => {
  const i = v[0];
  const j = v[1];
  const k = v[2];

  const slice_arr = array.slice(i - 1, j).sort((a, b) => a - b);
  return slice_arr[k - 1];
});

console.log(result);
