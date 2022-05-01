const new_id = '...!@BaT#*..y.abcdefghijklm.';
// const new_id = 'abcdefghijklmn.p';

let answer = new_id
  .toLowerCase()
  .replace(/[^\da-z-_\.]/gi, '')
  .replace(/\.{2,}/g, '.')
  .replace(/^\./gi, '')
  .replace(/\.$/gi, '');

answer = answer.length === 0 ? 'a' : answer;
answer = answer.length > 15 ? answer.slice(0, 15) : answer;
answer = answer.replace(/\.$/gi, '');
while (answer.length <= 2) {
  answer = answer + answer[answer.length - 1];
}
