const queue1 = [3, 2, 7, 2]; //14
const queue2 = [1, 4, 6, 5]; //16
// const queue1 = [1, 2, 1, 2];
// const queue2 = [1, 10, 1, 2];

//두 수의 합이 같게..
/**
 * 1. 2개의 큐에서 최댓값을 구한다.
 * 2. 그 최댓값을 만들 수 있는지...........?
 */

// 더 작은쪽으로 큐에서 꺼내 넣어준다
const minSum = (q1, q2) => {
  let queue1_re = q1;
  let queue2_re = q2;
  let count = 0;

  while (true) {
    const queue1_sum = queue1_re.reduce((p, c) => p + c);
    const queue2_sum = queue2_re.reduce((p, c) => p + c);

    if (queue1_sum === queue2_sum) break;

    if (queue1_sum > queue2_sum) {
      queue2_re = [...queue2_re, queue1_re.shift()];
    } else {
      queue1_re = [...queue1_re, queue2_re.shift()];
    }
    count++;

    console.log(`queue1: ${queue1_re}`);
    console.log(`queue2: ${queue2_re}`);
  }
  return count;
};

const addQueue = [...queue1, ...queue2].sort((a, b) => b - a);
const isAvaliable = addQueue.reduce((p, c) => {
  if (p > 0) p = p - c;
  else p = p + c;
  return p;
});

let min_count = minSum(queue1, queue2);
// let max_count = maxSum(queue1, queue2);
console.log("min_count", min_count);
// console.log("max_count", max_count);
