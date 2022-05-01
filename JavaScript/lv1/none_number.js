const numbers = [1, 2, 3, 4, 6, 7, 8, 0];

const answer = 45 - numbers.reduce((p, c) => p + c);
console.log('answer', answer);
