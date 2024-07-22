import './assets/css/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import App from './App.vue'
import router from './router'
import store from './stores/index'
import { Store } from 'vuex'

declare module '@vue/runtime-core' {
  interface State {
    count: number
  }

  interface ComponentCustomProperties {
    $store: Store<State>
  }
}

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(store)
app.use(ElementPlus)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.mount('#app')
