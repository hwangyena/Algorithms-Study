// 거리두기 확인하기

// 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면,
// T1, T2 사이의 맨해튼 거리는 | r1 - r2 | + | c1 - c2 | 입니다. ↩
/**
 * POOOP
 * OXXPX
 * ASDVA
 */

const places = [
  ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
  // ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
  // ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
  // ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
  // ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"],
];
const move = [
  [0, -1],
  [-1, 0],
  [1, 0],
  [0, 1],
];

function solution(places) {
  var answer = places.map((place) => {
    // 결과가 true 이면 거리두기가 지켜지지 않음
    return place.some((row, rowIndex) => {
      // true 이면 거리두기가 지켜지지 않음, 바로 종료
      return row.split("").some((column, index, arr) => {
        // 파티션이 있으면 거리두기 지킴
        if (column == "X") return false;

        // 상하좌우에 P가 몇개인지 조회
        const userCount = [
          arr[index - 1] || null, // 좌
          arr[index + 1] || null, // 우
          (place[rowIndex - 1] || "").charAt(index), // 상
          (place[rowIndex + 1] || "").charAt(index), // 하
        ].filter((v) => v == "P").length;

        if (
          (column == "P" && userCount > 0) || // P기준 상하좌우에 P가 있는지
          (column == "O" && userCount >= 2)
        ) {
          // O기준 상하좌우에 P가 2개 이상인지
          return true;
        }

        return false;
      }, "");
    })
      ? 0
      : 1;
  });

  return answer;
}

// placeToArray.map((place, count) => {
//   place.map((row, col) => {
//     console.group(row);
//     if (!row.some((v) => v === "P")) return;
//     row.map((v, i) => {
//       if (v === "P") {
//         console.log(`place[col][i] ${place[col][i]}`);
//         const t = col - 1 >= 0 ? place[col - 1][i] : "N";
//         const b = col + 1 <= 4 ? place[col + 1][i] : "N";
//         const l = i - 1 >= 0 ? place[col][i - 1] : "N";
//         const r = i + 1 <= 4 ? place[col][i + 1] : "N";
//         const t2 = col - 2 >= 0 ? place[col - 2][i] : "N";
//         const b2 = col + 2 <= 4 ? place[col + 2][i] : "N";
//         const l2 = i - 2 >= 0 ? place[col][i - 2] : "N";
//         const r2 = i + 2 <= 4 ? place[col][i + 2] : "N";
//         const tl = col - 1 >= 0 && i - 1 >= 0 ? place[col - 1][i - 1] : "N";
//         const tr = col - 1 >= 0 && i + 1 <= 4 ? place[col - 1][i + 1] : "N";
//         const bl = col + 1 <= 4 && i - 1 >= 0 ? place[col + 1][i - 1] : "N";
//         const br = col + 1 <= 4 && i + 1 <= 4 ? place[col + 1][i + 1] : "N";

//         console.log(`${tl}  ${t}  ${tr}`);
//         console.log(`${l}   ${place[col][i]}  ${r}`);
//         console.log(`${bl}  ${b}  ${br}`);
//         if (t === "X" || b === "X" || l === "X" || r === "X") return;
//         if (t2 === "P" || b2 === "P" || l2 === "P" || r2 === "P") {
//           answer[count] = 0;
//         }
//         if (t === "P" || b === "P" || l === "P" || r === "P") {
//           answer[count] = 0;
//         }
//         if (tl === "P" && (t !== "X" || l !== "X")) {
//           answer[count] = 0;
//         }
//         if (tr === "P" && (t !== "X" || r !== "X")) {
//           answer[count] = 0;
//         }
//         if (bl === "P" && (b !== "X" || l !== "X")) {
//           answer[count] = 0;
//         }
//         if (br === "P" && (b !== "X" || r !== "X")) {
//           answer[count] = 0;
//         }
//       }
//     });
//     console.groupEnd();
//   });
// });
