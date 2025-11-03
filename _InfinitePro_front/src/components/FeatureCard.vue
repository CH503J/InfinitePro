<template>
  <div class="feature-card">
    <div class="feature-icon">{{ feature.icon }}</div>
    <h4 class="feature-title">{{ feature.title }}</h4>
    <p class="feature-description">{{ feature.description }}</p>
    <button class="feature-btn" @click="$emit('click', feature)">立即使用</button>
  </div>
</template>

<script setup lang="ts">
import type { Feature } from '@/utils/features'

defineProps<{ feature: Feature }>()
defineEmits<{ (e: 'click', feature: Feature): void }>()
</script>

<style scoped>
.feature-card {
  background: var(--surface-color);
  border: 1px solid var(--border-color);
  box-shadow: 0 4px 16px var(--overlay-color);
  backdrop-filter: blur(8px);
  border-radius: 20px;
  padding: 2rem;
  text-align: center;
  transition: transform 0.3s ease;
}

.feature-card:hover {
  transform: translateY(-10px);
}

.feature-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
}

.feature-title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

.feature-description {
  margin-bottom: 1.5rem;
  opacity: 0.9;
  line-height: 1.6;
}

.feature-btn {
  background: var(--primary-color);
  color: var(--primary-contrast);
  border: none;
  padding: 0.75rem 1.5rem;
  border-radius: 25px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.feature-btn:hover {
  filter: brightness(1.1);
  transform: scale(1.05);
}
</style>


