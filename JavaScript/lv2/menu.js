const orders = ["XYZ", "XWY", "WXA"];
const course = [2, 3, 4];
// const result = ["AC", "ACDE", "BCFG", "CDE"];

const getCombinations = function (arr, selectNumber) {
  const results = [];
  if (selectNumber === 1) return arr.map((el) => [el]);
  // n개중에서 1개 선택할 때(nC1), 바로 모든 배열의 원소 return

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    // 해당하는 fixed를 제외한 나머지 뒤
    const combinations = getCombinations(rest, selectNumber - 1);
    // 나머지에 대해서 조합을 구한다.
    const attached = combinations.map((el) => [fixed, ...el]);
    //  돌아온 조합에 떼 놓은(fixed) 값 붙이기
    results.push(...attached);
    // 배열 spread syntax 로 모두다 push
  });

  return results; // 결과 담긴 results return
};

let maxMenu = [];
course.map((count) => {
  let combinations = {};

  orders.map((order) => {
    const comb = getCombinations(order.split("").sort(), count);
    comb.map((v) => {
      combinations[v] = combinations[v] ? combinations[v] + 1 : 1;
    });
  });
  // console.log("combinations", combinations);
  const maxOrdered = Math.max(...Object.values(combinations));
  for (const menu in combinations) {
    if (combinations[menu] === maxOrdered && maxOrdered > 1) {
      maxMenu = [...maxMenu, menu];
    }
  }

  combinations = {};
});

maxMenu = maxMenu.map((v) => v.replace(/,/gi, ""));

console.log("maxMenu", maxMenu.sort());
