import { getBaseURL, get, post, deletes, put } from './request'
interface ResponseBody {
  code: string
  success: boolean
  message: string
  type: string
  data?: any
}

const HttpManager = {
  //获取图片信息
  attachImageUrl: (url) =>
    url
      ? `${getBaseURL()}/${url}`
      : 'https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png',
  //登录
  signIn: ({ username, password }) => post('/user/login/status', { username, password }),
  //邮箱登录
  signInByEmail: (email, password) => post('/user/email/status', { email, password }),
  //注册
  signUp: ({ username, password, sex, phoneNum, email, birth, introduction, location }) =>
    post('/user/register', {
      username,
      password,
      sex,
      phoneNum,
      email,
      birth,
      introduction,
      location
    }),
  //删除用户
  deleteUser: (id) => deletes(`/user/delete?${id}`),
  //更新用户
  updateUserMsg: ({ id, username, sex, phoneNum, email, birth, introduction, location }) =>
    put('/user/update', { id, username, sex, phoneNum, email, birth, introduction, location }),
  //修改密码
  updateUserPwd: ({ id, username, oldPassword, password }) =>
    put('/user/updatePwd', { id, username, oldPassword, password }),
  //获取用户信息
  getUserMsg: (id) => get(`user/detail?${id}`),
  //获取海报列表
  getBannerList: () => get('/banner/getAllBanner'),
  //获取歌单
  getSongList: () => get('songList'),
  //获取歌手列表
  getAllSinger: () => get('singerList')
}

export { HttpManager, ResponseBody }
