import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import GlobalBackground from './components/GlobalBackground.vue'

// 应用主题
const setInitialTheme = () => {
  const storedTheme = localStorage.getItem('theme')
  if (storedTheme) {
    document.documentElement.classList.toggle('dark', storedTheme === 'dark')
  } else if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
    document.documentElement.classList.add('dark')
  }
}

setInitialTheme()

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.component('GlobalBackground', GlobalBackground)

app.mount('#app')