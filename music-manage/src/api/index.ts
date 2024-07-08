import { post } from './request'

interface ResponseBody {
  code: string
  success: boolean
  message: string
  type: string
  data?: any
}

const HttpManager = {
  getLoginStatus: ({ username, password }) => post(`user/login/status`, { username, password })
}

export { type ResponseBody, HttpManager }
