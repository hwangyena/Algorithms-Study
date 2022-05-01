// const orders = ['AC', 'CDE', 'ACDE', 'ACDEH'];
const orders = ['FGCBA', 'AC', 'CDE', 'ACDE', 'BCFG', 'ACDEH'];
const course = [2, 3, 4];

const orders_sort = orders.map(v => v.split('').sort().join(''));

//조합
const getCombinations = (arr, selectNumber) => {
  const results = [];
  if (selectNumber === 1) return arr.map(el => [el]);

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, selectNumber - 1);
    const attached = combinations.map(el => [fixed, ...el]);
    results.push(...attached);
  });

  return results; // 결과 담긴 results return
};

//가능한 경우의 수 구하기
const comb = new Set();

const choice = course.map(v => {
  orders_sort.forEach(v2 => {
    if (v2.length < v) return;
    const res = getCombinations(v2.split(''), v).map(v3 => v3.join(''));
    res.forEach(v3 => comb.add(v3));
  });
});

const check = {}; //2번 이상 나오는지 확인

//2개 이상인 조합 빼내기
comb.forEach(v => {
  orders_sort.map(v2 => {
    const reg = new RegExp(
      '[A-Z]*' +
        v
          .split('')
          .map(v => v + '[A-Z]*')
          .join('')
    );
    // v2.match(reg) && check.find(v3 => v2 === v3) ? answer.add(v2) : check.push(v2);
    if (v2.match(reg)) {
      if (check[`${v}`]) {
        check[`${v}`] += 1;
      } else {
        check[`${v}`] = 1;
      }
    }
  });
});

const answer = Object.keys(check).filter(v => check[v] >= 2);

//check에서 answer 빼내기 -> 가장 많이 순서대로 배열에 담기. 이때 안에 있는 배열과 겹치는 문자이면 걍 패스
