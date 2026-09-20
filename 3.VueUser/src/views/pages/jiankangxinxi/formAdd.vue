
<template>
	<div class="app-contain" :style='{"minHeight":"100vh","padding":"0","margin":"20px auto 60px","borderRadius":"0px","background":"#fff","width":"80%","position":"relative","height":"100%"}'>
		<div class="bread_view">
			<el-breadcrumb separator=">" class="breadcrumb">
				<el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
				<el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">{{item.name}}</el-breadcrumb-item>
			</el-breadcrumb>
		</div>
		<el-form ref="formRef" :model="form" class="add_form" label-width="120px" :rules="rules">
			<el-row>
				<el-col :span="8">
					<el-form-item label="老人账号" prop="laorenzhanghao">
						<el-select
							class="list_sel"
							:disabled="!isAdd||disabledForm.laorenzhanghao?true:false"
							v-model="form.laorenzhanghao" 
							placeholder="请选择老人账号"
							style="width:100%;"
							@change="laorenzhanghaoChange">
							<el-option v-for="(item,index) in laorenzhanghaoLists" :label="item" :value="item">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="老人姓名" prop="laorenxingming">
						<el-input class="list_inp" v-model="form.laorenxingming" placeholder="老人姓名"
							 type="text" 							:readonly="!isAdd||disabledForm.laorenxingming?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="性别" prop="xingbie">
						<el-input class="list_inp" v-model="form.xingbie" placeholder="性别"
							 type="text" 							:readonly="!isAdd||disabledForm.xingbie?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="年龄" prop="nianling">
						<el-input class="list_inp" v-model="form.nianling" placeholder="年龄"
							 type="text" 							:readonly="!isAdd||disabledForm.nianling?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="监护人账号" prop="jianhurenzhanghao">
						<el-input class="list_inp" v-model="form.jianhurenzhanghao" placeholder="监护人账号"
							 type="text" 							:readonly="!isAdd||disabledForm.jianhurenzhanghao?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="监护人姓名" prop="jianhurenxingming">
						<el-input class="list_inp" v-model="form.jianhurenxingming" placeholder="监护人姓名"
							 type="text" 							:readonly="!isAdd||disabledForm.jianhurenxingming?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="慢性病" prop="manxingbing">
						<el-input class="list_inp" v-model="form.manxingbing" placeholder="慢性病"
							 type="text" 							:readonly="!isAdd||disabledForm.manxingbing?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="家族病史" prop="jiazubingshi">
						<el-input class="list_inp" v-model="form.jiazubingshi" placeholder="家族病史"
							 type="text" 							:readonly="!isAdd||disabledForm.jiazubingshi?true:false" />
					</el-form-item>
				</el-col>

				<el-col :span="8">
					<el-form-item label="登记时间" prop="dengjishijian">
						<el-date-picker
							class="list_date"
							v-model="form.dengjishijian"
							format="YYYY-MM-DD HH:mm:ss"
							value-format="YYYY-MM-DD HH:mm:ss"
							type="datetime"
							style="width:100%;"
							:readonly="!isAdd||disabledForm.dengjishijian?true:false"
							placeholder="请选择登记时间" />
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item label="健康状况" prop="jiankangzhuangkuang">
						<el-input v-model="form.jiankangzhuangkuang" placeholder="健康状况" type="textarea"
						:readonly="!isAdd||disabledForm.jiankangzhuangkuang?true:false"
						/>
					</el-form-item>
				</el-col>
			</el-row>
			<div class="formModel_btn_box">
				<el-button class="formModel_cancel" @click="backClick">取消</el-button>
				<el-button class="formModel_confirm" @click="save"
					type="success"
					>
					保存
				</el-button>
			</div>
		</el-form>
	</div>
</template>
<script setup>
	import {
		ref,
		getCurrentInstance,
		watch,
		onUnmounted,
		onMounted,
		nextTick,
		computed
	} from 'vue';
	import {
		useRoute,
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const route = useRoute()
	const router = useRouter()
	//基础信息
	const tableName = 'jiankangxinxi'
	const formName = '健康信息'
	//基础信息
	const breadList = ref([{
		name: formName
	}])
	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//form表单
	const form = ref({
		laorenzhanghao: '',
		laorenxingming: '',
		xingbie: '',
		nianling: '',
		jianhurenzhanghao: '',
		jianhurenxingming: '',
		jiankangzhuangkuang: '',
		manxingbing: '',
		jiazubingshi: '',
		dengjishijian: '',
	})
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	const disabledForm = ref({
		laorenzhanghao : false,
		laorenxingming : false,
		xingbie : false,
		nianling : false,
		jianhurenzhanghao : false,
		jianhurenxingming : false,
		jiankangzhuangkuang : false,
		manxingbing : false,
		jiazubingshi : false,
		dengjishijian : false,
	})
	const isAdd = ref(false)
	//表单验证
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		laorenzhanghao: [
		],
		laorenxingming: [
		],
		xingbie: [
		],
		nianling: [
		],
		jianhurenzhanghao: [
		],
		jianhurenxingming: [
		],
		jiankangzhuangkuang: [
		],
		manxingbing: [
		],
		jiazubingshi: [
		],
		dengjishijian: [
		],
	})
	//老人账号列表
	const laorenzhanghaoLists = ref([])
	//methods

	//methods
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init = (formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null) => {
			form.value.dengjishijian = context?.$toolUtil.getCurDateTime()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			getInfo()
		}else if(formType == 'logistics'){
			isAdd.value = false
			getInfo()
		}else if(formType == 'reply'){
			isAdd.value = false
			getInfo()
		}else if(formType == 'cross'){
			isAdd.value = true
			// getInfo()
			for(let x in row){
				if(x=='laorenzhanghao'){
					form.value.laorenzhanghao = row[x];
					disabledForm.value.laorenzhanghao = true;
					continue;
				}
				if(x=='laorenxingming'){
					form.value.laorenxingming = row[x];
					disabledForm.value.laorenxingming = true;
					continue;
				}
				if(x=='xingbie'){
					form.value.xingbie = row[x];
					disabledForm.value.xingbie = true;
					continue;
				}
				if(x=='nianling'){
					form.value.nianling = row[x];
					disabledForm.value.nianling = true;
					continue;
				}
				if(x=='jianhurenzhanghao'){
					form.value.jianhurenzhanghao = row[x];
					disabledForm.value.jianhurenzhanghao = true;
					continue;
				}
				if(x=='jianhurenxingming'){
					form.value.jianhurenxingming = row[x];
					disabledForm.value.jianhurenxingming = true;
					continue;
				}
				if(x=='jiankangzhuangkuang'){
					form.value.jiankangzhuangkuang = row[x];
					disabledForm.value.jiankangzhuangkuang = true;
					continue;
				}
				if(x=='manxingbing'){
					form.value.manxingbing = row[x];
					disabledForm.value.manxingbing = true;
					continue;
				}
				if(x=='jiazubingshi'){
					form.value.jiazubingshi = row[x];
					disabledForm.value.jiazubingshi = true;
					continue;
				}
				if(x=='dengjishijian'){
					form.value.dengjishijian = row[x];
					disabledForm.value.dengjishijian = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
		}
		context?.$http({
			url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
		})
		context?.$http({
			url: `option/laoren/laorenzhanghao`,
			method: 'get'
		}).then(res=>{
			laorenzhanghaoLists.value = res.data.data
		})
		//由上级字段带出不可改
		disabledForm.value.laorenxingming = true;
		//由上级字段带出不可改
		disabledForm.value.xingbie = true;
		//由上级字段带出不可改
		disabledForm.value.nianling = true;
		//由上级字段带出不可改
		disabledForm.value.jianhurenzhanghao = true;
		//由上级字段带出不可改
		disabledForm.value.jianhurenxingming = true;
	}
	//初始化
	//取消
	const backClick = () => {
		history.back()
	}
	//老人账号回调
	const laorenzhanghaoChange=()=>{
		context?.$http({
			url: `follow/laoren/laorenzhanghao?columnValue=` + form.value.laorenzhanghao,
			method: 'get'
		}).then(res=>{
			//带出老人姓名字段
			if(res.data.data.laorenxingming){
				form.value.laorenxingming = res.data.data.laorenxingming
			}
			//带出性别字段
			if(res.data.data.xingbie){
				form.value.xingbie = res.data.data.xingbie
			}
			//带出年龄字段
			if(res.data.data.nianling){
				form.value.nianling = res.data.data.nianling
			}
			//带出监护人账号字段
			if(res.data.data.jianhurenzhanghao){
				form.value.jianhurenzhanghao = res.data.data.jianhurenzhanghao
			}
			//带出监护人姓名字段
			if(res.data.data.jianhurenxingming){
				form.value.jianhurenxingming = res.data.data.jianhurenxingming
			}
		})
	}
	//提交
	const save=()=>{
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		if(type.value == 'cross'){
			if(crossColumnName.value!=''){
				if(!crossColumnName.value.startsWith('[')){
					for(let o in objcross){
						if(o == crossColumnName.value){
							objcross[o] = crossColumnValue.value
						}
					}
					//修改跨表数据
					changeCrossData(objcross)
				}else{
					crossUserId = context?.$toolUtil.storageGet('userid')
					crossRefId = objcross['id']
					crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
				}
			}
		}
		formRef.value.validate((valid)=>{
			if(valid){
				if(crossUserId&&crossRefId){
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(res=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(res=>{
								context?.$toolUtil.message(`操作成功`,'success',()=>{
									history.back()
								})
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(res=>{
						context?.$toolUtil.message(`操作成功`,'success',()=>{
							history.back()
						})
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row)=>{
		context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
	onMounted(()=>{
		type.value = route.query.type?route.query.type:'add'
		let row = null
		let table = null
		let statusColumnName = null
		let tips = null
		let statusColumnValue = null
		if(type.value == 'cross'){
			row = context?.$toolUtil.storageGet('crossObj')?JSON.parse(context?.$toolUtil.storageGet('crossObj')):{}
			table = context?.$toolUtil.storageGet('crossTable')
			statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName')
			tips = context?.$toolUtil.storageGet('crossTips')
			statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue')
		}
		init(route.query.id?route.query.id:null, type.value,'', row, table, statusColumnName, tips, statusColumnValue)
	})
	
</script>
<style lang="scss" scoped>
	// 面包屑盒子
	.bread_view {
		border-radius: 0px;
		padding: 12px 20px;
		margin: 0px auto;
		background: none;
		width: 100%;
		border-color: #eee;
		border-width: 0 0 0px;
		position: relative;
		border-style: solid;
		:deep(.breadcrumb) {
			font-size: 14px;
			line-height: 1;
			.el-breadcrumb__separator {
				margin: 0 9px;
				color: #999;
				font-weight: 500;
			}
			.first_breadcrumb {
				.el-breadcrumb__inner {
					color: #333;
					display: inline-block;
				}
			}
			.second_breadcrumb {
				.el-breadcrumb__inner {
					color: #999;
					display: inline-block;
				}
			}
		}
	}
	// 表单
	.add_form{
		border: 1px solid #B5D0AC20;
		border-radius: 0px;
		padding: 40px 7% 50px;
		background: #B5D0AC10;
		// form item
		:deep(.el-form-item) {
			border: 0px solid #eee;
			padding: 6px 0;
			margin: 0 0 20px 0;
			background: none;
			display: flex;
			//label
			.el-form-item__label {
			 background: none;
			 display: block;
			 width: auto;
			 min-width: 150px;
			 text-align: right;
			}
			// 内容盒子
			.el-form-item__content {
				display: flex;
				width: calc(100% - 150px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					padding: 0 10px;
					background: #fff;
					width: auto;
					border-color: #ccc;
					border-width: 1px;
					line-height: 36px;
					box-sizing: border-box;
					border-style: solid;
					min-width: 100%;
					height: 36px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
						padding: 0;
					}
					.is-focus {
						box-shadow: none !important;
					}
				}
				//日期选择器
				.list_date {
					border-radius: 0px;
					background: #fff;
					width: auto;
					border-color: #ccc;
					border-width: 1px;
					line-height: 36px;
					box-sizing: border-box;
					border-style: solid;
					min-width: 100%;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
					}
				}
				// 下拉框
				.list_sel {
					border-radius: 0px;
					padding: 0 10px;
					background: #fff;
					width: auto;
					border-color: #ccc;
					border-width: 1px;
					line-height: 36px;
					box-sizing: border-box;
					border-style: solid;
					min-width: 100%;
					//去掉默认样式
					.select-trigger{
						height: 100%;
						.el-input{
							height: 100%;
							.el-input__wrapper{
								border: none;
								box-shadow: none;
								background: none;
								border-radius: 0;
								height: 100%;
								padding: 0;
							}
							.is-focus {
								box-shadow: none !important;
							}
						}
					}
				}
				// 长文本
				.el-textarea__inner {
					border: 1px solid #ccc;
					border-radius: 0px;
					padding: 12px;
					color: #666;
					background: #fff;
					width: 100%;
					font-size: 14px;
					min-height: 120px;
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		padding: 0 150px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 40px;
			margin: 0 20px 0 0;
			color: #666;
			background: #667C5E30;
			width: auto;
			font-size: 14px;
			line-height: 40px;
			transition: all 0.3s;
			height: 40px;
		}
		.formModel_cancel:hover {
		}
		
		.formModel_confirm {
			border: 0px solid #11396190;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 40px;
			margin: 0 20px 0 0;
			color: #fff;
			background: #667C5E;
			width: auto;
			font-size: 14px;
			line-height: 40px;
			transition: all 0.3s;
			height: 40px;
		}
		.formModel_confirm:hover {
		}
	}
</style>