const str1 = 'aa';
const str2 = 'aa';

const s1 = str1.toLowerCase();
const s2 = str2.toLowerCase();
// const s1 = str1.replace(/[^a-zA-Z]/g, '').toLowerCase();
// const s2 = str2.replace(/[^a-zA-Z]/g, '').toLowerCase();

const changeJacard = w => {
  const arr = w.split('');

  const res = arr.map((v, i) => {
    if (i >= arr.length - 1) return '-1';

    const newWord = String(v + arr[i + 1]);
    return newWord.match(/[^a-zA-z]/g) ? '-1' : newWord;
    // return v + arr[i + 1];
  });

  return res.filter(v => v !== '-1');
};

const arr1 = changeJacard(s1);
const arr2 = changeJacard(s2);

const obj1 = {};
const obj2 = {};

arr1.map(v => {
  obj1[v] ? (obj1[v] += 1) : (obj1[v] = 1);
});

arr2.map(v => {
  obj2[v] ? (obj2[v] += 1) : (obj2[v] = 1);
});

console.log('obj1', obj1);
console.log('obj2', obj2);

let union = 0; //합
let inter = 0; //교

for (const p in obj1) {
  inter += obj2[p] ? Math.min(obj1[p], obj2[p]) : 0;
  union += obj2[p] ? Math.max(obj1[p], obj2[p]) : obj1[p];
}

for (const p in obj2) {
  union += !obj1[p] ? obj2[p] : 0;
}

const answer = inter === 0 && union === 0 ? 65536 : Math.floor((inter / union) * 65536);

console.log('union', union);
console.log('inter', inter);
console.log('answer', answer);
