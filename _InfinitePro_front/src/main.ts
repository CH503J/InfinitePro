import './assets/main.css'

import {createApp} from 'vue'
import {createPinia} from 'pinia'

import App from './App.vue'
import router from './router'
import GlobalBackground from './components/GlobalBackground.vue'

// 引入 Naive UI
import naive from 'naive-ui'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(naive)
app.component('GlobalBackground', GlobalBackground)

app.mount('#app')
