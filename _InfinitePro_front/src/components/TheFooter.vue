<template>
  <footer>
    <div class="footer-content">
      <p>&copy; {{ new Date().getFullYear() }} My Application. All rights reserved.</p>
      <div class="footer-links">
        <RouterLink to="/about">About</RouterLink>
        <a href="#" @click.prevent="showPrivacy">Privacy Policy</a>
        <a href="#" @click.prevent="showTerms">Terms of Service</a>
      </div>
    </div>
  </footer>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'

const showPrivacy = () => {
  alert('Privacy Policy information would be shown here.')
}

const showTerms = () => {
  alert('Terms of Service would be shown here.')
}
</script>

<style scoped>
footer {
  margin-top: auto;
  padding: 2rem;
  background-color: var(--color-background-soft);
  border-top: 1px solid var(--color-border);
  text-align: center;
}

.footer-content {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.footer-links {
  display: flex;
  justify-content: center;
  gap: 1.5rem;
}

.footer-links a {
  color: var(--color-text);
  text-decoration: none;
}

.footer-links a:hover {
  color: var(--vt-c-text-light-2);
}

@media (min-width: 768px) {
  .footer-content {
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
  }
}
</style>