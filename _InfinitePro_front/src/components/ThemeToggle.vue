<script setup lang="ts">
import {ref, onMounted} from 'vue'
import {NSwitch} from 'naive-ui'

const isDark = ref(false)

// 更新主题状态
const updateTheme = () => {
  const storedTheme = localStorage.getItem('theme')
  if (storedTheme) {
    isDark.value = storedTheme === 'dark'
  } else {
    isDark.value = window.matchMedia('(prefers-color-scheme: dark)').matches
  }
}

// 切换主题
const toggleTheme = () => {
  isDark.value = !isDark.value
  // 触发自定义事件，通知父组件主题已切换
  emit('toggleTheme')
}

// 设置开关轨道样式
function railStyle({focused, checked}: { focused: boolean; checked: boolean }) {
  const style: { background?: string; boxShadow?: string } = {}
  if (checked) {
    style.background = '#18a058'
    if (focused) {
      style.boxShadow = '0 0 0 2px #d0305040'
    }
  } else {
    style.background = '#e1e1e1'
    if (focused) {
      style.boxShadow = '0 0 0 2px #2080f040'
    }
  }
  return style
}

// 定义事件发射器
const emit = defineEmits(['toggleTheme'])

onMounted(() => {
  updateTheme()
})

defineExpose({
  isDark
})
</script>

<template>
  <n-switch
    :rail-style="railStyle"
    :value="isDark"
    @update:value="toggleTheme"
    class="theme-toggle"
  >
    <template #checked>🌙</template>
    <template #unchecked>🌞</template>
  </n-switch>
</template>

<style scoped>
.theme-toggle {
  position: fixed;
  top: 1rem;
  right: 1rem;
  z-index: 1000;
}
</style>
