const id_list = ['muzi', 'frodo', 'apeach', 'neo'];
const report = ['muzi frodo', 'apeach frodo', 'frodo neo', 'muzi neo', 'apeach muzi', 'muzi frodo'];
const k = 2;

// const reducer = (previousValue, currentValue) => previousValue + currentValue;

const reportList = id_list.reduce((p, c, i) => {
  // console.log('i',i)
  if (i === 1) {
    p = { [`${p}`]: [], [`${c}`]: [] };
  } else {
    p = { ...p, [`${c}`]: [] };
  }
  return p;
});

const reportCount = id_list.reduce((p, c, i) =>
  i === 1 ? (p = { [`${p}`]: 0, [`${c}`]: 0 }) : { ...p, [`${c}`]: 0 }
);

report.map(v => {
  const value = v.split(' ');
  const from = value[0]; //신고자
  const to = value[1]; //피신고자

  if (reportList[from].every(v2 => v2 !== to)) {
    reportList[from] = [...reportList[from], to];
    reportCount[to] += 1;
  }
});

//정지되는 유저
const banUser = id_list.filter(v => reportCount[v] >= k);

const answer = id_list.map(() => 0);

id_list.map((v, i) => {
  // reportList[v] //현재 유저가 신고한 목록 -> banUser에 몇명있는지만 알면됨
  reportList[v].map(v2 => {
    if (banUser.includes(v2)) {
      answer[i] += 1;
    }
  });
});
