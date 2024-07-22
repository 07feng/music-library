export function getBirth(dateValue) {
  if (dateValue == null || dateValue == '') {
    return ''
  }
  const date = new Date(dateValue)
  const year = date.getFullYear
  const month = date.getMonth() + 1
  const formatMonth = month < 10 ? '0' + month : month
  const day = date.getDay() < 10 ? 0 + date.getDate() : date.getDay()
  return year + '-' + formatMonth + '-' + day
}
