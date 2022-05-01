const n = 6;
const vertex = [
  [3, 6],
  [4, 3],
  [3, 2],
  [1, 3],
  [1, 2],
  [2, 4],
  [5, 2],
];

//1. graph 만들기
const graph = {};
for (let i = 1; i <= n; i++) {
  graph[i] = [];
}
vertex.map(v => {
  const a = v[0];
  const b = v[1];
  graph[a] = [...graph[a], b];
  graph[b] = [...graph[b], a];
});

for (let v in graph) {
  graph[v].sort();
}

const bfs = start => {
  // let visited = [start]; //방문한 노드
  let visitedWithCount = [{ node: start, count: 1 }];
  let needVisit = [start];

  while (needVisit.length !== 0) {
    const node = needVisit.shift(); //탐색노드

    graph[node].forEach(e => {
      const parentNode = visitedWithCount.find(v => v.node === node); //부모 노드
      const isNode = visitedWithCount.find(v => v.node === e); //탐색 여부

      if (isNode === undefined) {
        needVisit.push(e);
        visitedWithCount.push({ node: e, count: parentNode.count + 1 });
      }
    });
  }

  return visitedWithCount;
};

const bfsResult = bfs(1);
const maxCount = bfsResult[bfsResult.length - 1].count;

let answer = 0;
bfsResult.map(v => (answer = v.count === maxCount ? answer + 1 : answer));
console.log('answer', answer);
