<template>
  <button @click="toggleTheme" class="theme-switcher" :aria-label="`Switch to ${nextTheme} theme`">
    {{ nextTheme }} theme
  </button>
</template>

<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'

const currentTheme = ref<'light' | 'dark'>('light')

const nextTheme = computed(() => {
  return currentTheme.value === 'light' ? 'dark' : 'light'
})

const toggleTheme = () => {
  currentTheme.value = nextTheme.value
  document.documentElement.setAttribute('data-theme', currentTheme.value)
  localStorage.setItem('theme', currentTheme.value)
  
  // 更新CSS变量
  if (currentTheme.value === 'dark') {
    document.documentElement.style.setProperty('--color-background', 'var(--vt-c-black)')
    document.documentElement.style.setProperty('--color-background-soft', 'var(--vt-c-black-soft)')
    document.documentElement.style.setProperty('--color-background-mute', 'var(--vt-c-black-mute)')
    document.documentElement.style.setProperty('--color-border', 'var(--vt-c-divider-dark-2)')
    document.documentElement.style.setProperty('--color-border-hover', 'var(--vt-c-divider-dark-1)')
    document.documentElement.style.setProperty('--color-heading', 'var(--vt-c-text-dark-1)')
    document.documentElement.style.setProperty('--color-text', 'var(--vt-c-text-dark-2)')
  } else {
    document.documentElement.style.setProperty('--color-background', 'var(--vt-c-white)')
    document.documentElement.style.setProperty('--color-background-soft', 'var(--vt-c-white-soft)')
    document.documentElement.style.setProperty('--color-background-mute', 'var(--vt-c-white-mute)')
    document.documentElement.style.setProperty('--color-border', 'var(--vt-c-divider-light-2)')
    document.documentElement.style.setProperty('--color-border-hover', 'var(--vt-c-divider-light-1)')
    document.documentElement.style.setProperty('--color-heading', 'var(--vt-c-text-light-1)')
    document.documentElement.style.setProperty('--color-text', 'var(--vt-c-text-light-1)')
  }
}

onMounted(() => {
  const savedTheme = localStorage.getItem('theme') as 'light' | 'dark' | null
  if (savedTheme) {
    currentTheme.value = savedTheme
    toggleTheme()
  } else if (window.matchMedia('(prefers-color-scheme: dark)').matches) {
    currentTheme.value = 'dark'
    toggleTheme()
  }
})
</script>

<style scoped>
.theme-switcher {
  background-color: var(--color-background-mute);
  border: 1px solid var(--color-border);
  border-radius: 4px;
  padding: 0.5rem 1rem;
  cursor: pointer;
  color: var(--color-text);
  transition: background-color 0.3s ease;
}

.theme-switcher:hover {
  background-color: var(--color-background-soft);
}
</style>