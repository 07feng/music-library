import axios from 'axios'
import router from '@/router'

const BASE_URL = process.env.NODE_HOST

axios.defaults.timeout = 5000 //超时时间设置
axios.defaults.withCredentials = true //允许跨域
axios.defaults.baseURL = BASE_URL
//响应头
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urencoded;charset=UTF-8'

//响应拦截器
axios.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      return Promise.resolve(response)
    } else {
      return Promise.reject(response)
    }
  },
  (error) => {
    if (error.response.status) {
      switch (error.response.status) {
        case 401:
          router.replace({
            path: '/',
            query: {
              //redirect: router.currentRoute.fullPath
            }
          })
          break
        case 403:
          setTimeout(() => {
            router.replace({
              path: '/',
              query: {}
            })
          }, 1000)
          break
        case 404:
          break
      }
      return Promise.reject(error.response)
    }
  }
)

export function getBaseURL() {
  return BASE_URL
}

export function get(url, params?: object) {
  return new Promise((resolve, reject) => {
    axios
      .get(url, params)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err)
      })
  })
}

export function post(url, data = {}) {
  return new Promise((resolve, reject) => {
    axios
      .post(url, data)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err)
      })
  })
}

export function deletes(url, params?: object) {
  return new Promise((resolve, reject) => {
    axios
      .delete(url, params)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err)
      })
  })
}

export function put(url, data = {}) {
  return new Promise((resolve, reject) => {
    axios
      .put(url, data)
      .then((res) => {
        resolve(res.data)
      })
      .catch((err) => {
        reject(err)
      })
  })
}
