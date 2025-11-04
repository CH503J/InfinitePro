<script setup lang="ts">
import {RouterView} from 'vue-router'
import ThemeToggle from './components/ThemeToggle.vue'
import AppHeader from './components/AppHeader.vue'
import {NConfigProvider, darkTheme, useOsTheme} from 'naive-ui'
import {ref, computed} from 'vue'

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
    // 使用 naive-ui 的 useOsTheme 方法获取系统主题
    const osTheme = useOsTheme()

    if (osTheme.value) {
      // 如果能成功获取到系统主题，则使用系统主题
      isDarkMode.value = osTheme.value === 'dark'
    } else {
      // 如果获取不到系统主题，则使用默认的 prefers-color-scheme
      isDarkMode.value = window.matchMedia('(prefers-color-scheme: dark)').matches
    }
  }
  document.documentElement.classList.toggle('dark', isDarkMode.value)
}

// 在组件挂载后初始化主题
initTheme()
</script>

<template>
  <NConfigProvider :theme="theme">
    <GlobalBackground/>
    <AppHeader/>
    <ThemeToggle @toggle-theme="toggleTheme"/>
    <RouterView/>
  </NConfigProvider>
</template>
