const lottos = [1, 2, 3, 4, 5, 6];
const win_nums = [20, 9, 8, 45, 44, 35];

const min_count = lottos.filter((v) => win_nums.includes(v)).length;
const unknown = lottos.filter((v) => v === 0).length;

const max_rank = min_count + unknown;
const min_rank = min_count;

console.log([
  max_rank <= 1 ? 6 : 7 - max_rank,
  min_rank <= 1 ? 6 : 7 - min_rank,
]);
