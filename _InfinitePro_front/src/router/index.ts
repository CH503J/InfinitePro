import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/home',
    },
    {
      path: '/home',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/features/text-processing',
      name: 'features-text',
      component: () => import('../views/TextProcessingView.vue'),
    },
    {
      path: '/features/image-tools',
      name: 'features-image',
      component: () => import('../views/ImageToolsView.vue'),
    },
    {
      path: '/features/data-conversion',
      name: 'features-data',
      component: () => import('../views/DataConversionView.vue'),
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue'),
    },
  ],
})

export default router
