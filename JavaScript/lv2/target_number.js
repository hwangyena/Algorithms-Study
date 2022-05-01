const numbers = [1, 1, 1, 1, 1];
const target = 3;

let answer = 0;
const dfs = (arr, sum, idx, target) => {
  if (idx === arr.length) {
    if (sum === target) {
      answer += 1;
    }
    return -1;
  }

  dfs(arr, sum + arr[idx], idx + 1, target);
  dfs(arr, sum - arr[idx], idx + 1, target);
  return 0;
};

dfs(numbers, 0, 0, target);
console.log('answer', answer);
