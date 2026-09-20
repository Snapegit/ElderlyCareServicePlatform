import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import laorenList from '@/views/pages/laoren/list'
import laorenDetail from '@/views/pages/laoren/formModel'
import laorenAdd from '@/views/pages/laoren/formAdd'
import laorenRegister from '@/views/pages/laoren/register'
import laorenCenter from '@/views/pages/laoren/center'
import jianhurenList from '@/views/pages/jianhuren/list'
import jianhurenDetail from '@/views/pages/jianhuren/formModel'
import jianhurenAdd from '@/views/pages/jianhuren/formAdd'
import jianhurenRegister from '@/views/pages/jianhuren/register'
import jianhurenCenter from '@/views/pages/jianhuren/center'
import zhiyuanzheList from '@/views/pages/zhiyuanzhe/list'
import zhiyuanzheDetail from '@/views/pages/zhiyuanzhe/formModel'
import zhiyuanzheAdd from '@/views/pages/zhiyuanzhe/formAdd'
import jiankangkepuList from '@/views/pages/jiankangkepu/list'
import jiankangkepuDetail from '@/views/pages/jiankangkepu/formModel'
import jiankangkepuAdd from '@/views/pages/jiankangkepu/formAdd'
import jiankangshujuList from '@/views/pages/jiankangshuju/list'
import jiankangshujuDetail from '@/views/pages/jiankangshuju/formModel'
import jiankangshujuAdd from '@/views/pages/jiankangshuju/formAdd'
import jiankangxinxiList from '@/views/pages/jiankangxinxi/list'
import jiankangxinxiDetail from '@/views/pages/jiankangxinxi/formModel'
import jiankangxinxiAdd from '@/views/pages/jiankangxinxi/formAdd'
import fuwuleixingList from '@/views/pages/fuwuleixing/list'
import fuwuleixingDetail from '@/views/pages/fuwuleixing/formModel'
import fuwuleixingAdd from '@/views/pages/fuwuleixing/formAdd'
import fuwuxinxiList from '@/views/pages/fuwuxinxi/list'
import fuwuxinxiDetail from '@/views/pages/fuwuxinxi/formModel'
import fuwuxinxiAdd from '@/views/pages/fuwuxinxi/formAdd'
import fuwuyuyueList from '@/views/pages/fuwuyuyue/list'
import fuwuyuyueDetail from '@/views/pages/fuwuyuyue/formModel'
import fuwuyuyueAdd from '@/views/pages/fuwuyuyue/formAdd'
import yuyuequxiaoList from '@/views/pages/yuyuequxiao/list'
import yuyuequxiaoDetail from '@/views/pages/yuyuequxiao/formModel'
import yuyuequxiaoAdd from '@/views/pages/yuyuequxiao/formAdd'
import fuwufenpaiList from '@/views/pages/fuwufenpai/list'
import fuwufenpaiDetail from '@/views/pages/fuwufenpai/formModel'
import fuwufenpaiAdd from '@/views/pages/fuwufenpai/formAdd'
import fuwujiluList from '@/views/pages/fuwujilu/list'
import fuwujiluDetail from '@/views/pages/fuwujilu/formModel'
import fuwujiluAdd from '@/views/pages/fuwujilu/formAdd'
import huodongxinxiList from '@/views/pages/huodongxinxi/list'
import huodongxinxiDetail from '@/views/pages/huodongxinxi/formModel'
import huodongxinxiAdd from '@/views/pages/huodongxinxi/formAdd'
import huodongquyuList from '@/views/pages/huodongquyu/list'
import huodongquyuDetail from '@/views/pages/huodongquyu/formModel'
import huodongquyuAdd from '@/views/pages/huodongquyu/formAdd'
import tixinggongnengList from '@/views/pages/tixinggongneng/list'
import tixinggongnengDetail from '@/views/pages/tixinggongneng/formModel'
import tixinggongnengAdd from '@/views/pages/tixinggongneng/formAdd'
import menuList from '@/views/pages/menu/list'
import menuDetail from '@/views/pages/menu/formModel'
import menuAdd from '@/views/pages/menu/formAdd'
import discussfuwujiluList from '@/views/pages/discussfuwujilu/list'
import discussfuwujiluDetail from '@/views/pages/discussfuwujilu/formModel'
import discussfuwujiluAdd from '@/views/pages/discussfuwujilu/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'laorenList',
			component: laorenList
		}, {
			path: 'laorenDetail',
			component: laorenDetail
		}, {
			path: 'laorenAdd',
			component: laorenAdd
		}
		, {
			path: 'laorenCenter',
			component: laorenCenter
		}
		, {
			path: 'jianhurenList',
			component: jianhurenList
		}, {
			path: 'jianhurenDetail',
			component: jianhurenDetail
		}, {
			path: 'jianhurenAdd',
			component: jianhurenAdd
		}
		, {
			path: 'jianhurenCenter',
			component: jianhurenCenter
		}
		, {
			path: 'zhiyuanzheList',
			component: zhiyuanzheList
		}, {
			path: 'zhiyuanzheDetail',
			component: zhiyuanzheDetail
		}, {
			path: 'zhiyuanzheAdd',
			component: zhiyuanzheAdd
		}
		, {
			path: 'jiankangkepuList',
			component: jiankangkepuList
		}, {
			path: 'jiankangkepuDetail',
			component: jiankangkepuDetail
		}, {
			path: 'jiankangkepuAdd',
			component: jiankangkepuAdd
		}
		, {
			path: 'jiankangshujuList',
			component: jiankangshujuList
		}, {
			path: 'jiankangshujuDetail',
			component: jiankangshujuDetail
		}, {
			path: 'jiankangshujuAdd',
			component: jiankangshujuAdd
		}
		, {
			path: 'jiankangxinxiList',
			component: jiankangxinxiList
		}, {
			path: 'jiankangxinxiDetail',
			component: jiankangxinxiDetail
		}, {
			path: 'jiankangxinxiAdd',
			component: jiankangxinxiAdd
		}
		, {
			path: 'fuwuleixingList',
			component: fuwuleixingList
		}, {
			path: 'fuwuleixingDetail',
			component: fuwuleixingDetail
		}, {
			path: 'fuwuleixingAdd',
			component: fuwuleixingAdd
		}
		, {
			path: 'fuwuxinxiList',
			component: fuwuxinxiList
		}, {
			path: 'fuwuxinxiDetail',
			component: fuwuxinxiDetail
		}, {
			path: 'fuwuxinxiAdd',
			component: fuwuxinxiAdd
		}
		, {
			path: 'fuwuyuyueList',
			component: fuwuyuyueList
		}, {
			path: 'fuwuyuyueDetail',
			component: fuwuyuyueDetail
		}, {
			path: 'fuwuyuyueAdd',
			component: fuwuyuyueAdd
		}
		, {
			path: 'yuyuequxiaoList',
			component: yuyuequxiaoList
		}, {
			path: 'yuyuequxiaoDetail',
			component: yuyuequxiaoDetail
		}, {
			path: 'yuyuequxiaoAdd',
			component: yuyuequxiaoAdd
		}
		, {
			path: 'fuwufenpaiList',
			component: fuwufenpaiList
		}, {
			path: 'fuwufenpaiDetail',
			component: fuwufenpaiDetail
		}, {
			path: 'fuwufenpaiAdd',
			component: fuwufenpaiAdd
		}
		, {
			path: 'fuwujiluList',
			component: fuwujiluList
		}, {
			path: 'fuwujiluDetail',
			component: fuwujiluDetail
		}, {
			path: 'fuwujiluAdd',
			component: fuwujiluAdd
		}
		, {
			path: 'huodongxinxiList',
			component: huodongxinxiList
		}, {
			path: 'huodongxinxiDetail',
			component: huodongxinxiDetail
		}, {
			path: 'huodongxinxiAdd',
			component: huodongxinxiAdd
		}
		, {
			path: 'huodongquyuList',
			component: huodongquyuList
		}, {
			path: 'huodongquyuDetail',
			component: huodongquyuDetail
		}, {
			path: 'huodongquyuAdd',
			component: huodongquyuAdd
		}
		, {
			path: 'tixinggongnengList',
			component: tixinggongnengList
		}, {
			path: 'tixinggongnengDetail',
			component: tixinggongnengDetail
		}, {
			path: 'tixinggongnengAdd',
			component: tixinggongnengAdd
		}
		, {
			path: 'menuList',
			component: menuList
		}, {
			path: 'menuDetail',
			component: menuDetail
		}, {
			path: 'menuAdd',
			component: menuAdd
		}
		, {
			path: 'discussfuwujiluList',
			component: discussfuwujiluList
		}, {
			path: 'discussfuwujiluDetail',
			component: discussfuwujiluDetail
		}, {
			path: 'discussfuwujiluAdd',
			component: discussfuwujiluAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/laorenRegister',
		component: laorenRegister
	}
	,{
		path: '/jianhurenRegister',
		component: jianhurenRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
