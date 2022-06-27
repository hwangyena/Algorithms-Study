const grid = ["S"];

let node = grid //젼체 node + 방문 여부
  .map((v) => v.split(""))
  .map((row) => row.map((_) => [false, false, false, false]));

const answer = [];
const dist = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
]; //TBLR

const checkCycle = (row, col, d) => {
  let count = 0;

  let x = row;
  let y = col;
  let dist_idx = d;

  while (true) {
    // console.log(`현재 방문 node.. ${x} ${y} ${node[x][y][dist_idx]}`);
    if (node[x][y][dist_idx]) break; //사이클 종료

    node[x][y][dist_idx] = true;
    count += 1;

    //현재 가르키는 다음 위치로 이동
    x += dist[dist_idx][0];
    y += dist[dist_idx][1];

    if (x < 0) x = grid.length - 1;
    if (x >= grid.length) x = 0;
    if (y < 0) y = grid[0].length - 1;
    if (y >= grid[0].length) y = 0;

    const next_node = grid[x][y]; //다음 향하는 노드

    //들어온 dist_idx에 따라 다음 화살표 방향 확인
    if (next_node === "L") {
      dist_idx = [2, 3, 1, 0][dist_idx];
    }
    if (next_node === "R") {
      dist_idx = [3, 2, 0, 1][dist_idx];
    }
  }

  return count;
};

for (let row = 0; row < grid.length; row++) {
  for (let col = 0; col < grid[0].length; col++) {
    for (let d = 0; d < dist.length; d++) {
      if (node[row][col][d]) continue;
      const count = checkCycle(row, col, d); //d: dist의 위치 index
      if (count > 0) answer.push(count);
    }
  }
}

console.log(
  "answer",
  answer.sort((a, b) => a - b)
); //오름차순!!!
