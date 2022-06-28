/** 조합 */
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

/** 순열 */
const getPermutations = function (arr, selectNumber) {
  const results = [];
  if (selectNumber === 1) return arr.map((el) => [el]);

  arr.forEach((fixed, index, origin) => {
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)]; // 해당하는 fixed를 제외한 나머지 배열

    const permutations = getPermutations(rest, selectNumber - 1);
    const attached = permutations.map((el) => [fixed, ...el]); //  돌아온 순열에 떼 놓은(fixed) 값 붙이기

    results.push(...attached);
    // 배열 spread syntax 로 모두다 push
  });

  return results; // 결과 담긴 results return
};
