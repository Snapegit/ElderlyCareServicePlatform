<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="50%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="24">
						<el-form-item label="服务名称" prop="fuwumingcheng">
							<el-input class="list_inp" v-model="form.fuwumingcheng" placeholder="服务名称"
								 type="text" 								:readonly="!isAdd||disabledForm.fuwumingcheng?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="服务地点" prop="fuwudidian">
							<el-input class="list_inp" v-model="form.fuwudidian" placeholder="服务地点"
								 type="text" 								:readonly="!isAdd||disabledForm.fuwudidian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="服务日期" prop="fuwuriqi">
							<el-date-picker
								class="list_date"
								v-model="form.fuwuriqi"
								format="YYYY 年 MM 月 DD 日"
								value-format="YYYY-MM-DD"
								type="datetime"
								:readonly="!isAdd||disabledForm.fuwuriqi?true:false"
								placeholder="请选择服务日期" />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="照片" prop="zhaopian">
							<uploads
								:disabled="!isAdd||disabledForm.zhaopian?true:false"
								action="file/upload" 
								tip="请上传照片" 
								:limit="3" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.zhaopian?form.zhaopian:''" 
								@change="zhaopianUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="视频" prop="shipin">
							<uploads
								:disabled="!isAdd||disabledForm.shipin?true:false"
								type="file"
								action="file/upload" 
								tip="请上传视频" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.shipin?form.shipin:''" 
								@change="shipinUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="志愿者账号" prop="zhiyuanzhezhanghao">
							<el-input class="list_inp" v-model="form.zhiyuanzhezhanghao" placeholder="志愿者账号"
								 type="text" 								:readonly="!isAdd||disabledForm.zhiyuanzhezhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="志愿者姓名" prop="zhiyuanzhexingming">
							<el-input class="list_inp" v-model="form.zhiyuanzhexingming" placeholder="志愿者姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.zhiyuanzhexingming?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="内容" prop="neirong">
							<editor :value="form.neirong" placeholder="请输入内容" :readonly="!isAdd||disabledForm.neirong?true:false"
								class="list_editor" @change="(e)=>editorChange(e,'neirong')"></editor>
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
	const tableName = 'fuwujilu'
	const formName = '服务记录'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		fuwumingcheng : false,
		fuwudidian : false,
		fuwuriqi : false,
		zhaopian : false,
		shipin : false,
		neirong : false,
		zhiyuanzhezhanghao : false,
		zhiyuanzhexingming : false,
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
		fuwumingcheng: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		fuwudidian: [
			{required: true,message: '请输入',trigger: 'blur'}, 
		],
		fuwuriqi: [
		],
		zhaopian: [
		],
		shipin: [
		],
		neirong: [
		],
		zhiyuanzhezhanghao: [
		],
		zhiyuanzhexingming: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//照片上传回调
	const zhaopianUploadSuccess=(e)=>{
		form.value.zhaopian = e
	}
	//视频上传回调
	const shipinUploadSuccess=(e)=>{
		form.value.shipin = e
	}
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			fuwumingcheng: '',
			fuwudidian: '',
			fuwuriqi: '',
			zhaopian: '',
			shipin: '',
			neirong: '',
			zhiyuanzhezhanghao: '',
			zhiyuanzhexingming: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			res.data.data.neirong = res.data.data.neirong?(res.data.data.neirong.replace(reg,'../../../cl3973433/file')):'';
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
				if(x=='fuwumingcheng'){
					form.value.fuwumingcheng = row[x];
					disabledForm.value.fuwumingcheng = true;
					continue;
				}
				if(x=='fuwudidian'){
					form.value.fuwudidian = row[x];
					disabledForm.value.fuwudidian = true;
					continue;
				}
				if(x=='fuwuriqi'){
					form.value.fuwuriqi = row[x];
					disabledForm.value.fuwuriqi = true;
					continue;
				}
				if(x=='zhaopian'){
					form.value.zhaopian = row[x];
					disabledForm.value.zhaopian = true;
					continue;
				}
				if(x=='shipin'){
					form.value.shipin = row[x];
					disabledForm.value.shipin = true;
					continue;
				}
				if(x=='neirong'){
					form.value.neirong = row[x];
					disabledForm.value.neirong = true;
					continue;
				}
				if(x=='zhiyuanzhezhanghao'){
					form.value.zhiyuanzhezhanghao = row[x];
					disabledForm.value.zhiyuanzhezhanghao = true;
					continue;
				}
				if(x=='zhiyuanzhexingming'){
					form.value.zhiyuanzhexingming = row[x];
					disabledForm.value.zhiyuanzhexingming = true;
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
			if(json.hasOwnProperty('zhiyuanzhezhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.zhiyuanzhezhanghao = json.zhiyuanzhezhanghao
				disabledForm.value.zhiyuanzhezhanghao = true;
			}
			if(json.hasOwnProperty('zhiyuanzhexingming')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.zhiyuanzhexingming = json.zhiyuanzhexingming
				disabledForm.value.zhiyuanzhexingming = true;
			}
		})
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
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		if(form.value.zhaopian!=null) {
			form.value.zhaopian = form.value.zhaopian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.shipin!=null) {
			form.value.shipin = form.value.shipin.replace(new RegExp(context?.$config.url,"g"),"");
		}
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
				// 富文本
				.list_editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					margin: 0;
					width: auto;
					min-height: 320px;
					border-color: #eee;
					border-width: 1px;
					border-style: solid;
					min-width: 100%;
					height: auto;
				}
				//图片上传样式
				.el-upload-list  {
					//提示语
					.el-upload__tip {
						margin: 7px 0 0;
						color: #999;
						display: flex;
						font-size: 14px;
						justify-content: flex-start;
						align-items: center;
					}
					//外部盒子
					.el-upload--picture-card {
						border: 1px solid #eee;
						cursor: pointer;
						background-color: #fff;
						border-radius: 0px;
						width: 120px;
						line-height: 70px;
						text-align: center;
						height: 60px;
						//图标
						.el-icon{
							color: #ff9900;
							font-size: 32px;
						}
					}
					.el-upload-list__item {
						border: 1px solid #eee;
						cursor: pointer;
						background-color: #fff;
						border-radius: 0px;
						width: 120px;
						line-height: 70px;
						text-align: center;
						height: 60px;
					}
				}
				//文件上传样式
				.upload-demo {
					width: 100%;
					//外部盒子
					.el-upload-dragger {
						border: 1px solid #eee;
						cursor: pointer;
						background-color: #fff;
						border-radius: 0px;
						overflow: hidden;
						width: 360px;
						box-sizing: border-box;
						text-align: center;
						height: auto;
					}
					//图标
					.el-icon--upload {
						margin: 0;
						color: #ff9900;
						font-size: 48px;
						line-height: 48px;
					}
					//提示文字
					.el-upload__text {
						margin: 0px 0 0;
						color: #999;
						font-size: 14px;
						em {
							color: #ff9900;
						}
					}
					//提示文字
					.el-upload__tip {
						margin: 0px 0 0;
						color: #999;
						font-size: 14px;
					}
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