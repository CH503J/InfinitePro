<script setup lang="ts">
// 首页组件 - 不需要额外的逻辑
</script>

<template>
  <div class="home-view">
    <div class="section home-section">
      <h1>InfinitePro</h1>
      <p>迎来无限可能</p>
      <div class="scroll-indicator">
        <span>了解更多</span>
      </div>
    </div>

    <div class="about-section">
      <!-- 第一行：Logo -->
      <div class="about-logo">
        <img src="@/assets/infinitePro-logo.png" alt="InfinitePro Logo" class="logo" />
      </div>

      <!-- 第二行：简介内容和链接 -->
      <div class="about-content">
        <div class="description">
          <p>实战中进步，厚积薄发，总有一天迎来无限可能。</p>
        </div>
        <div class="links">
          <a href="https://github.com" target="_blank" rel="noopener">GitHub</a>
          <a href="mailto:example@infinitepro.com">Email</a>
        </div>
      </div>

      <!-- 第三行：版权信息 -->
      <div class="copyright">
        <p>&copy; 2025 InfinitePro. 保留所有权利。</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.home-view {
  padding: 80px 20px 20px;
  min-height: 100vh;
  scroll-behavior: smooth;
}

.section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 20px;
  box-sizing: border-box;
}

.home-section {
  min-height: 90vh;
  position: relative;
}

.about-section {
  padding: 20px;
  margin: 0 auto;
}

.about-logo {
  margin-bottom: 15px;
}

.about-logo .logo {
  height: 40px;
  width: auto;
  display: block;
}

.about-content {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
  gap: 20px;
  margin-bottom: 15px;
}

.description {
  flex: 1;
  min-width: 300px;
}

.description p {
  margin: 0;
  line-height: 1.5;
  font-size: 15px;
}

.links {
  display: flex;
  gap: 15px;
  flex-wrap: wrap;
}

.links a {
  display: inline-block;
  padding: 6px 12px;
  border: 1px solid var(--color-border);
  border-radius: 4px;
  text-decoration: none;
  color: var(--color-text);
  transition: all 0.3s ease;
  font-size: 14px;
}

.links a:hover {
  background-color: var(--color-background-mute);
  border-color: var(--color-border-hover);
}

.copyright {
  text-align: center;
  color: var(--color-text);
  font-size: 13px;
  padding-top: 15px;
  border-top: 1px solid var(--color-border);
  opacity: 0.8;
}

.scroll-indicator {
  position: absolute;
  bottom: 40px;
  animation: bounce 2s infinite;
}

@keyframes bounce {
  0%, 20%, 50%, 80%, 100% {
    transform: translateY(0);
  }
  40% {
    transform: translateY(-20px);
  }
  60% {
    transform: translateY(-10px);
  }
}

.scroll-indicator span {
  font-size: 14px;
  opacity: 0.7;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .about-content {
    flex-direction: column;
  }

  .description {
    min-width: auto;
  }

  .links {
    justify-content: flex-start;
  }
}
</style>
