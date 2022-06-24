const record = [
  "Enter uid1234 Muzi",
  "Enter uid4567 Prodo",
  "Change uid4567 Ryan",
  "Leave uid4567",
  "Enter uid1234 Prodo",
];

const user = {};
const onlyCommand = [];

record.map((v) => {
  const command = v.split(" ");

  const active = command[0];
  const uid = command[1];
  const nickname = command[2];

  switch (active) {
    case "Leave":
      onlyCommand.push(v);
      break;
    case "Enter":
      onlyCommand.push(v);
    case "Change":
      user[uid] = nickname;
  }
});

const result = [];

onlyCommand.map((v) => {
  const command = v.split(" ");

  const active = command[0];
  const uid = command[1];

  switch (active) {
    case "Leave":
      result.push(`${user[uid]}님이 나갔습니다.`);
      break;
    case "Enter":
      result.push(`${user[uid]}님이 들어왔습니다.`);
  }
});

console.log("onlyCommand", onlyCommand);
console.log("result", result);
