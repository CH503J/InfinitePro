import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

// 导入全局组件
import Header from './components/Header.vue'
import TheFooter from './components/TheFooter.vue'
import ColorSwitcher from './components/ColorSwitcher.vue'

const app = createApp(App)

// 注册全局组件
app.component('Header', Header)
app.component('TheFooter', TheFooter)
app.component('ColorSwitcher', ColorSwitcher)

app.use(createPinia())
app.use(router)

app.mount('#app')