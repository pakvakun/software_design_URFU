const getTime = (B, K, intervals) => {
  const intervalsCount = intervals.length
  const left = 1 / K
  let sum = 0;

  for (let i = 1; i < B - intervalsCount; i++) {
    sum += 1 / i
  }

  return left * sum
}

module.exports = getTime