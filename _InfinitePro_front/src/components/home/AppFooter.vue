<template>
  <footer class="footer">
    <div class="footer-content">
      <div class="footer-section">
        <h4>InfinitePro</h4>
        <p>让工具更简单，让工作更高效</p>
      </div>
      <div class="footer-section">
        <h4>快速链接</h4>
        <ul>
          <li><a href="#features">功能</a></li>
          <li><a href="#about">关于</a></li>
          <li><a href="#contact">联系</a></li>
        </ul>
      </div>
      <div class="footer-section">
        <h4>联系方式</h4>
        <p>邮箱: contact@infinitepro.com</p>
        <p>电话: 400-123-4567</p>
      </div>
    </div>
    <div class="footer-bottom">
      <p>&copy; 2025 InfinitePro. 保留所有权利。</p>
    </div>
  </footer>
</template>

<script setup lang="ts"></script>

<style scoped>
.footer {
  background: var(--surface-2-color);
  padding: 3rem 2rem 1rem;
}
.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
}
.footer-section h4 {
  margin-bottom: 1rem;
  color: var(--text-color);
}
.footer-section ul {
  list-style: none;
  padding: 0;
}
.footer-section ul li {
  margin-bottom: 0.5rem;
}
.footer-section a {
  color: var(--text-color);
  text-decoration: none;
  opacity: 0.8;
  transition: opacity 0.3s ease;
}
.footer-section a:hover {
  opacity: 1;
}
.footer-bottom {
  text-align: center;
  margin-top: 2rem;
  padding-top: 2rem;
  border-top: 1px solid var(--border-color);
  opacity: 0.7;
}
</style>


