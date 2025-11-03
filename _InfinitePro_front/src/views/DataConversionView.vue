<template>
  <section class="page-section">
    <div class="section-header">
      <h3 class="section-title">数据转换</h3>
      <p class="section-subtitle">JSON/CSV/YAML 等格式双向转换</p>
    </div>
    <div class="tools-grid">
      <div class="tool-card placeholder">即将上线：JSON 格式化</div>
      <div class="tool-card placeholder">即将上线：CSV ↔ JSON</div>
      <div class="tool-card placeholder">即将上线：YAML ↔ JSON</div>
    </div>
  </section>
</template>

<style scoped>
.page-section { padding: 4rem 2rem; }
.section-header { text-align: center; margin-bottom: 2rem; }
.section-title { font-size: 2rem; font-weight: 700; margin: 0 0 0.5rem 0; }
.section-subtitle { opacity: 0.8; margin: 0; }
.tools-grid { max-width: 1200px; margin: 0 auto; display: grid; grid-template-columns: repeat(auto-fit, minmax(260px, 1fr)); gap: 1.5rem; }
.tool-card { border: 1px solid var(--border-color); background: var(--surface-color); border-radius: 16px; padding: 1.25rem; }
.placeholder { color: var(--muted-text-color); }
</style>

