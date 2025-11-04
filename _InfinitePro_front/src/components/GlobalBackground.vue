<template>
  <div class="global-background"></div>
</template>

<script setup lang="ts">
// 全局背景组件不需要任何逻辑，它只是根据CSS类来显示不同的背景色
</script>

<style scoped>
.global-background {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1; /* 确保在所有内容之下 */
  background-color: #ffffff; /* 默认亮色背景 */
  transition: background-color 0.3s ease;
}

/* 当根元素有 dark 类时，应用暗色背景 */
:root.dark .global-background {
  background-color: #121212; /* 暗色背景 */
}
</style>