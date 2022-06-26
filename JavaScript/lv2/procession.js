const rows = 3;
const columns = 5;
const queries = [
  [1, 1, 2, 2],
  [2, 3, 3, 4],
  [1, 2, 3, 4],
  [1, 1, 3, 4],
  [2, 2, 3, 5],
];

////

let i = 1;
let procession = []; //행렬

const answer = []; //정답

for (let i = 0, count = 1; i < rows; i++) {
  const arr = [];
  for (let j = 0; j < columns; j++, count += 1) {
    arr.push(count);
  }
  procession = [...procession, arr];
}

console.log(JSON.stringify(procession));

const rotate_procession = (x1, y1, x2, y2) => {
  let min_value = rows * columns;

  let copy_procession = JSON.parse(JSON.stringify(procession)); //기존 행렬 복사본
  let result = JSON.parse(JSON.stringify(procession)); //회전한 행렬

  //위
  for (let i = y1; i < y2; i++) {
    result[x1 - 1][i] = copy_procession[x1 - 1][i - 1];
    min_value = Math.min(result[x1 - 1][i], min_value);
  }
  //아래
  for (let i = y1 - 1; i < y2 - 1; i++) {
    result[x2 - 1][i] = copy_procession[x2 - 1][i + 1];
    min_value = Math.min(result[x2 - 1][i], min_value);
  }
  //왼
  for (let i = x1 - 1; i < x2 - 1; i++) {
    result[i][y1 - 1] = copy_procession[i + 1][y1 - 1];
    min_value = Math.min(result[i][y1 - 1], min_value);
  }
  //오
  for (let i = x1; i < x2; i++) {
    result[i][y2 - 1] = copy_procession[i - 1][y2 - 1];
    min_value = Math.min(result[i][y2 - 1], min_value);
  }

  procession = result;
  answer.push(min_value);
};

queries.map((v) => rotate_procession(...v));
console.log("answer", answer);
