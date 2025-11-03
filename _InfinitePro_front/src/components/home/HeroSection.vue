<template>
  <section class="hero-section">
    <div class="hero-content">
      <h2 class="hero-title">欢迎来到 <span class="highlight">InfinitePro</span></h2>
      <p class="hero-subtitle">一站式工具集合平台，为您提供高效便捷的在线工具服务</p>
      <div class="hero-buttons">
        <button class="btn btn-primary" @click="$emit('to-features')">开始使用</button>
        <button class="btn btn-secondary" @click="$emit('to-about')">了解更多</button>
      </div>
    </div>
    <div class="hero-visual">
      <div class="floating-card">
        <div class="card-icon">🛠️</div>
        <div class="card-text">工具集合</div>
      </div>
      <div class="floating-card">
        <div class="card-icon">⚡</div>
        <div class="card-text">快速高效</div>
      </div>
      <div class="floating-card">
        <div class="card-icon">🎯</div>
        <div class="card-text">精准实用</div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
defineEmits<{ (e: 'to-features'): void; (e: 'to-about'): void }>()
</script>

<style scoped>
.hero-section {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 2rem;
  max-width: 1200px;
  margin: 0 auto;
}
.hero-content {
  flex: 1;
  max-width: 600px;
}
.hero-title {
  font-size: 3.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
  line-height: 1.2;
}
.highlight {
  color: var(--primary-color);
}
.hero-subtitle {
  font-size: 1.2rem;
  margin-bottom: 2rem;
  opacity: 0.9;
  line-height: 1.6;
}
.hero-buttons {
  display: flex;
  gap: 1rem;
}
.btn {
  padding: 0.75rem 2rem;
  border: none;
  border-radius: 50px;
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}
.btn-primary {
  background: var(--primary-color);
  color: var(--primary-contrast);
}
.btn-primary:hover {
  filter: brightness(1.1);
  transform: translateY(-2px);
}
.btn-secondary {
  background: transparent;
  color: var(--text-color);
  border: 1px solid var(--border-color);
}
.btn-secondary:hover {
  background: var(--surface-color);
  color: var(--text-color);
}
.hero-visual {
  flex: 1;
  position: relative;
  height: 400px;
}
.floating-card {
  position: absolute;
  background: var(--surface-color);
  border: 1px solid var(--border-color);
  box-shadow: 0 4px 16px var(--overlay-color);
  backdrop-filter: blur(8px);
  border-radius: 20px;
  padding: 1.5rem;
  text-align: center;
  animation: float 6s ease-in-out infinite;
}
.floating-card:nth-child(1) {
  top: 20%;
  left: 20%;
  animation-delay: 0s;
}
.floating-card:nth-child(2) {
  top: 50%;
  right: 20%;
  animation-delay: 2s;
}
.floating-card:nth-child(3) {
  bottom: 20%;
  left: 50%;
  animation-delay: 4s;
}
.card-icon {
  font-size: 2rem;
  margin-bottom: 0.5rem;
}
.card-text {
  font-weight: 600;
}
@keyframes float {
  0%,
  100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-20px);
  }
}
</style>


