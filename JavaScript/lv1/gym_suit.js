const n = 5;
const lost = [5, 1, 2];
const reserve = [1, 5];

let final_lost = lost.sort();
let can_borrow = reserve.sort().filter((v) => {
  if (final_lost.includes(v)) {
    // console.log(v);
    final_lost = final_lost.filter((v2) => v !== v2);
    return false;
  }
  // console.log("++", v);
  return true;
});

console.log("final_lost", final_lost);
console.log("can_borrow", can_borrow);
let result = n;

final_lost.map((v) => {
  //앞 친구한테 빌릴 수 있으면
  if (can_borrow.includes(v - 1)) {
    can_borrow = can_borrow.filter((v2) => v2 !== v - 1);
    return;
  }
  //뒤 친구한테 빌릴 수 있으면
  if (can_borrow.includes(v + 1)) {
    can_borrow = can_borrow.filter((v2) => v2 !== v + 1);
    return;
  }

  result -= 1;
});

console.log(result);
