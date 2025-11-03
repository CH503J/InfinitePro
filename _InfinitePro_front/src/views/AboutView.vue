<template>
  <section class="page-section">
    <div class="section-header">
      <h3 class="section-title">关于 InfinitePro</h3>
      <p class="section-subtitle">持续演进的一站式在线工具集</p>
    </div>
    <div class="content-grid">
      <div class="text">
        <p>
          InfinitePro 是对既有工具体系的全面升级，基于清晰的模块化与一致的设计语言，提供更高效的使用体验与更友好的交互。
        </p>
        <ul class="list">
          <li>统一设计语言与暗/亮主题</li>
          <li>模块化功能区与可扩展导航</li>
          <li>性能优化与更流畅的动画过渡</li>
        </ul>
      </div>
      <div class="visual"></div>
    </div>
  </section>
</template>

<style scoped>
.page-section { padding: 4rem 2rem; background: var(--surface-2-color); }
.section-header { text-align: center; margin-bottom: 3rem; }
.section-title { font-size: 2rem; font-weight: 700; margin: 0 0 0.5rem 0; }
.section-subtitle { opacity: 0.8; margin: 0; }
.content-grid { max-width: 1200px; margin: 0 auto; display: grid; grid-template-columns: 1fr 1fr; gap: 2rem; align-items: center; }
.text { line-height: 1.8; }
.list { margin: 1rem 0 0 1rem; }
.visual { height: 260px; border-radius: 16px; border: 1px solid var(--border-color); background: var(--surface-color); }
@media (max-width: 960px) { .content-grid { grid-template-columns: 1fr; } }
</style>
