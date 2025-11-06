<template>
  <div class="accent-center">
    <h1>Accent Center</h1>
    <p>欢迎来到 Accent Center 页面！</p>
    <button @click="goBack">返回首页</button>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

const goBack = () => {
  router.push('/home')
}
</script>

<style scoped>
.accent-center {
  padding: 80px 20px 20px;
  text-align: center;
}

.accent-center h1 {
  font-size: 2rem;
  margin-bottom: 1rem;
  color: var(--color-text);
}

.accent-center p {
  font-size: 1.2rem;
  margin-bottom: 2rem;
  color: var(--color-text-muted);
}

button {
  padding: 10px 20px;
  background-color: var(--color-primary);
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
}

button:hover {
  opacity: 0.9;
}
</style>
