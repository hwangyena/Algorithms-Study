/** 문자열 수식 계산 */
function evil(fn) {
  return new Function("return " + fn)();
}

/** 소수인가? */
const isPrime = (num) => {
  for (let i = 2, s = Math.sqrt(num); i <= s; i++)
    if (num % i === 0) return false;
  return num > 1;
};
