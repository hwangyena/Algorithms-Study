const n = 7;
const paths = [
  [1, 2, 5],
  [1, 4, 1],
  [2, 3, 1],
  [2, 6, 7],
  [4, 5, 1],
  [5, 6, 1],
  [6, 7, 1],
];
const gates = [3, 7];
const summits = [1, 5];

let graph = {};

Array.from(Array(n).keys()).map((v) => (graph[v + 1] = []));
paths.map((v) => {
  const node = v[0];
  const node2 = v[1];

  graph[node] = [...graph[node], { [node2]: v[2] }];
  graph[node2] = [...graph[node2], { [node]: v[2] }];
});

console.log("graph", graph);

//최소값으로 가는게 문제가아니고,, 간선 끝까지 도달해야함 -> dfs
// 산봉오루 중 한 곳만 방문한다,
// 만약 intensity가 최소인 등산코스가 여러개이면 산봉우리 번호가 가장 낮은 등산코스를 선택한다

/** 출발에서 시작해서 모든 경우의수를 돌아보다가 산봉우리를 만나면 끝낸다. */
const visitToSummit = (start) => {
  let visited = [];
  let needVisit = [...graph[start]];
  let intensity = {}; //산봉우리까지의 모든 거리 저장
  let max_intensity = 0; //현재까지 가장 긴 거리

  while (needVisit.length !== 0) {
    const node = needVisit.pop(); //{node: weight}
    const current_Node = Number(Object.keys(node)[0]); //현재 노드(node)
    const current_Weight = Number(node[current_Node]); //현재 노드와의 거리(weight)

    console.log("=====================================");
    console.log(`NODE: ${node}  ------->  {${current_Node}:${current_Weight}}`);
    console.log("[visited]", visited);
    console.log("[needVisited]", needVisit);

    console.log(`max intensity:::: ${max_intensity}`);

    //출발지 & 처음 출발지와 다름
    if (gates.includes(current_Node) && start !== current_Node) {
      if (!visited.includes(node)) visited.push(node); //방문 안했을 경우, 구분을 위해 넣어주기
      continue;
    }
    //산봉우리
    if (summits.includes(current_Node)) {
      if (!visited.includes(node)) visited.push(node);
      //현재까지 가장 높은 intensity
      const current_max_intensity = Math.max(max_intensity, current_Weight);

      //기존 intensity가 있는가?
      if (intensity[current_Node]) {
        intensity[current_Node] = Math.min(
          intensity[current_Node],
          current_max_intensity
        );
      } else {
        intensity[current_Node] = current_max_intensity;
      }
      console.log("산봉우리 ------> ", intensity);
      continue;
    }

    if (!visited.includes(node)) {
      visited.push(node);
      max_intensity = Math.max(max_intensity, current_Weight); //가장 최대 weight
      needVisit = [...needVisit, ...graph[current_Node]];
    }
    // console.log("=====================================");
  }
  return intensity;
};

// start gates
let intensity = {};
gates.map((v) => {
  //그래프 간선 중, 가장 최소값으로 한다
  //겹치는 값이 있으면, 그 중 작은 값으로 합친다
  const res = visitToSummit(v);
  Object.keys(res).map((v2) => {
    console.log("v2", v2, res[v2]);
    // intensity[v2] = res[v2];
    intensity[v2] = intensity[v2] ? Math.min(intensity[v2], res[v2]) : res[v2];
  });
});

// console.log("intensityr", intensity);
// let merge_intensity = {};
// intensity.map((v) => {
//   const key = Object.keys(v)[0];
//   console.log("key", key);

//   merge_intensity[key] = merge_intensity[key]
//     ? Math.min(merge_intensity[key], v[key])
//     : v[key];
// });

// console.log("answer~~~~~", merge_intensity);

const minValue = Math.min(...Object.values(intensity));

const answer_number = Object.keys(intensity).filter(
  (v) => intensity[v] === minValue
)[0];
const answer_intensity = intensity[answer_number];

console.log("answer", [Number(answer_number), answer_intensity]);
