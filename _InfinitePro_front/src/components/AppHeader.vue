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
    </div>
  </header>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

const goToHome = () => {
  router.push('/')
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
  max-width: 1200px;
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
</style>