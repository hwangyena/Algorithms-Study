const numbers = "16";

const num = numbers.split("");

const getPermutations = function (arr, selectNumber) {
  const results = [];
  if (selectNumber === 1) return arr.map((el) => [el]);
  // n개중에서 1개 선택할 때(nP1), 바로 모든 배열의 원소 return. 1개선택이므로 순서가 의미없음.

  arr.forEach((fixed, index, origin) => {
    const rest = [...origin.slice(0, index), ...origin.slice(index + 1)];
    // 해당하는 fixed를 제외한 나머지 배열
    const permutations = getPermutations(rest, selectNumber - 1);
    // 나머지에 대해서 순열을 구한다.
    const attached = permutations.map((el) => [fixed, ...el]);
    //  돌아온 순열에 떼 놓은(fixed) 값 붙이기
    results.push(...attached);
    // 배열 spread syntax 로 모두다 push
  });

  return results; // 결과 담긴 results return
};

let answer = 0;

const isPrime = (num) => {
  for (let i = 2, s = Math.sqrt(num); i <= s; i++)
    if (num % i === 0) return false;
  return num > 1;
};

const checkNumber = [];

for (let i = 1; i <= num.length; i++) {
  const value = getPermutations(num, i).map((v) =>
    Number(v.toString().replace(/,/g, ""))
  );
  checkNumber.push(...value);
}

const newNumber = Array.from(new Set(checkNumber));

console.log("newNumber", JSON.stringify(newNumber));

newNumber.map((v) => {
  if (isPrime(v)) answer++;
});

console.log("answer", answer);
