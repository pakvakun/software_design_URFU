const FindErrors = require("./find-errors");
const getK = require("./get-k");
const getTime = require("./get-time");
const getXnP1 = require("./get-XnP1");

var intervals = [9, 12, 11, 4, 7, 2, 5, 8, 5, 7, 1, 6, 1, 9, 4, 1, 3, 3, 6, 1, 11, 33, 7, 91, 2, 1];


const B = FindErrors(intervals);

const K = getK(intervals, B)

const XnP1 = getXnP1(B, K, intervals);

const time = getTime(B, K, intervals);


console.log(`Число ошибок в системе: ~ ${Math.round(B)}`);
console.log(`Коэффициент пропорциональности: ~ ${K.toFixed(5)}`);
console.log(`Cреднее время Xn+1 : ~ ${XnP1}`);
console.log(`Время до окончания тестирования: ~ ${time}`);
