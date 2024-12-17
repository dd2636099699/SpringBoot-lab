# 实验室管理系统自述文件

## 一、项目简介
本实验室管理系统基于Spring Boot + MyBatis + Vue + MySQL实现，涵盖系统管理、用户管理、招聘管理、应聘管理、实验室管理和日常工作管理等功能模块，有效实现实验室管理工作流程自动化。

### 系统功能模块
- **系统管理**：用户登录注册退出功能，确保系统安全访问。
- **用户管理**：管理员添加不同角色用户（助理、学生、技术老师），灵活分配权限。
- **招聘管理**：技术老师发布招聘信息，经学校管理员审核推送至学生，确保信息准确有效。
- **应聘管理**：学生查看招聘信息报名，面试通过成为助理，实现人才选拔流程。
- **实验室管理**：管理员对实验室进行增删改操作，优化资源管理。
- **日常工作管理**：助理记录工作、报修设备，技术老师维修并记录状态，保障实验室日常运行。

### 系统流程设计
- **系统管理流程**：用户通过登录注册进入系统，确保身份验证与授权。
- **用户管理流程**：管理员按需添加、修改、删除用户，灵活管理用户信息。
- **招聘管理流程**：技术老师发布计划，管理员审核后推送，保证招聘信息质量。
- **应聘管理流程**：学生查看报名，面试通过入职，规范应聘流程。
- **实验室管理流程**：管理员操作实验室信息，确保实验室信息准确。
- **日常工作管理流程**：助理与技术老师协同，保证设备维修与工作记录及时更新。

### 系统数据库设计
- **E-R模型设计**：清晰定义用户、实验室、招聘、设备维修、角色、部门等实体关系，确保数据逻辑严谨。
- **数据表设计**：详细规划各表字段，包括日常工作表、报名表、实验室表、招聘表、设备修理表、角色表、部门表、用户表及用户 - 角色表，实现数据高效存储与管理。

## 二、系统实现
### 程序组织结构
项目结构清晰，各模块分工明确，便于维护与扩展。关键目录如 `src` 包含后端代码，`公共`、`views` 等存放前端资源，确保前后端分离开发。

### 核心代码
- **后端配置**：`application.yml` 文件配置Spring Boot端口、数据源（Druid连接池）、MyBatis相关参数（如别名包、映射文件路径）、分页插件及Redis配置，确保系统稳定运行。
- **跨域配置**：`CorsConfig` 类允许所有来源、头部和方法的跨域请求，解决前后端交互的跨域问题。
- **用户控制器**：`UserController` 提供用户注册、查询、保存、删除、更新等功能，满足用户管理需求。

### 实现效果
- **管理员页面**：实现用户管理、招聘计划审核、实验室管理等功能，界面直观，操作便捷。
- **技术老师页面**：支持发布招聘计划、查看报名情况、设备维修管理及查看助理工作记录，提高工作效率。
- **助理页面**：具备记录日常工作和设备报修功能，确保实验室日常维护工作有序进行。
- **学生用户页面**：学生可查看招聘计划并报名，系统反馈报名状态（成功、失败等），方便学生参与应聘。

## 三、项目总结
### 技术收获
- **Spring Boot**：快速搭建后端框架，利用自动配置与集成能力专注业务逻辑，提高开发效率。
- **MyBatis**：灵活进行数据库操作，通过SQL映射和参数处理实现数据增删改查，有效管理数据库连接与事务。
- **Vue**：采用组件化开发与响应式数据绑定构建用户界面，提高代码可维护性与可扩展性，优化页面渲染与更新。

### 未来展望
进一步探索Spring Boot和Vue的高级特性与最佳实践，如安全认证、性能优化、微服务架构、前后端分离等，提升系统安全性、性能与可扩展性，为未来项目开发积累经验。

 ![image](https://github.com/user-attachments/assets/c0eaac00-d045-4772-bcb8-2b38c0c75200)
![image](https://github.com/user-attachments/assets/365175bf-a306-4e04-90ae-09d68732d3ee)

![image](https://github.com/user-attachments/assets/b13833ed-7e45-459c-9258-aaef70e741a5)

![image](https://github.com/user-attachments/assets/cb1addc3-5cd6-4142-85ab-d07358eb6e0d)
![image](https://github.com/user-attachments/assets/e704d4aa-05ea-4497-90a7-84a5699762e0)
![image](https://github.com/user-attachments/assets/c14db803-8d55-4894-ab2d-8c3c001579d7)
![image](https://github.com/user-attachments/assets/e3f15e05-763b-47da-a712-b3197ece95e9)
![image](https://github.com/user-attachments/assets/4ca615a8-5f34-4059-bf31-16d9ad8b4a81)
![image](https://github.com/user-attachments/assets/e9bb4adb-5c0f-4365-b60a-5b22e737f271)
![image](https://github.com/user-attachments/assets/a5a1665b-8b2d-48ca-8ca5-5ecfa5ff2409)
![image](https://github.com/user-attachments/assets/3fa5d370-ef0d-4b59-beeb-3fff30092f1b)
![image](https://github.com/user-attachments/assets/ed200a02-8d28-4ae9-8f31-b4cf57517b4f)
![image](https://github.com/user-attachments/assets/b52a322a-2b7f-45ca-8b78-73e2431d5dcd)
![image](https://github.com/user-attachments/assets/c1765da1-4491-40db-bacc-880dcfb3a06f)
![image](https://github.com/user-attachments/assets/9ce37793-cffa-41a6-922e-6309649b1297)
![image](https://github.com/user-attachments/assets/2a3caf4f-ebce-4f8b-b541-cd53bfaefe33)













