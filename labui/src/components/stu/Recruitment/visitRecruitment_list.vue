<template>

	<div>

		<!-- 面包屑导航区域 -->
		<el-breadcrumb style="height: 30px" separator-class="el-icon-arrow-right">
			<el-breadcrumb-item :to="{ path: '/' }">登录</el-breadcrumb-item>
			<el-breadcrumb-item>查看招聘计划</el-breadcrumb-item>
		</el-breadcrumb>
		<!-- 卡片视图区域 -->
		<el-card style="width: 1300px;height:500px;hemargin-top: 50px">

			<!-- 用户列表区域 -->
			<el-table :data="showList" border style="width: 100%">
				<el-table-column fixed prop="id" label="招聘计划编号">
				</el-table-column>
				<el-table-column prop="planName" label="招聘计划名称">
				</el-table-column>
				<el-table-column prop="required" label="招聘计划要求">
				</el-table-column>
				<el-table-column prop="requireNum" label="招聘人数">
				</el-table-column>
				<el-table-column prop="sectionId" label="申请部门":formatter="stateFormat">
				</el-table-column>
				<el-table-column prop="labName" label="实验室名称">
				</el-table-column>
<!--				<el-table-column prop="status" label="报名状态">-->
<!--					<template slot-scope="scope">-->
<!--						<span v-if="scope.row.status === null">未报名</span>-->
<!--						<span v-else-if="scope.row.status === 1">面试失败</span>-->
<!--						<span v-else-if="scope.row.status === 0">已报名</span>-->
<!--					</template>-->
<!--				</el-table-column>-->

				<el-table-column fixed="right" label="操作">
					<template slot-scope="scope">

						<el-button  v-if="state"  @click="signup(scope.row,userId)" type="warning" icon="el-icon-edit">报名</el-button>
						<el-button disabled="false" v-if="state2 && scope.row.userId=== userId" type="success" icon="el-icon-edit">已经报名</el-button>
					</template>
				</el-table-column>
			</el-table>
		</el-card>








	</div>
</template>

<script>
	export default {
		methods: {
			stateFormat2(row, column) {
				return row.sectionId % 2 === 1 ? '技术部' : '后勤部';
			},
			// stateFormat2(row, column) {
			// 	if (row.labId === 10010) {
			// 		return '软件开发中心'
			// 	} else if (row.labId ===101) {
			// 		return '网络科学'
			// 	} else if (row.labId ===105) {
			// 		return '数字媒体实验室'
			// 	} else if (row.labId ===108) {
			// 		return '计算机科学实验室'
			// 	}else {
			// 		return '通用实验室'
			// 	}
			// },
			text() {
				console.log(this.addForm)
			}, //打开删除对话框方法
			signup(row, userId) {


				const _this = this;

				this.$confirm('只能应聘一个岗位,报名后不可撤销，也不能选其他岗位，是否确定?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.$axios.get('http://localhost:8083/form/signUp/' + row.id + '/' + userId).then(function(resp) {
						if (resp.data === 'success') {
							row.test=0;
							_this.state=true;
							_this.$message.success('报名成功');
							_this.refresh();

						} //else if (resp.data === 'isExist') {
						// 	_this.$message.success('重复报名，报名失败');
						//
						// }

					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});


			}


			,
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},

			handleClick(row) {
				console.log(row);
			},

			// 监听添加用户对话框的关闭事件
			addDialogClosed() {
				this.$refs.addFormRef.resetFields();
			},
			filters(){
				const _this=this;
				const idMap = new Map(); // 使用 Map 来存储 id 对应的对象
				this.tableData.forEach(obj => {
					const existingObj = idMap.get(obj.id);
					if (!existingObj || existingObj.userId !== _this.userId) {
						idMap.set(obj.id, obj); // 更新对象，保留userId为1的对象或者首次遇到的对象
					}
				});
				this.showList = Array.from(idMap.values()); // 将 Map 中的对象转为数组赋值给 list[]
			},
			// filters() {//过滤重复的招聘信息
			// 	const _this=this;
			// 	const idSet = new Set(); // 用于存储已经存在的id值
			// 	_this.showList = this.tableData.filter(item => {
			// 		if (!idSet.has(item.id)) {
			// 			idSet.add(item.id); // 将当前对象的id值添加到Set中
			// 			return true; // 保留该对象
			// 		}
			// 		return false; // 忽略该对象
			// 	});
			// },
			dangqianglist(){
				const _this=this;
				_this.tableData.forEach(item => {
					// 判断对象的 userId 属性是否等于 _this.userId
					if (item.userId === _this.userId) {
						// 如果符合条件，则将该对象赋值给 dangqiang 对象的某个属性
						_this.dangqian = item;

					}
				});
				_this.state=_this.dangqian.status===null || _this.dangqian.status==1 || Object.keys(_this.dangqian || {}).length === 0;
				_this.state2=_this.dangqian.status===0;
				console.log("state2");
				console.log(_this.state2);
				console.log("长度为0");
				console.log(Object.keys(_this.dangqian || {}).length === 0);
				console.log(_this.dangqian.status===null || _this.dangqian.status==1 || Object.keys(_this.dangqian || {}).length === 0);
				console.log("_this.dangqian");
				console.log(_this.dangqian);
				console.log("state");
				console.log(_this.state);
			},
			refresh(){
				const _this = this;
				this.$axios.get('http://localhost:8083/recruit/studentgetlist').then(function(resp) {
					_this.tableData = resp.data.data;
					_this.filters();
					_this.dangqianglist();
					// _this.tableData = resp.data.data.map(item => ({ ...item, test: 1 }));
					// console.log("2");
					console.log(_this.tableData);
					console.log("show");
					console.log(_this.showList);
					// 遍历 this.tableData 数组




				})

			},
			showAlert() {
				this.$alert('面试失败，请重新报名', '提示', {
					confirmButtonText: '确定',
					callback: () => {
						// 在确定按钮点击后的回调函数中可以执行一些操作
						// 例如重新报名的逻辑处理
					}
				});
			}

		},

		data() {
			return {
				state2:null,
				state:null,
				userId: this.$session.get("userId"),
				total: null,
				dangqian:{},//当前用户招聘信息
				tableData: [],//初始查询到的数据
				showList: [],//用来展示招聘信息 这个计划只保留不重复的招聘信息
				//控制添加用户对话框的显示和隐藏
				addDialogVisble: false,

				//控制修改用户对话框的显示和隐藏
				editDialogVisble: false,

				// 添加用户的表单数据
				addForm: {


				},
				// 修改用户的表单数据
				editForm: {

				},
				// 添加表单的验证规则对象
				addFormRules: {
					planName: [{
							required: true,
							message: '请输入招聘计划名称',
							trigger: 'blur'
						},
						{
							min: 2,
							max: 50,
							message: '招聘计划名称长度在2个~到50个字符之间',
							trigger: 'blur'
						}
					],
					required: [{
							required: true,
							message: '请输入招聘要求',
							trigger: 'blur'
						},
						{
							min: 1,
							max: 100,
							message: '招聘计划名称长度在2个~到100个字符之间',
							trigger: 'blur'
						}
					],
					requireNum: [{
							required: true,
							message: '请输入招聘人数',
							trigger: 'blur'
						},
						{
							min: 1,
							max: 1000,
							message: '不能少于1个字符',
							trigger: 'blur'
						}
					]
				},
				// 修改表单的验证规则对象
				editFormRules: {
					planName: [{
							required: true,
							message: '请输入招聘计划名称',
							trigger: 'blur'
						},
						{
							min: 1,
							max: 50,
							message: '招聘计划名称长度在2个~到50个字符之间',
							trigger: 'blur'
						}
					],
					required: [{
							required: true,
							message: '请输入招聘要求',
							trigger: 'blur'
						},
						{
							min: 1,
							max: 100,
							message: '招聘计划名称长度在2个~到100个字符之间',
							trigger: 'blur'
						}
					],
					requireNum: [{
							required: true,
							message: '请输入招聘人数',
							trigger: 'blur'
						},
						{
							min: 1,
							max: 1000,
							message: '不能少于1个字符',
							trigger: 'blur'
						}
					]
				}
			}
		},
		created() {
			const _this = this;
			this.$axios.get('http://localhost:8083/recruit/studentgetlist').then(function(resp) {
				_this.tableData = resp.data.data;
				console.log("tabledata");
				console.log(_this.tableData);
				_this.filters();
				_this.dangqianglist();
				if(_this.dangqian.status===1){
					_this.showAlert();
				}
				// _this.tableData = resp.data.data.map(item => ({ ...item, test: 1 }));
				// console.log("2");
				console.log(_this.tableData);
				console.log("show");
				console.log(_this.showList);
				// 遍历 this.tableData 数组




			})

		}


	}
</script>

<style scoped>
</style>
