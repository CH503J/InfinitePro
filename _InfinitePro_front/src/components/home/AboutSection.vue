<template>
  <section id="about" class="about-section">
    <div class="about-content">
      <div class="about-text">
        <h3 class="section-title">关于 InfinitePro</h3>
        <p class="about-description">
          InfinitePro
          是一个集成多种实用工具的在线平台，致力于为用户提供便捷、高效的工具服务。我们不断优化用户体验，持续添加新的功能模块，让您的工作和生活更加便利。
        </p>
        <div class="stats">
          <div class="stat-item">
            <div class="stat-number">10+</div>
            <div class="stat-label">实用工具</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">1000+</div>
            <div class="stat-label">用户使用</div>
          </div>
          <div class="stat-item">
            <div class="stat-number">99%</div>
            <div class="stat-label">满意度</div>
          </div>
        </div>
      </div>
      <div class="about-visual">
        <div class="visual-element"></div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts"></script>

<style scoped>
.about-section {
  padding: 4rem 2rem;
}
.about-content {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
  align-items: center;
}
.about-description {
  font-size: 1.1rem;
  line-height: 1.8;
  margin-bottom: 2rem;
  opacity: 0.9;
}
.stats {
  display: flex;
  gap: 2rem;
}
.stat-item {
  text-align: center;
}
.stat-number {
  font-size: 2.5rem;
  font-weight: bold;
  color: var(--primary-color);
}
.stat-label {
  font-size: 0.9rem;
  opacity: 0.8;
}
.about-visual {
  height: 300px;
  background: var(--surface-color);
  border: 1px solid var(--border-color);
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.visual-element {
  width: 100px;
  height: 100px;
  background: var(--primary-color);
  border-radius: 50%;
  animation: pulse 2s ease-in-out infinite;
}
@keyframes pulse {
  0%,
  100% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.1);
  }
}
</style>


