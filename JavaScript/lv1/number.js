const s = 'ninezerozero9871';

const answer = s
  .replace(/zero/gi, '0')
  .replace(/one/gi, '1')
  .replace(/two/gi, '2')
  .replace(/three/gi, '3')
  .replace(/four/gi, '4')
  .replace(/five/gi, '5')
  .replace(/six/gi, '6')
  .replace(/seven/gi, '7')
  .replace(/eight/gi, '8')
  .replace(/nine/gi, '9');

console.log('answer', answer);
