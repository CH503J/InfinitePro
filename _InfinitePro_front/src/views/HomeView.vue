<template>
  <div class="home-container">
    <main class="main-content">
      <HeroSection @to-features="scrollToFeatures" @to-about="scrollToAbout" />
      <FeaturesSection id="features" :features="features" @select="handleFeatureClick" />
      <AboutSection id="about" />
    </main>
  </div>
  
</template>

<script setup lang="ts">
import { ref } from 'vue'
import HeroSection from '@/components/home/HeroSection.vue'
import FeaturesSection from '@/components/home/FeaturesSection.vue'
import AboutSection from '@/components/home/AboutSection.vue'
import { defaultFeatures, type Feature } from '@/utils/features'

const features = ref<Feature[]>(defaultFeatures)

const scrollToFeatures = () => {
  document.getElementById('features')?.scrollIntoView({ behavior: 'smooth' })
}

const scrollToAbout = () => {
  document.getElementById('about')?.scrollIntoView({ behavior: 'smooth' })
}

const handleFeatureClick = (feature: Feature) => {
  console.log('点击功能:', feature.title)
}
</script>

<style scoped>
.home-container {
  min-height: 100vh;
  background: var(--bg-color);
  color: var(--text-color);
}
.main-content {
  padding-top: 80px;
}
</style>
