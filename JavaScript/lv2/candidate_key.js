let relation = [
  ["1", "100", "ryan", "music", "2"],
  ["2", "200", "apeach", "math", "2"],
  ["3", "300", "tube", "computer", "3"],
  ["5", "400", "con", "computer", "4"],
  ["5", "500", "muzi", "music", "3"],
  ["6", "600", "apeach", "music", "2"],
];

// 1. 유일성을 만족하는 속성(index) 찾기
const isUnique = (arr) => {
  const compare = Array.from(new Set(arr));

  return arr.length === compare.length;
};

let attribute = new Array(relation[0].length).fill([]); // 각 속성값들만 모아놓은 것
let uniqueAttribute = []; // 유일성 만족 index

for (let i = 0; i < relation.length; i++) {
  for (let j = 0; j < relation[0].length; j++) {
    attribute[j] = [...attribute[j], relation[i][j]];
  }
}

for (let i = 0; i < attribute.length; i++) {
  if (isUnique(attribute[i])) {
    uniqueAttribute.push(i);
  }
}

// 2. 유일성을 제외하고 조합으로 가능한 경우의 수 뽑기
const getCombinations = (arr, selectNumber) => {
  const result = [];
  if (selectNumber === 1) return arr.map((v) => [v]);

  arr.forEach((value, index, array) => {
    const rest = array.slice(index + 1); // fixed 제외한 나머지 뒤
    const combinations = getCombinations(rest, selectNumber - 1); // 나머지 조합
    const attached = combinations.map((v) => [value, ...v]); // fixed에 나머지 붙이기

    result.push(...attached);
  });
  return result;
};

const exceptUnique = Array.from(
  { length: attribute.length },
  (_, i) => i
).filter((v) => !uniqueAttribute.includes(v)); // unique를 제외한 attribute index
let comb = []; // unique를 제외한 attribute의 조합

for (let i = 2; i <= exceptUnique.length; i++) {
  comb.push(...getCombinations(exceptUnique, i));
}

// 3. 조합을 돌면서 유일성을 만족하는지 확인하기
// 3-1. 유일성을 만족하는 경우, uniqueAttribute에 넣고 이후 해당 값을 가지는 조합은 패스하기
// 3-2. 유일성 만족 여부는, 배열로 만들어 위에서 선언한 것 처럼 isUnique 사용하기!
const relationStr = relation.map((v) => v.join(""));
let checkStr = new Array(comb.length).fill([]); // 조합에 따른 문자열 -- 정확한 비교가 불가능!!

for (let i = 0; i < comb.length; i++) {
  for (let j = 0; j < relation.length; j++) {
    let makeStr = "";
    comb[i].forEach((v) => {
      makeStr += relation[j][v];
    });
    checkStr[i] = [...checkStr[i], makeStr];
  }
}

// 유일성 만족 여부 확인
let uniqueArr = [];

for (let i = 0; i < checkStr.length; i++) {
  if (isUnique(checkStr[i])) {
    // 최소성 만족
    if (uniqueArr.length > 0) {
      const isDuplicate = uniqueArr.some((v) =>
        v.every((v2) => comb[i].includes(v2))
      );
      if (isDuplicate) continue;
    }
    // 유일성 만족
    uniqueArr.push(comb[i]);
  }
}

console.log(uniqueArr);
uniqueAttribute.push(...uniqueArr);

const answer = uniqueAttribute.length;
