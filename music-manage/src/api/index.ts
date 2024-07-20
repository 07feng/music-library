import { get, post } from './request'

interface ResponseBody {
  code: string
  message: string
  data?: any
}

const HttpManager = {
  //登录
  login: ({ userName, password }) => post(`/operating/auth/login`, { userName, password }),
  //歌手性别比例
  singerSexRadio: () => get(`/music/singer/echarts/sex_radio`),
  //歌手籍贯统计
  singerCountryStatistics: () => get(`/music/singer/echarts/country/statistics`),
  //用户分页列表
  getUserPageList: (pageNum, pageSize, { searchKey }) =>
    post(`/operating/user_manage/page?pageNum=${pageNum}&pageSize=${pageSize}`, { searchKey })
}

export { type ResponseBody, HttpManager }
