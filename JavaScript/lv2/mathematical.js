const expression = "100-200*300-500+20";

let arr_expression = expression
  .replace(/(\d+)/g, ",$1,")
  .split(",")
  .filter((v) => v.length > 0);

const only_expression = Array.from(
  new Set(expression.replace(/[0-9]/g, "").split(""))
);

//조합
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

const choice = getPermutations(only_expression, only_expression.length); //선택 가능한 경우의 수

// string 수식을 계산
function evil(fn) {
  return new Function("return " + fn)();
}

const compare_result = [];

choice.map((order) => {
  let copy_arr_expression = JSON.parse(JSON.stringify(arr_expression)); //배열 사본
  let queue_expression = []; //큐에 쌓는 표현식

  // console.log("order------", order);
  order.map((now, index) => {
    // console.log("now::", now);
    //현재 우선순위 수식
    for (let i = 0; i < copy_arr_expression.length; i++) {
      const exp = copy_arr_expression[i];

      if (now === exp) {
        //현재 수식 계산
        const prev_number = queue_expression.pop(); //바로 전에 넣은 값
        const next_number = copy_arr_expression[i + 1]; //이 수식 다음에 오는 값

        const calc = eval(prev_number + now + next_number);
        // console.log(
        //   "현재수식계산 > ",
        //   prev_number + now + next_number,
        //   "::",
        //   calc
        // );
        queue_expression.push(String(calc));
        i += 1;
      } else {
        queue_expression.push(copy_arr_expression[i]);
      }
      // console.log("queue_expression", queue_expression);
    }

    //마지막 계산까지 끝낸 경우
    if (index === order.length - 1) {
      compare_result.push(Math.abs(Number(queue_expression[0])));
    }

    //현재 수식 계산 종료 -> queue 비우고 계산한 식 업데이트
    copy_arr_expression = JSON.parse(JSON.stringify(queue_expression));
    queue_expression = [];
  });
});

const answer = Math.max(...compare_result);
console.log("answer", answer);
