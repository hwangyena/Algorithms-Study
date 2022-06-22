/**
 * n까지의 소수 반환하기
 */

function eratos(n) {
  //true - 소수
  const arr = Array.from({ length: n }, () => true);

  for (let i = 2; i * i <= n; i += 1) {
    if (arr[i]) {
      //소수인 경우
      for (let j = i * i; j <= n; j += i) {
        arr[j] = false; //소수에 2부터 곱한것은 소수가 X
      }
    }
  }

  //0,1은 소수가 아니므로 false로 바꿔주기
  arr.splice(0, 2, false, false);

  return arr.filter((v) => v !== false);
}
