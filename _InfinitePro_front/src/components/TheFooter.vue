<template>
  <footer>
    <div class="footer-content">
      <section class="col">
        <h4>网站简介</h4>
        <p>InfinitePro 提供便捷的文本处理、图片工具与数据转换等高效工具集合。</p>
      </section>
      <section class="col">
        <h4>快速链接</h4>
        <nav class="links">
          <RouterLink to="/home">首页</RouterLink>
          <RouterLink to="/features/text-processing">文本处理</RouterLink>
          <RouterLink to="/features/image-tools">图片工具</RouterLink>
          <RouterLink to="/features/data-conversion">数据转换</RouterLink>
          <RouterLink to="/about">关于</RouterLink>
        </nav>
      </section>
      <section class="col">
        <h4>联系</h4>
        <ul class="contact">
          <li>邮箱：contact@example.com</li>
          <li>GitHub：<a href="#" rel="nofollow noopener" target="_blank">即将开放</a></li>
        </ul>
      </section>
    </div>
    <div class="copyright">© {{ new Date().getFullYear() }} InfinitePro</div>
  </footer>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<style scoped>
footer {
  margin-top: auto;
  padding: 2rem 1rem;
  background-color: var(--color-background-soft);
  border-top: 1px solid var(--color-border);
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr;
  gap: 1.5rem;
}

.col h4 { margin: 0 0 0.5rem 0; }
.col p { margin: 0; color: var(--color-text); }

.links { display: grid; gap: 0.25rem; }
.links a { color: var(--color-text); text-decoration: none; }
.links a:hover { color: var(--vt-c-text-light-2); }

.contact { list-style: none; padding: 0; margin: 0; display: grid; gap: 0.25rem; }
.contact a { color: var(--color-text); }

@media (min-width: 768px) {
  .footer-content { grid-template-columns: 2fr 1fr 1fr; }
}

.copyright {
  max-width: 1200px;
  margin: 1rem auto 0;
  text-align: center;
  color: var(--vt-c-text-light-2);
}
</style>