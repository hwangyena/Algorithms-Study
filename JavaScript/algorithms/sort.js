function swap(arr, x, y) {
  const temp = arr[x];
  arr[x] = arr[y];
  arr[y] = temp;
}

const arr = [5, 9, 1, 6, 2];

//end: 4

/** bubble sort */
const bubbleSort = (arr, len) => {
  for (let i = len - 1; i >= 0; i--) {
    for (let j = 0; j < i; j++) {
      if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }
  }
};

/** selection sort */
const selectionSort = (arr, len) => {
  for (let i = 0; i < len - 1; i++) {
    let min = i;
    for (let j = i + 1; j < len; j++) {
      if (arr[j] < arr[min]) min = j;
    }
    swap(arr, min, i);
  }
};

/** insertion sort */
const insertionSort = (arr, len) => {
  for (let i = 1; i < len; i++) {
    let j;
    let tmp = arr[i]; //정렬할 값
    for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
      arr[j] = arr[j - 1];
    }
    arr[j] = tmp;
  }
};

/** shell sort */
const shellSort = (arr, len) => {
  let h;
  for (h = 1; h < len / 9; h = h * 3 + 1);

  for (; h > 0; h /= 3) {
    for (let i = h; i < len; i++) {
      let j; //비교해줄 인덱스 번호
      let tmp = arr[i]; //정렬할 값
      for (j = i - h; j >= 0 && arr[j] > tmp; j -= h) {
        arr[j + h] = arr[j];
      }
      arr[j + h] = tmp;
    }
  }
};

/** quick sort */
const quickSort = (arr, left, right) => {
  let pl = left; //왼쪽
  let pr = right; //오른쪽
  let pivot = arr[Math.round((pl + pr) / 2)]; //기준

  do {
    while (arr[pl] < pivot) pl++;
    while (arr[pr] > pivot) pr--;

    if (pl <= pr) swap(arr, pl++, pr--);
  } while (pl <= pr);

  if (left < pr) quickSort(arr, left, pr);
  if (right > pl) quickSort(arr, pl, right);
};

/** merge sort */
const tempArr = [];

const mergeSort = (arr, left, right) => {
  if (left < right) {
    let center = Math.floor((left + right) / 2);

    mergeSort(arr, left, center);
    mergeSort(arr, center + 1, right);

    let temp = left;
    let leftPos = left; //left 위치
    let rightPos = center + 1; //right 위치

    while (leftPos <= center && rightPos <= right) {
      if (arr[leftPos] < arr[rightPos]) tempArr[temp++] = arr[leftPos++];
      else tempArr[temp++] = arr[rightPos++];
    }

    //남은 요소 제거
    while (leftPos <= center) tempArr[temp++] = arr[leftPos++];
    while (rightPos <= right) tempArr[temp++] = arr[rightPos++];

    for (let i = left; i <= right; i++) {
      arr[i] = tempArr[i];
    }
  }
};

/** heap sort */
function downHeap(arr, root, len) {
  let left = 2 * root + 1;
  let right = 2 * root + 2;
  let max = root;

  if (left < len && arr[left] > arr[max]) {
    max = left;
  }

  if (right < len && arr[right] > arr[max]) {
    max = right;
  }

  if (max != root) {
    swap(arr, root, max);
    downHeap(arr, max, len);
  }
}

const heapSort = (arr, len) => {
  //1. 최대 힙구조로 변환 -> 가장 최하단 자식 노드 제외 힙 만들어주기
  for (let i = Math.floor((len - 1) / 2); i >= 0; i--) {
    downHeap(arr, i, len);
  }

  //2. 힙 크기를 줄이면서 힙 구성(root: 가장 큰 값->하단에 놓기)
  for (let i = len - 1; i > 0; i--) {
    swap(arr, 0, i);
    downHeap(arr, 0, i);
  }
};

heapSort(arr, arr.length);
console.log('heap', arr);
