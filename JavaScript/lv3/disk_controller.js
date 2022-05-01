const jobs = [
  [0, 3],
  [1, 9],
  [2, 6],
];

//가장 먼저 시작하는 작업 구하기
let answer = 0; //총 걸린 시간
let time = 0; //현재 시간

const first = Math.min(...jobs.map(v => v[0]));
const first_job = jobs.filter(v => v[0] === first);
let left_job = jobs.filter(v => v[0] !== first);
answer = first_job[0][0] + first_job[0][1];
time = first_job[0][0] + first_job[0][1];

console.log('first', first_job);

//작업 진행 & 최솟값 구하기
while (left_job.length !== 0) {
  const available_job = left_job.filter(v => v[0] <= answer); //현재 수행가능한 작업
  if (available_job.length === 0) {
    time += 1; //현재 수행가능한 작업이 없으면 다음 타임으로 넘겨주기
    continue;
  }
  //가장 최솟값 -> 다음 사용할 작업
  const min_value = Math.min(...available_job.map(v => v[1] - v[0] + answer));
  const next_job = available_job.filter(v => v[1] - v[0] + answer === min_value);

  answer += time - next_job[0][0] + next_job[0][1];
  time += next_job[0][1];

  left_job = left_job.filter(v => v[0] !== next_job[0][0] || v[1] !== next_job[0][1]);
}

console.log('time', time);

console.log('answer', Math.floor(answer / jobs.length));
