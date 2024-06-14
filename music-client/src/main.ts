import './assets/main.css'

import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/css/index.scss'
import '@/assets/icons/index.js'

import { ComponentCustomProperties } from 'vue'
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
app.use(router)
app.use(store)
app.use(ElementPlus)

app.mount('#app')
