const N = 5; //정점
const M = 5; //간선
const V = 3; //탐색 시작

const graph = {};

//정점 넣어주기
for (let i = 0; i < N; i++) {
  graph[i + 1] = [];
}

//그래프 넣기
const insert = (x, y) => {
  graph[x] = [...graph[x], y];
  graph[y] = [...graph[y], x];
};

//그래프 내부 정렬
const sortGraph = () => {
  for (const v in graph) {
    graph[v].sort();
  }
};

/** DFS */
const dfs = start => {
  let visited = []; //방문 여부
  let needVisit = [start];

  while (needVisit.length !== 0) {
    const node = needVisit.shift(); //탐색 노드
    if (!visited.includes(node)) {
      //노드 탐색 안했으면
      visited.push(node); //탐색했다고 표시
      needVisit = [...graph[node], ...needVisit]; //남은 탐색 + 이후 탐색할 노드
    }
  }
  return visited;
};

/** BFS */
const bfs = start => {
  let visited = [start]; //방문 여부
  let needVisit = [start];

  while (needVisit.length !== 0) {
    const node = needVisit.shift(); //탐색 노드
    console.log('node', node);

    graph[node].forEach(element => {
      if (!visited.includes(element)) {
        needVisit.push(element);
        visited.push(element);
      }
    });
  }

  return visited;
};

//////////////예시 코드//////////////
insert(5, 4);
insert(5, 2);
insert(1, 2);
insert(3, 4);
insert(3, 1);

sortGraph();

console.log('dfs', dfs(V));
console.log('bfs', bfs(V));
