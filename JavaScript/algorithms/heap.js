const heap = [];

const swap = (a, b) => {
  const t = heap[a];
  heap[a] = heap[b];
  heap[b] = t;
};

const insertHeap = val => {
  heap.push(val);
  let cur = heap.length - 1; //현재노드
  let parent = Math.floor(cur / 2); //부모노드

  // //최소힙
  // while (heap[parent] > heap[cur]) {
  //   swap(parent, cur);
  //   cur = parent;
  //   parent = Math.floor(cur / 2);
  // }
  //최대힙
  while (heap[parent] < heap[cur]) {
    swap(parent, cur);
    cur = parent;
    parent = Math.floor(cur / 2);
  }
};

//맨 첫번째 노드 삭제
const deleteHeap = () => {
  heap.shift();
  heap.unshift(heap.pop());

  let cur = 0;
  let left_child = cur * 2 + 1;
  let right_child = cur * 2 + 2;
  // let small = heap[left_child] < heap[right_child] ? left_child : right_child; //최소힙
  let big = heap[left_child] > heap[right_child] ? left_child : right_child; //최대힙

  // //최소힙
  // while (heap[cur] > heap[small]) {
  //   swap(cur, small);
  //   cur = small;
  //   left_child = cur * 2 + 1;
  //   right_child = cur * 2 + 2;
  //   small = heap[left_child] < heap[right_child] ? left_child : right_child; //최소힙
  //   if (heap[left_child] === undefined) break;
  //   small = !heap[right_child] && left_child;
  // }
  //최대힙
  while (heap[cur] < heap[big]) {
    swap(cur, big);
    cur = big;
    left_child = cur * 2 + 1;
    right_child = cur * 2 + 2;
    big = heap[left_child] < heap[right_child] ? left_child : right_child; //최소힙
    if (heap[left_child] === undefined) break;
    big = !heap[right_child] && left_child;
  }
};

const deleteNode = node => {};

insertHeap(9);
insertHeap(7);
insertHeap(5);
insertHeap(2);
insertHeap(1);
console.log('heap', heap);
deleteHeap();

console.log('heap', heap);
