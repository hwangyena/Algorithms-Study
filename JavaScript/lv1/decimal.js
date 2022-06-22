const nums = [1, 2, 7, 6, 4];

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

const isPrime = (value) => {
  for (let i = 2; i * i <= value; i += 1) {
    if (value % i === 0) return false;
  }

  return true;
};

const result = getCombinations(nums, 3)
  .map((v) => v.reduce((p, c) => p + c))
  .map((v) => isPrime(v))
  .filter((v) => v).length;

console.log(result);
