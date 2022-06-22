/**
 * 이중배열 중복 제거 -->
function removeDup(arr) {
  return [...new Set(arr.join("|").split("|"))]
    .map((v) => v.split(","))
    .map((v) => v.map((a) => +a));
}


 */

const nums = [3, 3, 3, 8, 2, 4, 3, 6, 3, 7];
const pick = nums.length / 2;

const already_pick = [];
nums.map((v) => {
  if (pick <= already_pick.length) return;
  if (already_pick.includes(v)) return;

  already_pick.push(v);
});

console.log(already_pick);
