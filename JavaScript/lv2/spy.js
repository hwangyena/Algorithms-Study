const clothes = [
  ['yellowhat', 'headgear'],
  ['bluesunglasses', 'eyewear'],
  ['green_turban', 'headgear'],
];

const clothesSort = {};
clothes.map(v => {
  const name = v[0];
  const kinds = v[1];

  if (clothesSort[kinds]) {
    clothesSort[kinds] = [...clothesSort[kinds], name];
  } else {
    clothesSort[kinds] = [name];
  }
});

const getCombinations = selectNumber => {};

console.log('clothesSort', clothesSort);

const count = Object.keys(clothesSort).length;
let answer = count; //1개씩 뽑았을 때
