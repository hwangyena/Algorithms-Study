const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
const hand = "right";

let cur_left = 10;
let cur_right = 12;

const must_left = [1, 4, 7, 10];
const must_right = [3, 6, 9, 12];

const changeToLR = (hand) => (hand === "left" ? "L" : "R");
const changeToNum = (v) => (v === "*" ? 10 : v === 0 ? 11 : v === "#" ? 12 : v);
const checkHandIsLeft = (hand) => (hand === "L" ? true : false);

const checkDistance = (cur, target, isLeft) => {
  let cur_hand = cur;
  let dist = 0;

  if (isLeft && [1, 4, 7, 10].includes(cur)) {
    dist += 1;
    cur_hand = cur + 1;
  }
  if (!isLeft && [3, 6, 9, 12].includes(cur)) {
    dist += 1;
    cur_hand = cur - 1;
  }
  console.log(`target: ${target} / cur_hand: ${cur_hand}`);

  while (target !== cur_hand) {
    dist += 1;
    if (target < cur_hand) {
      cur_hand -= 3;
    } else {
      cur_hand += 3;
    }
  }

  return dist;
};

const result = numbers.map((v) => {
  const cur = changeToNum(v);

  console.log(
    `[${cur}] =========== cur_left: ${cur_left} / cur_right : ${cur_right} ====================`
  );

  if (must_left.includes(cur)) {
    cur_left = cur;
    return "L";
  }
  if (must_right.includes(cur)) {
    cur_right = cur;
    return "R";
  }

  const left_dist = checkDistance(cur_left, cur, true);
  const right_dist = checkDistance(cur_right, cur, false);
  console.log(`---> left_dist: ${left_dist} / right_dist: ${right_dist}`);

  if (left_dist === right_dist) {
    checkHandIsLeft(changeToLR(hand)) ? (cur_left = cur) : (cur_right = cur);
    return changeToLR(hand);
  } else {
    const answer = left_dist < right_dist ? "L" : "R";
    console.log("answer >>>", answer);
    checkHandIsLeft(answer) ? (cur_left = cur) : (cur_right = cur);

    return answer;
  }
});

console.log("result", result.toString().replace(/,/g, ""));
