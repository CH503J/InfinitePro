<template>
  <header class="site-header">
    <div class="wrapper">
      <div class="brand">
        <RouterLink to="/home" class="brand-link">
          <img class="brand-logo" src="@/assets/brand-logo.svg" alt="Project Logo" />
        </RouterLink>
      </div>
      <nav class="nav">
        <div class="nav-item">
          <RouterLink to="/home" class="nav-link">首页</RouterLink>
        </div>
        <div class="nav-item nav-dropdown">
          <span class="nav-link">功能</span>
          <div class="dropdown">
            <RouterLink class="dropdown-link" to="/features/text-processing">文本处理</RouterLink>
            <RouterLink class="dropdown-link" to="/features/image-tools">图片工具</RouterLink>
            <RouterLink class="dropdown-link" to="/features/data-conversion">数据转换</RouterLink>
          </div>
        </div>
        <div class="nav-item nav-disabled" title="暂未开放下拉">
          <span class="nav-link">关于</span>
        </div>
      </nav>
      <div class="actions">
        <ColorSwitcher />
      </div>
    </div>
  </header>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
import ColorSwitcher from './ColorSwitcher.vue'
</script>

<style scoped>
.site-header {
  position: sticky;
  top: 0;
  z-index: 100;
  background: var(--color-background);
  border-bottom: 1px solid var(--color-border);
}

.wrapper {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  padding: 0.5rem 1rem;
  gap: 1rem;
}

.brand-link {
  display: inline-flex;
  align-items: center;
}

.brand-logo {
  width: 120px;
  height: 32px;
  object-fit: contain;
}

.nav {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-left: 1rem;
}

.nav-item {
  position: relative;
}

.nav-link {
  display: inline-block;
  padding: 0.5rem 0.75rem;
  color: var(--color-text);
  text-decoration: none;
  cursor: pointer;
}

.nav-dropdown:hover .dropdown {
  display: block;
}

.dropdown {
  display: none;
  position: absolute;
  top: 100%;
  left: 0;
  min-width: 160px;
  background: var(--color-background);
  border: 1px solid var(--color-border);
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
}

.dropdown-link {
  display: block;
  padding: 0.5rem 0.75rem;
  color: var(--color-text);
  text-decoration: none;
  white-space: nowrap;
}

.dropdown-link:hover {
  background: var(--color-background-soft);
}

.actions {
  margin-left: auto;
}

.nav-disabled .nav-link {
  opacity: 0.8;
}
</style>