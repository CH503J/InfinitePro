<template>
  <section id="features" class="features-section">
    <div class="section-header">
      <h3 class="section-title">核心功能</h3>
      <p class="section-subtitle">我们为您提供多种实用工具</p>
    </div>
    <div class="features-grid">
      <FeatureCard v-for="f in features" :key="f.id" :feature="f" @click="$emit('select', f)" />
    </div>
  </section>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import FeatureCard from '@/components/FeatureCard.vue'
import type { Feature } from '@/utils/features'

const props = defineProps<{ features: Feature[] }>()
defineEmits<{ (e: 'select', feature: Feature): void }>()

// 防御性：保证为数组
const features = computed(() => props.features ?? [])
</script>

<style scoped>
.features-section {
  padding: 4rem 2rem;
  background: var(--surface-2-color);
}
.section-header {
  text-align: center;
  margin-bottom: 3rem;
}
.section-title {
  font-size: 2.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}
.section-subtitle {
  font-size: 1.1rem;
  opacity: 0.8;
}
.features-grid {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
}
</style>


