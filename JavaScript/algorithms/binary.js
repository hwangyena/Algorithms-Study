const arr = [1, 6, 7, 11, 15, 17, 21, 26, 28, 30, 41];
// const arr = [1, 6, 7, 11, 15];

const binarySearch = (arr, start, end, key) => {
  const p = Math.round((start + end) / 2);

  if (arr[p] === key) return p;
  if (start === end) return -1;

  if (arr[p] < key) return binarySearch(arr, p + 1, end, key);
  else return binarySearch(arr, start, p - 1, key);
};

console.log("binary", binarySearch(arr, 0, arr.length - 1, 26));

const binarySearch2 = (arr, target) => {
  let left = 0;
  let right = arr.length - 1;
  let mid = Math.floor((left + right) / 2);
  while (left <= right) {
    if (arr[mid] === target) return mid;
    if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;

    mid = Math.floor((left + right) / 2);
  }

  //mid가 마지막까지 비교했던 값
  return mid + 1;
};
