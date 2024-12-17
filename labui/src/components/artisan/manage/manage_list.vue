<template>

    <div>

        <!-- 面包屑导航区域 -->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/' }">登录</el-breadcrumb-item>
            <el-breadcrumb-item>助理档案管理</el-breadcrumb-item>
        </el-breadcrumb>
        <!-- 卡片视图区域 -->
        <el-card style="margin-top: 20px">

            <!-- 列表区域 -->
            <el-table :data="tableData" border style="width: 100%">
                <el-table-column fixed prop="id" label="编号">
                </el-table-column>
                <el-table-column prop="userName" label="姓名">
                </el-table-column>
                <el-table-column  prop="labName" label="实验室"></el-table-column>
                <el-table-column  prop="sectionId" label="部门" :formatter="stateFormat">
                </el-table-column>

                <el-table-column prop="phone" label="电话">
                </el-table-column>
                <el-table-column fixed="right" label="操作">
                    <template slot-scope="scope">
                        <el-button @click="edit(scope.row)" type="primary" icon="el-icon-edit"  size="mini">修改</el-button>
                        <el-button @click="opendelete(scope.row)" type="danger" icon="el-icon-delete" size="mini">删除</el-button>

                    </template>
                </el-table-column>

                <!--                <el-table-column prop="major" label="专业">-->
<!--                </el-table-column>-->
<!--                <el-table-column fixed prop="college" label="学院">-->
<!--                </el-table-column>-->
<!--                <el-table-column prop="clas" label="班级">-->
<!--                </el-table-column>-->
<!--                <el-table-column prop="phone" label="电话">-->
<!--                </el-table-column>-->
<!--                <el-table-column prop="email" label="邮箱">-->
<!--                </el-table-column>-->
<!--                <el-table-column fixed prop="grade" label="年级">-->
<!--                </el-table-column>-->

            </el-table>
            <!-- 修改用户对话框 -->
            <el-dialog title="修改用户" :visible.sync="editDialogVisble" width="70%" @close="addDialogClosed">
                <!-- 内容主体区域 -->
                <el-form :model="editForm" ref="editFormRef" label-width="150px">

                    <el-form-item label="用户id" prop="userId">
                        <el-input disabled="disabled"v-model="editForm.userId"></el-input>
                    </el-form-item>
                    <el-form-item label="用户姓名" prop="userName">
                        <el-input v-model="editForm.userName"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pwd">
                        <el-input v-model="editForm.pwd"></el-input>
                    </el-form-item>
                    <el-form-item label="电话" prop="phone">
                        <el-input v-model="editForm.phone"></el-input>
                    </el-form-item>

                </el-form>
                <!-- 底部区域 -->
                <span slot="footer" class="dialog-footer">
				<el-button type="primary" @click="submitEditForm('editFormRef')">修 改</el-button>

				<el-button @click="editDialogVisble=false">取 消</el-button>

			</span>

            </el-dialog>

        </el-card>
    </div>
</template>
<script>
    export default {
        methods: {
            edit(row) {
                const _this=this;
                this.editDialogVisble = true;
                // row.roleId = String(row.roleId);
                _this.editForm = row
                console.log("editForm");
                console.log(_this.editForm);

            },
            submitEditForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$axios.post('http://localhost:8083/User/update2', this.editForm).then(function(resp) {
                            if (resp.data == 'success') {
                                _this.$message.success('修改成功');
                                _this.editDialogVisble = false
                                _this.refresh();

                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            opendelete(row) {
                const _this = this;
                this.$confirm('此操作将永久该用户, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.delete('http://localhost:8083/User/deleteById/' + row.userId).then(function(resp) {
                        _this.refresh();
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
            refresh(){
                const userId = this.$session.get("userId")
                const _this = this
                this.$axios.get('http://localhost:8083/User/getUserList2').then(function (resp) {
                    _this.tableData = resp.data;
                    console.log(resp.data);

                })
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
            formatJson(filterVal, jsonData) {
                return jsonData.map(v => filterVal.map(j => v[j]))
            }

        },

        data() {
            return {
                editForm:[],
                userId: this.$session.get("userId"),
                total: null,
                tableData: [],
                //控制添加用户对话框的显示和隐藏
                addDialogVisble: false,
                //控制修改用户对话框的显示和隐藏
                editDialogVisble: false,
                stateFormat2(row, column) {
                    return row.sectionId % 2 === 1 ? '技术部' : '后勤部';
                },

            }
        },
        created() {
            const userId = this.$session.get("userId")
            const _this = this
            this.$axios.get('http://localhost:8083/User/getUserList2').then(function (resp) {
                _this.tableData = resp.data;
                console.log(resp.data);
                _this.editForm=resp.data;

            })
        }


    }
</script>

<style scoped>

</style>
