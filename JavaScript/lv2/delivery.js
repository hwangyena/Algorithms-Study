/**
 * 배달 - 다익스트라
 *
 * [[최단거리 알고리즘]]
 *
 * 1. 모든 꼭지점 미방문 상태로 만들기
 * 2. 시작 정점 정하기
 * 3. 시작 정점을 방문 상태로 처리하기
 * 4. 시작 정점에서 인접한 정점으로 가능 모든 거리 값을 기록하기
 * 5. 그 중에서 최단 거리를 갖는 정점 찾기
 * 6. 최단 거리 경로를 통해 다음 정점으로 이동 & 이동 거리 기록
 * 7. 그 다음 정점에서 갈 수 있는 경로 + 현재 이동거리 와, 최단 거리 값을 비교하고 최소값을 기록
 * 8. 이동한 정점을 방문상태로 처리
 */

const N = 6;
const road = [
  [1, 2, 1],
  [1, 3, 2],
  [2, 3, 2],
  [3, 4, 3],
  [3, 5, 2],
  [3, 5, 3],
  [5, 6, 1],
];
const K = 4;

// 1. graph 구하기
let graph = new Array(N)
  .fill(new Array(N).fill(-1))
  .map((v, i) => v.map((_, i2) => (i === i2 ? 0 : 100000)));

road.forEach(([a, b, dist]) => {
  graph[a - 1][b - 1] = Math.min(graph[a - 1][b - 1], dist);
  graph[b - 1][a - 1] = Math.min(graph[b - 1][a - 1], dist);
});

console.log(JSON.stringify(graph));

//2. 다익스트라 알고리즘
const dijkstra = (n, graph) => {
  let currentNode = 0; //현재 방문 노드
  let minDistance = new Array(n).fill(100000); // 최소 거리 기록
  let visited = new Array(n).fill(false); // 방문한 노드

  //시작 - 1번 노드
  minDistance[0] = 0;

  while (!visited.every((v) => v)) {
    console.log("currentNode", currentNode);

    graph[currentNode].forEach((dist, node) => {
      if (dist) {
        minDistance[node] = Math.min(
          minDistance[node],
          minDistance[currentNode] + dist
        );
      }
    });
    visited[currentNode] = true;
    console.log(`----> minDistance: ${minDistance} / vistied:${visited}`);
    //다음 방문 노드 -> 방문하지 않은 최단거리
    const notVisited = minDistance.filter((_, i) => !visited[i]);
    const nextMinDist = Math.min(...notVisited);

    currentNode = minDistance.findIndex(
      (v, i) => v === nextMinDist && !visited[i]
    );
  }

  return minDistance;
};

const minDist = dijkstra(N, graph);
const answer = minDist.filter((v) => v <= K).length;

console.log(answer);
