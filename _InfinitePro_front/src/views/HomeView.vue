<script setup lang="ts">
import {ref} from 'vue'
import {NButton, NCard, NSwitch, NInput, NFormItem, NLayout, NLayoutContent} from 'naive-ui'

const count = ref(0)
const inputValue = ref('')
const switchValue = ref(false)
</script>

<template>
  <div class="home-view">
    <h1>首页</h1>
    <p>欢迎来到 InfinitePro 项目!</p>
  </div>
</template>

<style scoped>
.home-view {
  padding: 20px;
}
</style>
