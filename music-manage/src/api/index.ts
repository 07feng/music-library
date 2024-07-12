import { post } from './request'

interface ResponseBody {
  code: string
  message: string
  data?: any
}

const HttpManager = {
  login: ({ userName, password }) => post(`/auth/login`, { userName, password })
}

export { type ResponseBody, HttpManager }
