const getK = (intervals, b) => {
  const intervalsCount = intervals.length;

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

  return (intervalsCount / (((b + 1) * getSum()) - getSumI()))
}

module.exports = getK