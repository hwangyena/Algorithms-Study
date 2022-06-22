const s = "a";

const result = [];

if (s.length === 1) return 1;

for (let i = 1; i <= s.length / 2; i++) {
  const compression = [];
  let press_str = "";

  for (let j = 0; j < s.length; j += i) {
    const target = s.slice(j, i + j);
    compression.push(target);
  }

  for (let i = 0, j; i < compression.length; i++) {
    const compare = compression[i];
    // console.log(`prev: ${compare} / next: ${compression[i + 1]}`);

    if (compare === compression[i + 1]) {
      //다음 인자랑 같으면,
      let count = 0; //전체 동일한 개수
      for (j = i; j < compression.length && compare === compression[j]; j++) {
        count += 1;
      }
      press_str += `${count}${compare}`;
      i = j - 1;
    } else {
      press_str += compression[i];
    }
  }

  result.push(press_str);
}

const answer = Math.min(...result.map((v) => v.length));

console.log(result);
console.log("answer", answer);
