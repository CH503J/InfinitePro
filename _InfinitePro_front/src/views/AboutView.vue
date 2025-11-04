<script setup lang="ts">
import {ref} from 'vue'
import {
  NCard,
  NSelect,
  NDatePicker,
  NTimePicker,
  NRate,
  NColorPicker,
  NLayout,
  NLayoutContent
} from 'naive-ui'

const selectedValue = ref(null)
const dateValue = ref(null)
const timeValue = ref(null)
const rateValue = ref(3)
const colorValue = ref('#18a058')

const options = [
  {label: '选项1', value: 1},
  {label: '选项2', value: 2},
  {label: '选项3', value: 3}
]
</script>

<template>
  <NLayout>
    <NLayoutContent style="padding: 20px;">
      <NCard title="更多 Naive UI 组件示例">
        <div style="display: flex; flex-direction: column; gap: 20px;">
          <div>
            <h2>选择器组件</h2>
            <NSelect v-model:value="selectedValue" :options="options" placeholder="请选择"/>
            <p>选中的值: {{ selectedValue }}</p>
          </div>

          <div>
            <h2>日期选择器</h2>
            <NDatePicker v-model:value="dateValue"/>
          </div>

          <div>
            <h2>时间选择器</h2>
            <NTimePicker v-model:value="timeValue"/>
          </div>

          <div>
            <h2>评分组件</h2>
            <NRate v-model:value="rateValue"/>
          </div>

          <div>
            <h2>颜色选择器</h2>
            <NColorPicker v-model:value="colorValue"/>
          </div>
        </div>
      </NCard>
    </NLayoutContent>
  </NLayout>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
