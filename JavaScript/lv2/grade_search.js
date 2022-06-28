/**
 * 순위 검색 - 조합 / 이분탐색
 *
 */

let info = [
  "java backend junior pizza 150",
  "python frontend senior chicken 210",
  "python frontend senior chicken 150",
  "cpp backend senior pizza 260",
  "java backend junior chicken 80",
  "python backend senior chicken 50",
];

let query = [
  "java and backend and junior and pizza 100",
  "python and frontend and senior and chicken 200",
  "cpp and - and senior and pizza 250",
  "- and backend and senior and - 150",
  "- and - and - and chicken 100",
  "- and - and - and - 150",
];

let info_comb = {};
let answer = [];

const getCombination = (arr, start, score) => {
  const key = arr.join("");
  const value = score;

  if (info_comb[key]) {
    info_comb[key] = [...info_comb[key], value];
  } else {
    info_comb[key] = [value];
  }

  for (let i = start; i < arr.length; i++) {
    let combi = JSON.parse(JSON.stringify(arr));
    combi[i] = "-";

    getCombination(combi, i + 1, score);
  }
};

const binarySearch = (key, score) => {
  const arr = info_comb[key];

  if (arr) {
    let left = 0;
    let right = arr.length;

    while (left < right) {
      let mid = Math.floor((left + right) / 2); //가운데 값

      if (arr[mid] < score) left = mid + 1;
      else right = mid;

      mid = Math.floor((left + right) / 2);
    }
    return arr.length - left;
  } else return 0;
};

//1. 조합으로 들어올 수 있는 경우의 수 정리
info.forEach((v) => {
  const info = v.split(" ");
  const score = info.pop();

  getCombination(info, 0, score);
});

// 2. 전체 key돌면서 sort
for (const key in info_comb) {
  info_comb[key].sort((a, b) => a - b);
}

// 3. query를 톨며 이분탐색
for (let i = 0; i < query.length; i++) {
  let query_arr = query[i].replace(/ and /g, "").split(" ");

  let query_score = Number(query_arr.pop());
  let query_key = query_arr[0];

  answer.push(binarySearch(query_key, query_score));
}

console.log(answer);

/// 안돼서 결국 아래 버전으로 해결함 ^^;;;;;;
function solution(info, query) {
  var answer = [];
  let map = {};

  function combination(infos, score, map, start) {
    let key = infos.join(""); //키 값으로 쓸거 합쳐주기
    let value = map[key]; //값 있는지 없는지 확인해주기

    if (value) {
      //값이 있으면 push
      map[key].push(score);
    } else {
      //값이 없으면 프로퍼티 만들어줘야 됨
      map[key] = [score];
    }
    //여기서는 - 를 이용해 조합 만들어주기
    for (let i = start; i < infos.length; i++) {
      let combiArr = [...infos]; //전개 연산자
      combiArr[i] = "-";
      combination(combiArr, score, map, i + 1);
    }
  }

  function binarySearch(map, key, score) {
    let scoreArr = map[key];

    if (scoreArr) {
      let start = 0;
      let end = scoreArr.length;
      while (start < end) {
        let mid = Math.floor((start + end) / 2);

        if (scoreArr[mid] >= score) {
          //현재 가르키는 값보다 내가 찾는 값이
          end = mid;
        } else if (scoreArr[mid] < score) {
          start = mid + 1;
        }
      }
      return scoreArr.length - start;
    } else return 0;
  }

  for (let i = 0; i < info.length; i++) {
    let infos = info[i].split(" ");
    let score = infos.pop();
    combination(infos, score, map, 0);
  }

  for (let key in map) {
    map[key].sort((o1, o2) => o1 - o2);
  }

  for (let i = 0; i < query.length; i++) {
    let querys = query[i].replace(/ and /g, "").split(" ");
    let score = Number(querys.pop());
    answer.push(binarySearch(map, querys.join(""), score));
  }

  return answer;
}
