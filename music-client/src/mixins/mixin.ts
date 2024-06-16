import { getCurrentInstance, computed } from 'vue'
import { useStore } from 'vuex'
import { LocationQueryRaw } from 'vue-router'
import { RouterName } from '@/enums'
import { HttpManager } from '@/api'
import axios from 'axios'
interface routerOptions {
  path?: string
  query?: LocationQueryRaw
}

export default function () {
  const { proxy } = getCurrentInstance()
  const store = useStore()
  const token = computed(() => store.getters.token)

  function getUserSex(sex) {
    if (sex == 0) {
      return '女'
    } else if (sex == 1) {
      return '男'
    }
  }

  function getSongTitle(str) {
    return str.split('-')[1]
  }

  function getSingerName(str) {
    return str.split('-')[0]
  }

  function checkStatus(status?: boolean) {
    if (!token.value) {
      if (status) {
        (proxy as any).$message({
          message: '请先登录！',
          type: 'warning'
        })
      }
      return false
    }
    return true
  }

  function playMusic({ id, url, pic, index, name, lyric, currentSongList }) {
    const songTitle = getSongTitle(name)
    const singerName = getSingerName(name)
    proxy.$store.dispatch('playMusic', {
      id,
      url,
      pic,
      index,
      songTitle,
      singerName,
      lyric,
      currentSongList
    })
  }

  function getFileName(path) {
    const parts = path.split('/')
    return parts[parts.length - 1]
  }

  async function downloadMusic({ songUrl, songName }) {
    if (!songUrl) {
      (proxy as any).$message({
        message: '下载链接为空！',
        type: 'error'
      })
      return
    }
    const fileName = getFileName(songUrl)
    const downloadUrl = '/download/' + fileName
    const response = await axios.get(downloadUrl, {
      responseType: 'blob'
    })
    const blob = new Blob([response.data], { type: 'application/octet-stream' })
    const url = window.URL.createObjectURL(blob)

    const link = document.createElement('a')
    link.href = url
    link.download = fileName
    document.body.appendChild(link)
    link.click()
    window.URL.revokeObjectURL(url)
    document.body.removeChild(link)
  }

  function changeIndex(value) {
    proxy.$store.commit('setActiveNavName', value)
  }

  // 路由管理
  function routerManager(routerName: string | number, options: routerOptions) {
    switch (routerName) {
      case RouterName.Search:
        proxy.$router.push({ path: options.path, query: options.query })
        break
      case RouterName.Home:
      case RouterName.SongSheet:
      case RouterName.SongSheetDetail:
      case RouterName.Singer:
      case RouterName.SingerDetail:
      case RouterName.Personal:
      case RouterName.PersonalData:
      case RouterName.Setting:
      case RouterName.SignIn:
      case RouterName.SignUp:
      case RouterName.SignOut:
      case RouterName.Lyric:
      case RouterName.Error:
      default:
        proxy.$router.push({ path: options.path })
        break
    }
  }

  function goBack(step = -1) {
    proxy.$router.go(step)
  }

  return {
    getUserSex,
    getSongTitle,
    getSingerName,
    changeIndex,
    playMusic,
    downloadMusic,
    routerManager,
    goBack
  }
}
