<template>
  <header class="header">
    <div class="nav-container">
      <div class="logo"><h1>InfinitePro</h1></div>
      <nav class="nav-menu">
        <a href="#features" class="nav-link">功能</a>
        <a href="#about" class="nav-link">关于</a>
        <a href="#contact" class="nav-link">联系</a>
      </nav>
    </div>
  </header>
</template>

<script setup lang="ts"></script>

<style scoped>
.header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background: var(--surface-2-color);
  backdrop-filter: blur(8px);
  z-index: 1000;
  padding: 1rem 0;
  border-bottom: 1px solid var(--border-color);
}
.nav-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 2rem;
}
.logo h1 {
  margin: 0;
  font-size: 1.5rem;
  font-weight: bold;
}
.nav-menu {
  display: flex;
  gap: 2rem;
}
.nav-link {
  color: var(--text-color);
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s ease;
}
.nav-link:hover {
  color: var(--primary-color);
}
</style>


