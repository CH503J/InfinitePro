# 全局组件说明

在这个项目中，我们创建了几个全局组件，可以在任何 Vue 组件中直接使用，无需额外导入。

## 组件列表

### 1. Header (页头导航栏)
```vue
<Header />
```
这个组件包含了网站的主要导航链接和颜色切换器。

### 2. ColorSwitcher (颜色切换器)
```vue
<ColorSwitcher />
```
允许用户在浅色和深色主题之间切换。用户的偏好设置会保存在本地存储中。

### 3. TheFooter (页脚)
```vue
<TheFooter />
```
包含了版权信息和相关链接。

## 使用方法

这些组件已经在 [main.ts](file:///C:/Develop/Projects/InfinitePro/_InfinitePro_front/src/main.ts) 中注册为全局组件，因此可以直接在任何组件的模板中使用，无需额外导入。

例如，在任何 `.vue` 文件中：
```vue
<template>
  <div>
    <Header />
    <!-- 页面内容 -->
    <TheFooter />
  </div>
</template>
```

## 自定义

每个组件都可以根据需要进行样式和功能的修改。组件文件位于 [src/components](file:///C:/Develop/Projects/InfinitePro/_InfinitePro_front/src/components) 目录中。