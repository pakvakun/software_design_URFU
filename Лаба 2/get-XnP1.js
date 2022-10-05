const XnP1 = (b, k, intervals) => {
  const intervalsCount = intervals.length
  return 1 / (k * (b - intervalsCount))
}

module.exports = XnP1