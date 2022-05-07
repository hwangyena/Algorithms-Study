const arr = [1, 6, 7, 11, 15, 17, 21, 26, 28, 30, 41];
// const arr = [1, 6, 7, 11, 15];

const binarySearch = (arr, start, end, key) => {
  const p = Math.round((start + end) / 2);

  if (arr[p] === key) return p;
  if (start === end) return -1;

  if (arr[p] < key) return binarySearch(arr, p + 1, end, key);
  else return binarySearch(arr, start, p - 1, key);
};

console.log('binary', binarySearch(arr, 0, arr.length - 1, 26));
