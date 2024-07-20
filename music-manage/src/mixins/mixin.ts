import { RouterName } from '@/enums/router-name'
import { SingerSex } from '@/enums/singer-sex'
import { getCurrentInstance, ref } from 'vue'
import type { LocationQueryRaw } from 'vue-router'

interface routerOptions {
  path?: string
  query?: LocationQueryRaw
}
export default function () {
  const { proxy } = getCurrentInstance()
  const uploadTypes = ref(['jpg', 'jpeg', 'png', 'gif'])

  function routerManager(routerName: string | number, options: routerOptions) {
    switch (routerName) {
      case RouterName.Home:
      default:
        proxy.$router.push({ path: options.path })
        break
    }
  }

  function changeSex(value) {
    switch (value) {
      case SingerSex.MAIL:
        return '男'
      case SingerSex.FEMAIL:
        return '女'
      case SingerSex.GROUP:
        return '音乐组合'
      case SingerSex.VARIOUS:
        return '群星'
      case SingerSex.UNKNOWN:
        return '未知'
    }
  }

  return { changeSex, routerManager }
}
