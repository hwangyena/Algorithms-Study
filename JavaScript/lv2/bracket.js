const p = "(()())()";

//균형잡힌 문자열인지?
const isCorrectBracket = (str) => {
  const stack = [];
};

const makeCorrectBracket = (str) => {
  if (str.length === 0) return "";

  const stack = [];
  let u = ""; //균형잡힌 문자열

  stack.push(str.substring(0, 1));
  u += str.substring(0, 1);

  str = str.substring(1); //1이후부터 짜름

  while (stack.length !== 0) {
    if (str.length === 0) break;

    const top = stack[stack.length - 1];
    const current = str.substring(0, 1);

    console.log(`top:${top}, current: ${current}, ===str:${str}`);

    if (top === current) {
      stack.push(current);
    } else {
      stack.pop();
    }
    u += current;
    str = str.substring(1); // 맨 앞자리 문자열 자르기

    console.log("str:::", str, "stack===>", stack);
  }

  if (!isCorrectBracket(u)) {
    const newStr = "(";
    /////// 재귀적으로 구하는 부분에서 귀찮아서 passs.....
  }
  makeCorrectBracket(str);
};

makeCorrectBracket(p);
