import './assets/main.css'
import './assets/theme.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

// 导入全局组件
import ColorSwitcher from './components/ColorSwitcher.vue'
import naive from 'naive-ui'

const app = createApp(App)

app.component('ColorSwitcher', ColorSwitcher)

app.use(createPinia())
app.use(naive)
app.use(router)

app.mount('#app')