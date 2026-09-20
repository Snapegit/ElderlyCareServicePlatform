const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '健康科普管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'健康科普',
							url:'/index/jiankangkepuList'
						},
					]
				},
				{
					name: '活动信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'活动信息',
							url:'/index/huodongxinxiList'
						},
					]
				},
				{
					name: '服务信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'服务信息',
							url:'/index/fuwuxinxiList'
						},
					]
				},
				{
					name: '服务记录管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'服务记录',
							url:'/index/fuwujiluList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于Spring Boot的爱老助老服务平台"
        } 
    }
}
export default config
