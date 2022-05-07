function dfs_recur(graph, start, visited) {
  visited[start] = true;

  for (let i = 0; i < graph.length; i++) {
    if (!visited[i]) dfs_recur(graph, i, visited);
  }
}

function dfs_stack(graph, start) {
  let visited = []; //방문 노드
  let stack = [];
  stack.push(start); //시작 노드 넣기

  while (stack.length !== 0) {
    let node = stack.pop();

    if (!visited[node]) {
      //노드 방문
      visited[node] = true;

      stack.push(graph[node]);
    }
  }
}
const graph = {
  A: ["B", "C"],
  B: ["A", "D"],
  C: ["A", "G", "H", "I"],
  D: ["B", "E", "F"],
  E: ["D"],
  F: ["D"],
  G: ["C"],
  H: ["C"],
  I: ["C", "J"],
  J: ["I"],
};

function bfs(graph, startNode) {
  let visited = []; // 탐색 마친 노드
  let needVisit = []; // 탐색 해야하는 노드

  needVisit.push(startNode);

  while (needVisit.length !== 0) {
    const node = needVisit.shift();
    if (!visited.includes(node)) {
      visited.push(node);
      needVisit = [...needVisit, ...graph[node]];
    }
  }
  return visited;
}

function dfs(graph, startNode) {
  let visited = []; // 탐색 마친 노드
  let needVisit = []; // 탐색 해야하는 노드

  needVisit.push(startNode);

  while (needVisit.length !== 0) {
    const node = needVisit.pop();
    if (!visited.includes(node)) {
      visited.push(node);
      needVisit = [...needVisit, ...graph[node]];
    }
  }
  return visited;
}

console.log("bfs", bfs(graph, "A"));
console.log("dfs", dfs(graph, "A"));
