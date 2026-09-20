<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="50%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="24">
						<el-form-item label="老人账号" prop="laorenzhanghao">
							<el-select
								class="list_sel"
								:disabled="!isAdd||disabledForm.laorenzhanghao?true:false"
								v-model="form.laorenzhanghao" 
								placeholder="请选择老人账号"
								@change="laorenzhanghaoChange">
								<el-option v-for="(item,index) in laorenzhanghaoLists" :label="item" :value="item">
								</el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="老人姓名" prop="laorenxingming">
							<el-input class="list_inp" v-model="form.laorenxingming" placeholder="老人姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.laorenxingming?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="性别" prop="xingbie">
							<el-input class="list_inp" v-model="form.xingbie" placeholder="性别"
								 type="text" 								:readonly="!isAdd||disabledForm.xingbie?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="年龄" prop="nianling">
							<el-input class="list_inp" v-model="form.nianling" placeholder="年龄"
								 type="text" 								:readonly="!isAdd||disabledForm.nianling?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="监护人账号" prop="jianhurenzhanghao">
							<el-input class="list_inp" v-model="form.jianhurenzhanghao" placeholder="监护人账号"
								 type="text" 								:readonly="!isAdd||disabledForm.jianhurenzhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="监护人姓名" prop="jianhurenxingming">
							<el-input class="list_inp" v-model="form.jianhurenxingming" placeholder="监护人姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.jianhurenxingming?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="慢性病" prop="manxingbing">
							<el-input class="list_inp" v-model="form.manxingbing" placeholder="慢性病"
								 type="text" 								:readonly="!isAdd||disabledForm.manxingbing?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="家族病史" prop="jiazubingshi">
							<el-input class="list_inp" v-model="form.jiazubingshi" placeholder="家族病史"
								 type="text" 								:readonly="!isAdd||disabledForm.jiazubingshi?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="登记时间" prop="dengjishijian">
							<el-date-picker
								class="list_date"
								v-model="form.dengjishijian"
								format="YYYY-MM-DD HH:mm:ss"
								value-format="YYYY-MM-DD HH:mm:ss"
								type="datetime"
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
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="formModel_cancel" @click="closeClick">取消</el-button>
					<el-button class="formModel_confirm" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
	//基础信息
	const tableName = 'jiankangxinxi'
	const formName = '健康信息'
	//基础信息
	//form表单
	const form = ref({})
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
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
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
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//老人账号列表
	const laorenzhanghaoLists = ref([])
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
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
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
			form.value.dengjishijian = context?.$toolUtil.getCurDateTime()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}else if(formType == 'logistics'){
			isAdd.value = false
			formTitle.value = '修改物流信息'
			getInfo()
		}else if(formType == 'reply'){
			type.value = formType
			isAdd.value = true
			disabledForm.value.cpicture = true
			disabledForm.value.content = true
			formTitle.value = '回复'
			getInfo()
		}else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
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
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
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
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	const laorenzhanghaoChange=()=>{
		context?.$http({
			url: `follow/laoren/laorenzhanghao?columnValue=` + form.value.laorenzhanghao,
			method: 'get'
		}).then(res=>{
			if(res.data.data.laorenxingming){
				form.value.laorenxingming = res.data.data.laorenxingming
			}
			if(res.data.data.xingbie){
				form.value.xingbie = res.data.data.xingbie
			}
			if(res.data.data.nianling){
				form.value.nianling = res.data.data.nianling
			}
			if(res.data.data.jianhurenzhanghao){
				form.value.jianhurenzhanghao = res.data.data.jianhurenzhanghao
			}
			if(res.data.data.jianhurenxingming){
				form.value.jianhurenxingming = res.data.data.jianhurenxingming
			}
		})
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
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
									formVisible.value = false
									emit('formModelChange')
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
							formVisible.value = false
							emit('formModelChange')
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
</script>
<style lang="scss" scoped>
	// 表单
	.formModel_form{
		border: 0px solid #ddd;
		border-radius: 4px;
		padding: 30px;
		margin: 0;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			margin: 0 150px 20px 0;
			background: none;
			display: flex;
			//label
			.el-form-item__label {
			 background: none;
			 font-weight: 500;
			 display: block;
			 width: 150px;
			 min-width: 150px;
			 text-align: right;
			}
			// 内容盒子
			.el-form-item__content {
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
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
					border: 1px solid #eee;
					border-radius: 0px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
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
					border: 1px solid #eee;
					border-radius: 0px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
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
					border: 1px solid #eee;
					border-radius: 0;
					padding: 12px;
					color: #333;
					width: auto;
					font-size: 14px;
					min-height: 120px;
					min-width: 50%;
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			outline: none;
			color: #990033;
			background: #ff990030;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_cancel:hover {
		}
		
		.formModel_confirm {
			border: 0;
			cursor: pointer;
			border-radius: 0px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			outline: none;
			color: #fff;
			background: #ff9900;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_confirm:hover {
		}
	}
</style>