const FindErrors = () => {
  var intervals = [9, 12, 11, 4, 7, 2, 5, 8, 5, 7, 1, 6, 1, 9, 4, 1, 3, 3, 6, 1, 11, 33, 7, 91, 2, 1];
  var intervalsCount = intervals.length;
  var HIGH = 100000;
  var STEP = 0.0001;

  const left = (b) => {
    var result = 0;
    for (let i = 0, j = 1; i < intervalsCount; i++, j++) {
      result += (1 / (b - j + 1));
    }
    return result;
  };

  // Сумма интервалов между ошибками.
  const getSum = () => {
    var result = 0;
    for (let i = 0; i < intervalsCount; i++) {
      result += intervals[i];
    }
    return result;
  };

  // Сумма произведений интервалов между ошибками на их порядковый номер.
  const getSumI = () => {
    var result = 0;
    for (let i = 0, j = 1; i < intervalsCount; i++, j++) {
      result += j * intervals[i];
    }
    return result;
  };

  const right = (b) => {
    return (intervalsCount * getSum()) / ((b + 1) * getSum() - getSumI());
  };

  var r = 0.0;
  var r1 = 0.0;
  var d = intervalsCount;
  r = Infinity;
  for (let i = 0; i < HIGH; i++) {
    r1 = r;
    r = Math.abs(left(d) - right(d));
    if (r > r1) {
      break;
    }
    d = d + STEP;
  };

  console.log(`result: ${d}`);
  console.log(`Число ошибок в системе: ~ ${Math.round(d)}`);
}

FindErrors();