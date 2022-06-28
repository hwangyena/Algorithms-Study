/**
 * 최단거리 - BFS 문제
 * : 지나온 거리를 0으로 표시
 * : 1일 경우에만 갈 수 있다
 */
const maps = [
  [1, 0, 1, 1, 1],
  [1, 0, 1, 0, 1],
  [1, 0, 1, 1, 1],
  [1, 1, 1, 0, 0],
  [0, 0, 0, 0, 1],
];

const dist = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
]; //LRBT

const row = maps.length;
const col = maps[0].length;

const bfs = (map) => {
  let queue = []; //방문해야하는 위치

  queue.push([0, 0, 1]); //[x,y,distance]
  map[0][0] = 0;

  while (queue.length !== 0) {
    let [x, y, distance] = queue.shift();

    if (x === row - 1 && y === col - 1) {
      return distance;
    }

    for (const d of dist) {
      const new_x = x + d[0];
      const new_y = y + d[1];

      console.log(`d:${d} // 갈수있는 가 -----> [${new_x}, ${new_y}]`);
      if (new_x < 0 || new_x >= row || new_y < 0 || new_y >= col) continue;

      // 방문 가능
      if (map[new_x][new_y] === 1) {
        map[new_x][new_y] = 0;
        queue.push([new_x, new_y, distance + 1]);
      }
    }
  }
  return -1;
};

console.log(bfs(maps));
