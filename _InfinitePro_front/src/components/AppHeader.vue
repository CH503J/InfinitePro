<template>
  <header class="app-header">
    <div class="header-container">
      <div class="logo-container" @click="goToHome">
        <img
          src="@/assets/infinitePro-logo.png"
          alt="InfinitePro Logo"
          class="logo"
        />
      </div>
      <div class="header-actions">
        <button class="accent-button" @click="goToAccentCenter">个人中心</button>
      </div>
    </div>
  </header>
</template>

<script setup lang="ts">
import {useRouter} from 'vue-router'

const router = useRouter()

// 点击Logo跳转到首页
const goToHome = () => {
  router.push('/home')
}

// 跳转到Accent Center页面
const goToAccentCenter = () => {
  router.push('/accent-center')
}
</script>

<style scoped>
.app-header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  height: 60px;
  background: var(--color-background);
  border-bottom: 1px solid var(--color-border);
  z-index: 999;
  display: flex;
  align-items: center;
  padding: 0 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.header-container {
  width: 100%;
  margin: 0 auto;
  display: flex;
  align-items: center;
}

.logo-container {
  display: flex;
  align-items: center;
  cursor: pointer;
  background: transparent;
  border: none;
  outline: none;
  padding: 0;
  margin: 0;
}

.logo-container:hover,
.logo-container:focus,
.logo-container:active {
  background: transparent;
  border: none;
  outline: none;
  color: inherit;
}

.logo {
  height: 40px;
  width: auto;
  display: block;
}

.header-actions {
  margin-left: auto;
  margin-right: 60px; /* 为避免与主题切换器重叠预留空间 */
  display: flex;
  gap: 10px;
}

.accent-button {
  padding: 8px 16px;
  background-color: var(--color-primary);
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  transition: opacity 0.3s;
}

.accent-button:hover {
  opacity: 0.8;
}
</style>
