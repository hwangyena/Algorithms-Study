const s = "[[";

let answer = 0;
const isOpen = "[({";

const isCorrectBracket = (arr) => {
  let stack = [];

  for (let i = 0; i < arr.length; i++) {
    if (isOpen.includes(arr[i])) stack.push(arr[i]);
    else {
      if (stack.length === 0) return false;

      const bracket = stack.pop();
      if (
        (arr[i] === "}" && bracket === "{") ||
        (arr[i] === ")" && bracket === "(") ||
        (arr[i] === "]" && bracket === "[")
      ) {
        continue;
      }
      return false;
    }
  }
  if (stack.length > 0) return false;
  return true;
};

for (let x = 0; x < s.length; x++) {
  const arr = s.split("");

  //회전
  for (let rotate = 0; rotate < x; rotate++) {
    arr.push(arr.shift());
  }
  if (isCorrectBracket(arr)) answer++;
  console.log(arr.join(""), `----> ${isCorrectBracket(arr)}`);
}

console.log(answer);
