import './assets/css/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'

import App from './App.vue'
import router from './router'
import store from './stores/index'
import type { Store } from 'vuex/types/index.js'

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

app.mount('#app')
