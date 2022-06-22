const participant = ["mislav", "stanko", "mislav", "ana"];
const completion = ["stanko", "ana", "mislav"];

const checkComplete = {};
participant.map((v) =>
  checkComplete[v] ? (checkComplete[v] += 1) : (checkComplete[v] = 1)
);

completion.map((v) => (checkComplete[v] -= 1));

function getKeyByValue(object, value) {
  return Object.keys(object).find((key) => object[key] === value);
}

console.log(getKeyByValue(checkComplete, 1));
