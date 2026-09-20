	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import huodongquyu from '@/views/huodongquyu/list'
	import jiankangshuju from '@/views/jiankangshuju/list'
	import fuwuxinxi from '@/views/fuwuxinxi/list'
	import huodongxinxi from '@/views/huodongxinxi/list'
	import yuyuequxiao from '@/views/yuyuequxiao/list'
	import users from '@/views/users/list'
	import fuwuleixing from '@/views/fuwuleixing/list'
	import jiankangxinxi from '@/views/jiankangxinxi/list'
	import jianhuren from '@/views/jianhuren/list'
	import fuwujilu from '@/views/fuwujilu/list'
	import discussfuwujilu from '@/views/discussfuwujilu/list'
	import fuwufenpai from '@/views/fuwufenpai/list'
	import laoren from '@/views/laoren/list'
	import tixinggongneng from '@/views/tixinggongneng/list'
	import fuwuyuyue from '@/views/fuwuyuyue/list'
	import config from '@/views/config/list'
	import jiankangkepu from '@/views/jiankangkepu/list'
	import zhiyuanzhe from '@/views/zhiyuanzhe/list'
	import zhiyuanzheRegister from '@/views/zhiyuanzhe/register'
	import zhiyuanzheCenter from '@/views/zhiyuanzhe/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页Home',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/zhiyuanzheCenter',
			name: '志愿者个人中心',
			component: zhiyuanzheCenter
		}
		,{
			path: '/huodongquyu',
			name: '活动区域',
			component: huodongquyu
		}
		,{
			path: '/jiankangshuju',
			name: '健康数据',
			component: jiankangshuju
		}
		,{
			path: '/fuwuxinxi',
			name: '服务信息',
			component: fuwuxinxi
		}
		,{
			path: '/huodongxinxi',
			name: '活动信息',
			component: huodongxinxi
		}
		,{
			path: '/yuyuequxiao',
			name: '预约取消',
			component: yuyuequxiao
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/fuwuleixing',
			name: '服务类型',
			component: fuwuleixing
		}
		,{
			path: '/jiankangxinxi',
			name: '健康信息',
			component: jiankangxinxi
		}
		,{
			path: '/jianhuren',
			name: '监护人',
			component: jianhuren
		}
		,{
			path: '/fuwujilu',
			name: '服务记录',
			component: fuwujilu
		}
		,{
			path: '/discussfuwujilu',
			name: '服务记录评论',
			component: discussfuwujilu
		}
		,{
			path: '/fuwufenpai',
			name: '服务分派',
			component: fuwufenpai
		}
		,{
			path: '/laoren',
			name: '老人',
			component: laoren
		}
		,{
			path: '/tixinggongneng',
			name: '提醒功能',
			component: tixinggongneng
		}
		,{
			path: '/fuwuyuyue',
			name: '服务预约',
			component: fuwuyuyue
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/jiankangkepu',
			name: '健康科普',
			component: jiankangkepu
		}
		,{
			path: '/zhiyuanzhe',
			name: '志愿者',
			component: zhiyuanzhe
		}
		]
	},
	{
		path: '/zhiyuanzheRegister',
		name: '志愿者注册',
		component: zhiyuanzheRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
