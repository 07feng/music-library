import { RouterName } from '@/enums/router-name'
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

  return { routerManager }
}
