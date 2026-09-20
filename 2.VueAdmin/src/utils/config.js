const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/cl3973433/front/index.html'
        }
    },
    getProjectName(){
        return {
            projectName: "基于Spring Boot的爱老助老服务平台"
        } 
    }
}
export default config
