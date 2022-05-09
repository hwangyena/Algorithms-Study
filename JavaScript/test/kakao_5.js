const rc = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];

const operations = ["Rotate", "ShiftRow"];

const onShiftRow = (arr, len) => {
  let answer = arr.map((_, i) => (i < len - 1 ? arr[i + 1] : arr[0]));

  return answer;
};

const onRotate = (arr, row, col) => {
  let answer = [...arr];

  //첫번째 줄
  // answer[0] = arr[0].map((_, i) => arr[i] + 1);
  [...Array(col).keys()].map((v) => {
    console.log(`v: ${v}, col: ${col}`);
    v === 0 ? (answer[0][col - 1] = arr[0][col - 1]) : arr[v - 1][col - 1];
  });

  return answer;
};

let b = onRotate(rc, 3, 3);
// let a = onShiftRow(rc, rc.length);
console.log(b);
