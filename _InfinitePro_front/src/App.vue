<script setup lang="ts">
import { RouterView } from 'vue-router'
import { computed, onBeforeUnmount, onMounted, ref, watchEffect } from 'vue'
import { NConfigProvider, NButton, darkTheme, lightTheme } from 'naive-ui'
import HeaderNav from '@/components/home/HeaderNav.vue'
import AppFooter from '@/components/home/AppFooter.vue'

const systemPrefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches
const stored = localStorage.getItem('isDark')
const isDark = ref(stored === null ? systemPrefersDark : stored === 'true')

const theme = computed(() => (isDark.value ? darkTheme : lightTheme))
const toggleTheme = () => {
  isDark.value = !isDark.value
}

watchEffect(() => {
  localStorage.setItem('isDark', isDark.value ? 'true' : 'false')
  document.documentElement.setAttribute('data-theme', isDark.value ? 'dark' : 'light')
})

let mq: MediaQueryList | null = null
const handleMqChange = (e: MediaQueryListEvent) => {
  if (localStorage.getItem('isDark') === null) {
    isDark.value = e.matches
  }
}

onMounted(() => {
  mq = window.matchMedia('(prefers-color-scheme: dark)')
  mq.addEventListener('change', handleMqChange)
})

onBeforeUnmount(() => {
  mq?.removeEventListener('change', handleMqChange)
})
</script>

<template>
  <NConfigProvider :theme="theme">
    <div class="app-root">
      <div class="theme-toggle">
        <NButton size="small" tertiary @click="toggleTheme">{{ isDark ? '🌙' : '☀️' }}</NButton>
      </div>
      <HeaderNav />
      <RouterView />
      <AppFooter />
    </div>
  </NConfigProvider>
  
</template>

<style scoped>
.app-root { position: relative; min-height: 100vh; }
.theme-toggle { position: fixed; top: 1rem; right: 1rem; z-index: 1000; }
</style>
