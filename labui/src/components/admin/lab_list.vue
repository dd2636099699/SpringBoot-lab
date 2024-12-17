<template>

    <div>

        <!-- 面包屑导航区域 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">登录</el-breadcrumb-item>
            <el-breadcrumb-item>实验室管理{{userId}}</el-breadcrumb-item>
        </el-breadcrumb>
        <!-- 卡片视图区域 -->
        <el-card style="margin-top: 20px">
            <!-- 搜索与添加区域 -->
            <el-row :gutter="20">
                <el-col :span="4">
                    <el-button type="primary" @click="addDialogVisble = true">添加实验室</el-button>
                </el-col>
            </el-row>
            <!-- 用户列表区域 -->
            <el-table :data="tableData" border style="width: 100%">
                <el-table-column
                        fixed
                        prop="id"
                        label="id">
                </el-table-column>

                <el-table-column
                        prop="labName"
                        label="实验室名称">
                </el-table-column>

                <el-table-column
                        prop="labType"
                        label="所属类别":formatter="stateFormat">
                </el-table-column>

                <el-table-column
                        fixed="right"
                        label="操作">
                    <template slot-scope="scope">
                        <el-button @click="edit(scope.row)" type="primary" icon="el-icon-edit">修改</el-button>
                        <el-button @click="opendelete(scope.row)" type="danger" icon="el-icon-delete">删除</el-button>
                    </template>
                </el-table-column>


            </el-table>
        </el-card>
        <!-- 添加对话框 -->
        <el-dialog
                title="添加实验室"
                :visible.sync="addDialogVisble"
                width="70%"
                @close="addDialogClosed">
            <!-- 内容主体区域 -->
            <el-form :model="addForm" ref="addFormRef" label-width="150px">

                <el-form-item label="实验室名称" prop="labName">
                    <el-input v-model="addForm.labName"></el-input>
                </el-form-item>

                <el-form-item label="所属类别" prop="labType">
<!--                    <el-input v-model="addForm.labType"></el-input>-->
                    <el-select v-model="addForm.labType" placeholder="请选择">
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>


                <el-form-item label="编号" prop="labId">
                    <el-input v-model="addForm.labId"></el-input>
                </el-form-item>

            </el-form>
            <!-- 底部区域 -->
            <span slot="footer" class="dialog-footer">
				<el-button type="primary" @click="submitForm('addFormRef')">添 加</el-button>
                <el-button @click="resetForm('addFormRef')">重 置</el-button>
				<el-button @click="addDialogVisble=false">取 消</el-button>
				
            </span>

        </el-dialog>

        <!--修改对话框-->
        <el-dialog
                title="修改实验室信息"
                :visible.sync="editDialogVisble"
                width="70%"
                @close="addDialogClosed">
<!--            <div >-->
<!--&lt;!&ndash;                <el-scrollbar style="height: 100%;">&ndash;&gt;-->
<!--&lt;!&ndash;                    &lt;!&ndash; 用户列表区域 &ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;                    <el-table&ndash;&gt;-->
<!--&lt;!&ndash;                            :data="tableData"&ndash;&gt;-->
<!--&lt;!&ndash;                            height="450"&ndash;&gt;-->
<!--&lt;!&ndash;                            border&ndash;&gt;-->
<!--&lt;!&ndash;                            class="table-container">&ndash;&gt;-->
<!--&lt;!&ndash;                    </el-table>&ndash;&gt;-->
<!--&lt;!&ndash;                </el-scrollbar>&ndash;&gt;-->

<!--            </div>-->
            <!-- 内容主体区域 -->
            <el-form :model="editForm" ref="editFormRef" label-width="150px">
                <el-form-item label="实验室名称" prop="labName">
                    <el-input v-model="editForm.labName"></el-input>
                </el-form-item>
                <el-form-item label="所属类别" prop="labType">
<!--                    <el-input v-model="editForm.labType"></el-input>-->
                        <el-select v-model="editForm.labType" placeholder="请选择">
                            <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-select>
                </el-form-item>
                <el-form-item label="实验室编号" prop="labId">
                    <el-input v-model="editForm.labId"></el-input>
                </el-form-item>
            </el-form>


            <!-- 底部区域 -->
            <span slot="footer" class="dialog-footer">
				<el-button type="primary" @click="submitEditForm('editFormRef')">修 改</el-button>
				<el-button @click="editDialogVisble=false">取 消</el-button>
			</span>
        </el-dialog>


    </div>
</template>


<script>
    export default {
        methods: {

            edit(row) {
                this.editDialogVisble = true;
                this.editForm = row

            },
            refesh(){
                const labId = this.$session.get("labId");
                const _this = this;
                this.$axios.get('http://localhost:8083/labs/getList').then(function (resp) {
                    // _this.tableData = resp.data.console.log(resp.data);
                    _this.tableData = resp.data;
                })
            },

            //打开删除对话框方法
            opendelete(row) {
                const _this = this;
                this.$confirm('此操作将永久该实验室, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete('http://localhost:8083/labs/deleteById/' + row.id).then(function (resp) {
                        _this.refesh();

                    }),
                    this.$message({
                        type: 'success',
                        message: '删除成功!'

                    });

                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },

            submitForm(formName) {
                const _this = this
                const labId = this.$session.get("labId")
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post('http://localhost:8083/labs/save', this.addForm).then(function (resp) {
                            if (resp.data == 'success') {
                                _this.$message.success('添加成功');
                                _this.addDialogVisble = false
                                _this.refesh();

                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            submitEditForm(formName) {
                const _this = this
                const labId = this.$session.get("labId")
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post('http://localhost:8083/labs/update' , this.editForm).then(function (resp) {
                            if (resp.data == 'success') {
                                _this.$message.success('修改成功');
                                _this.editDialogVisble = false
                            _this.refesh();
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
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
            reviewDialogClosed() {
                this.reviewDialogVisble = false;
            },


        },

        data() {
            return {
                options: [{
                    value: '公共基础实验室',
                    label: '公共基础实验室'
                }, {
                    value: '专业实验室',
                    label: '专业实验室'
                }],
                labId: this.$session.get("labId"),
                total: null,
                tableData: [],
                //控制添加用户对话框的显示和隐藏
                addDialogVisble: false,

                //控制修改用户对话框的显示和隐藏
                editDialogVisble: false,
                // 添加用户的表单数据
                addForm: {
                    labName: '',
                    labType: '',
                    labId: '',
                },
                stateFormat(row, column) {
                    // if (row.labType === '1') {
                    //     return '公共基础实验室'
                    // } else{
                    //     return '专业实验室'
                    // }
                    return row.labType;
                },
                // 修改用户的表单数据
                editForm: {
                    labName: '',
                    labType: '',
                    labId: '',
                }
            }
        },
        created() {
            const labId = this.$session.get("labId");
            const _this = this;
            this.$axios.get('http://localhost:8083/labs/getList').then(function (resp) {
                // _this.tableData = resp.data.console.log(resp.data);
                _this.tableData = resp.data;
            })
        }
    }
</script>

<style scoped>

</style>