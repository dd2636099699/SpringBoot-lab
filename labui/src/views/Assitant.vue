<!--<template>-->
<!--    <el-container class="home-container">-->
<!--        &lt;!&ndash; 头部区域&ndash;&gt;-->
<!--        <el-header>-->
<!--            <div>-->
<!--                <span>实验室系统&#45;&#45;&#45;&#45;&ndash;&gt;助理{{msg}}</span>-->
<!--            </div>-->
<!--            <el-button  @click="returnIndex"  type="danger">退出</el-button>-->
<!--        </el-header>-->
<!--        &lt;!&ndash;页面主体区域&ndash;&gt;-->
<!--        <el-container>-->
<!--            &lt;!&ndash;侧边栏&ndash;&gt;-->
<!--            <el-aside width="200px" hi>-->
<!--                &lt;!&ndash;侧边栏菜单区域&ndash;&gt;-->
<!--                <el-menu background-color="#f2f9fd" router>-->
<!--                    &lt;!&ndash; 一级菜单 &ndash;&gt;-->
<!--					 <el-submenu v-for="(item,index) in $router.options.assitantRouter" :index="index+''" >-->

<!--                        &lt;!&ndash;一级菜单的模板区域&ndash;&gt;-->
<!--                        <template slot="title">-->
<!--                            &lt;!&ndash;图标&ndash;&gt;-->
<!--                            <i :class="item.icon"></i>-->
<!--                            &lt;!&ndash; 文本 &ndash;&gt;-->
<!--                            <span>{{item.name}}</span>-->
<!--                        </template>-->

<!--                        &lt;!&ndash; 二级菜单 &ndash;&gt;-->
<!--                            <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path">{{item2.name}}</el-menu-item>-->
<!--                    </el-submenu>-->
<!--                </el-menu>-->
<!--            </el-aside>-->
<!--            &lt;!&ndash;右侧内容主体&ndash;&gt;-->
<!--            <el-main>-->
<!--                &lt;!&ndash;路由占位符&ndash;&gt;-->
<!--                <router-view ></router-view>-->
<!--            </el-main>-->
<!--        </el-container>-->
<!--    </el-container>-->
<!--</template>-->

<!--<script>-->

<!--   export default {-->
<!--	methods:{-->
<!--		returnIndex(){-->
<!--			this.$session.destroy()-->
<!--			window.location.href="/"-->
<!--		}-->

<!--	},-->
<!--	data(){-->
<!--		return{-->
<!--			msg: this.$route.query.data.roleId-->

<!--		}-->
<!--	}-->

<!--}-->
<!--</script>-->

<!--<style lang="less" scoped>-->
<!--    .home-container{-->
<!--        height:100%;-->

<!--    }-->
<!--    .el-header{-->
<!--        background-color: #0e78ac;-->
<!--        display: flex;-->
<!--        justify-content: space-between;-->
<!--        padding-left: 0;-->
<!--        align-items: center;-->
<!--        color: #fff;-->
<!--        font-size: 24px;-->

<!--        span{-->
<!--            margin-left: 15px;-->
<!--        }-->
<!--    }-->

<!--    .el-aside{-->
<!--        background-color: #f2f9fd;-->
<!--    }-->

<!--    .el-main{-->
<!--        background-color: #EAEDF1;-->
<!--    }-->

<!--</style>-->
<!--<template>-->
<!--    <el-container class="home-container">-->
<!--        &lt;!&ndash; 头部区域&ndash;&gt;-->
<!--        <el-header>-->
<!--            <div>-->
<!--                <span>实验室系统&#45;&#45;&#45;&#45;&ndash;&gt;技术人员</span>-->
<!--            </div>-->
<!--            <el-button type="danger" @click="returnIndex"  >退出</el-button>-->

<!--        </el-header>-->
<!--        &lt;!&ndash;页面主体区域&ndash;&gt;-->
<!--        <el-container>-->
<!--            &lt;!&ndash;侧边栏&ndash;&gt;-->
<!--            <el-aside width="200px">-->
<!--                &lt;!&ndash;侧边栏菜单区域&ndash;&gt;-->
<!--                <el-menu background-color="#f2f9fd" router>-->
<!--                    &lt;!&ndash; 一级菜单 &ndash;&gt;-->
<!--					 <el-submenu v-for="(item,index) in $router.options.artisanRouter" :index="index+''" >-->
<!--                   -->
<!--                        &lt;!&ndash;一级菜单的模板区域&ndash;&gt;-->
<!--                        <template slot="title">-->
<!--                            &lt;!&ndash;图标&ndash;&gt;-->
<!--                            <i :class="item.icon"></i>-->
<!--                            &lt;!&ndash; 文本 &ndash;&gt;-->
<!--                            <span>{{item.name}}</span>-->
<!--                        </template>-->

<!--                        &lt;!&ndash; 二级菜单 &ndash;&gt;-->
<!--                            <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path">{{item2.name}}</el-menu-item>-->
<!--                    </el-submenu>-->
<!--                </el-menu>-->
<!--            </el-aside>-->
<!--            &lt;!&ndash;右侧内容主体&ndash;&gt;-->
<!--            <el-main>-->
<!--                &lt;!&ndash;路由占位符&ndash;&gt;-->
<!--                <router-view ></router-view>-->
<!--            </el-main>-->
<!--        </el-container>-->
<!--    </el-container>-->
<!--</template>-->

<!--<script>-->
<!--   -->

<!--    export default {-->
<!--        methods:{-->
<!--            returnIndex(){-->
<!--				this.$session.destroy()-->
<!--                window.location.href="/"-->
<!--            }-->

<!--        },-->
<!--        data(){-->
<!--            return{-->
<!--                msg: this.$route.query.data.roleId-->
<!--                -->
<!--            }-->
<!--        }-->
<!--       -->
<!--    }-->
<!--</script>-->

<!--<style lang="less" scoped>-->
<!--    .home-container{-->
<!--        height:100%;-->
<!--		-->
<!--    }-->
<!--    .el-header{-->
<!--        background-color: #0e78ac;-->
<!--        display: flex;-->
<!--        justify-content: space-between;-->
<!--        padding-left: 0;-->
<!--        align-items: center;-->
<!--        color: #fff;-->
<!--        font-size: 24px;-->

<!--        span{-->
<!--            margin-left: 15px;-->
<!--        }-->
<!--    }-->
<!--    -->
<!--    .el-aside{-->
<!--        background-color: #f2f9fd;-->
<!--    }-->

<!--    .el-main{-->
<!--        background-color: #EAEDF1;-->
<!--		-->
<!--    }-->

<!--</style>-->
<template>
    <el-container class="home-container">

        <!-- 头部区域-->
        <el-header >
            <img :src="require('../img/logo_school .png')"  class="logo">



        </el-header>
        <el-header>
            <span class="s">&ensp;&ensp;&ensp;实验室管理系统</span>
            <div class="header">
                <div class="right-section">
                    <span>助理&ensp;</span>
                    <div class="user-section">
                        <i class="el-icon-user-solid">{{sectionName}}&ensp;&ensp;{{userName}}</i>
                        <el-button type="danger" @click="returnIndex">退出</el-button>
                    </div>
                </div>
            </div>
        </el-header>
        <!--页面主体区域-->

        <el-container>
            <!--侧边栏-->
            <el-aside width="200px" hi>
                <!--侧边栏菜单区域-->
                <el-menu
                        background-color="#f2f9fd"
                        router
                        :default-openeds="defaultOpeneds"
                        :default-active="defaultActive"
                        @open="handleMenuOpen"
                        ref="sideMenu"
                >
                    <!-- 一级菜单 -->
                    <el-menu-item
                            v-for="(item2, index2) in $router.options.assitantRouter[0].children"
                            :index="item2.path"
                            :key="index2"
                            @click="handleMenuItemClick(item2.path)"
                    >
                        {{ item2.name }}
                    </el-menu-item>
                </el-menu>
            </el-aside>
            <!--右侧内容主体-->
            <el-main>
                <!--路由占位符-->
                <router-view></router-view>
            </el-main>
        </el-container>
        <footer>
            <p class="small-text">粤KCP备20034480328号
                2023 © 计算机20-3卢固智 | 地址:广东石油化工学院官渡校区 |  电话:13536967225  |  邮箱: 2636099699@qq.com | 隐私政策



            </p>

        </footer>
    </el-container>

</template>

<script>
    import UserList from '../components/admin/user_list.vue'
    export default {
        data() {
            return {
                userName:null,
                sectionName:null,
                defaultOpeneds: [this.$router.options.assitantRouter[0].path], // 默认展开的菜单路径数组
                defaultActive: '', // 默认选中项的路径
            };
        },
        mounted() {

            // 设置默认选中第一个菜单栏目并展示对应数据
            this.defaultActive = this.$router.options.assitantRouter[0].children[0].path;

            // 手动触发第一个菜单项的点击事件
            this.$nextTick(() => {
                const firstMenuItem = this.$refs.sideMenu.$el.querySelector('.el-menu-item:first-child');
                if (firstMenuItem) {
                    firstMenuItem.click();
                }
            });

            const userName = this.$session.get("userName")
            this.userName=userName;
            const sectionName = this.$session.get("sectionName")
            this.sectionName=sectionName;
        },
        methods: {

            returnIndex() {
                // 退出操作

                    this.$router.push('/');

            },
            handleMenuOpen(index) {
                // 当菜单展开时，将第一个菜单项设为选中
                if (index === this.$router.options.assitantRouter[0].path) {
                    this.defaultActive = this.$router.options.assitantRouter[0].children[0].path;
                }
            },
            handleMenuItemClick(path) {
                this.defaultActive = path;
            },
        },
    };
</script>

<style lang="less" scoped>
    .home-container{
        height:100%;

    }
    .el-header{
        padding-top: 40px;    /* 设置顶部内边距 */
        padding-bottom: 40px; /* 设置底部内边距 */

        background-color: #0e78ac;
        display: flex;
        justify-content: space-between;
        padding-left: 0;
        align-items: center;
        color: #fff;
        font-size: 20px;

        span{
            margin-left: 80px;
        }
    }

    .el-aside{
        background-color: #f2f9fd;
    }

    .el-main{
        background-color: #EAEDF1;
    }
    .header {

        height: 15px;
    }

    .right-section {
        display: flex;
        align-items: center;
    }

    .right-section .user-section {
        display: flex;
        align-items: center;
    }

    .right-section .user-section .el-icon-user-solid {
        margin-right: 30px; /* 调整图标和按钮之间的间距 */
    }
    .s{
        height: 0px;
        margin-left: 1000px;
    }
    .logo{
        width:400px;   /* 设置图像的宽度 */
        height: auto;   /* 自动计算图像的高度 */
        margin-left: 150px;
    }
    .small-text {
        font-size: 15px;
        color: #999999;
        font-family: '黑体', 'PingFang SC', 'Helvetica Neue', Helvetica, Arial, sans-serif;
        text-align: center;
        margin: 0 auto;
        height: 1px;

    }
</style>