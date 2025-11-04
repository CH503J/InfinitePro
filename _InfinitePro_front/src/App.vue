<script setup lang="ts">
import { RouterView } from 'vue-router'
import ThemeToggle from './components/ThemeToggle.vue'
import AppHeader from './components/AppHeader.vue'
import { NConfigProvider, darkTheme } from 'naive-ui'
import { ref, computed } from 'vue'

const isDarkMode = ref(false)

// 根据主题状态计算是否使用暗色主题
const theme = computed(() => isDarkMode.value ? darkTheme : null)

// 提供切换主题的方法给 ThemeToggle 组件调用
const toggleTheme = () => {
  isDarkMode.value = !isDarkMode.value
  
  // 同时更新全局背景和系统主题
  document.documentElement.classList.toggle('dark', isDarkMode.value)
  localStorage.setItem('theme', isDarkMode.value ? 'dark' : 'light')
}

// 初始化主题
const initTheme = () => {
  const storedTheme = localStorage.getItem('theme')
  if (storedTheme) {
    isDarkMode.value = storedTheme === 'dark'
  } else {
    isDarkMode.value = window.matchMedia('(prefers-color-scheme: dark)').matches
  }
  document.documentElement.classList.toggle('dark', isDarkMode.value)
}

initTheme()
</script>

<template>
  <NConfigProvider :theme="theme">
    <GlobalBackground />
    <AppHeader />
    <ThemeToggle @toggle-theme="toggleTheme" />
    <RouterView />
  </NConfigProvider>
</template>