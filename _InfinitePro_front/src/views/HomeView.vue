<template>
  <main class="home">
    <section class="hero">
      <h1>欢迎使用 InfinitePro 工具集</h1>
      <p>面向文本处理、图片工具、数据转换等高频场景，提供即开即用的在线工具。</p>
    </section>
    <section class="features">
      <div class="feature">
        <h3>文本处理</h3>
        <p>格式化、清洗、编码/解码等常用文本操作。</p>
        <RouterLink to="/features/text-processing" class="link">前往</RouterLink>
      </div>
      <div class="feature">
        <h3>图片工具</h3>
        <p>压缩、裁剪、格式转换等图片相关处理。</p>
        <RouterLink to="/features/image-tools" class="link">前往</RouterLink>
      </div>
      <div class="feature">
        <h3>数据转换</h3>
        <p>JSON、CSV、YAML 等格式之间的相互转换。</p>
        <RouterLink to="/features/data-conversion" class="link">前往</RouterLink>
      </div>
    </section>
  </main>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<style scoped>
.home { padding: 2rem 1rem; max-width: 1200px; margin: 0 auto; }
.hero { text-align: center; margin-bottom: 2rem; }
.features { display: grid; gap: 1rem; grid-template-columns: 1fr; }
.feature { border: 1px solid var(--color-border); padding: 1rem; border-radius: 8px; background: var(--color-background); }
.feature h3 { margin: 0 0 0.5rem 0; }
.link { display: inline-block; margin-top: 0.5rem; text-decoration: none; color: var(--color-text); border: 1px solid var(--color-border); padding: 0.25rem 0.75rem; border-radius: 4px; }
.link:hover { background: var(--color-background-soft); }
@media (min-width: 768px) { .features { grid-template-columns: repeat(3, 1fr); } }
</style>
