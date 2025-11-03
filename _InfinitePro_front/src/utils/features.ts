export interface Feature {
  id: number
  icon: string
  title: string
  description: string
}

export const defaultFeatures: Feature[] = [
  {
    id: 1,
    icon: '📝',
    title: '文本处理',
    description: '提供文本格式化、编码转换、字数统计等实用功能',
  },
  { id: 2, icon: '🖼️', title: '图片工具', description: '支持图片压缩、格式转换、尺寸调整等操作' },
  { id: 3, icon: '🔐', title: '加密解密', description: '提供多种加密算法，保护您的数据安全' },
  { id: 4, icon: '📊', title: '数据转换', description: 'JSON格式化、XML转换、CSV处理等数据工具' },
  { id: 5, icon: '🌐', title: '网络工具', description: 'IP查询、域名解析、网络检测等网络相关功能' },
  {
    id: 6,
    icon: '⚙️',
    title: '开发工具',
    description: '代码格式化、正则测试、API调试等开发者工具',
  },
]


