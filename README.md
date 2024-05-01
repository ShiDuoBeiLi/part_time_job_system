## 项目介绍

系统主要分为前台浏览页面和后台管理页面，一些设计介绍如下：

1、应聘前台：
- (1)个人中心：个人中心是应聘者管理个人信息的功能，便于用户管理用户属性、密码、个人简历等信息；另外，可实时跟进投递审核情况。
- (2)职位浏览：首页展示最新兼职列表，为方便用户定位感兴趣的兼职，需提供地区筛选与兼职分类等定位方式。
- (3)职位详情：用户通过列表页点击兼职跳转进入兼职详情页，可阅览兼职的标题、职责要求、发布人、发布时间等详细信息，并提供兼职投递功能。

2、招聘前台：
- (1)个人中心：个人中心是招聘者管理个人信息的功能，便于用户管理用户属性、密码、简历审核、发布兼职等；另外，新增企业验证功能核实招聘者真实身份。
- (2)发布职位：发布职位是招聘者必备功能，用户填写兼职详细信息进行发布，前提是用户已通过商家验证，发布后需等待管理员审核，通过即可展示至前台。
- (3)审核应聘者：审核应聘者功能提供给招聘者便于查看兼职的投递情况，并对其进行简历信息审核，反馈审核结果给应聘者。

3、后台（管理员）：
- (1)用户管理：查询，变更，录入用户记录，并且有权删除任意一个用户记录等，除此之外。
- (2)角色管理：设立角色管理接口和菜单权限管理接口，可实现用户对应一种角色，一种角色对应拥有某些菜单操作权限，方便后续平台加入拥有不同职权的角色用户。
- (3)日志管理：日志记录用户登录前台或后台的登录地址、用户名、登录状态等信息。
- (4)企业审核：管理员审核招聘者上传的身份证和营业执照，判定用户身份信息是否真实，并反馈审核结果。
- (5)兼职审核：管理员审核招聘者发布的兼职信息，反馈审核结果给招聘者，不通过则不予前台展示。
- (6)公告管理：管理系统公告内容，发布公共通知内容后，用户可在前台可对其阅览。


## 技术介绍

- SpringBoot
- Mybatis-Plus（MP）
- Thymeleaf——模板引擎
- Layui（前端框架）


## 案例展示

登录注册展示：

![登录](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/login.png)

![注册](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/register.png)

兼职首页与详情页：

![首页](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/index.png)

![详情页](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/detail.png)

主要功能页面：

![主要功能页面1](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img1.png)

![主要功能页面2](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img2.png)

![主要功能页面3](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img3.png)

![主要功能页面4](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img4.png)

![主要功能页面5](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img5.png)

![主要功能页面6](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img6.png)

![主要功能页面7](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img7.png)

![主要功能页面8](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/img8.png)

公告展示页：

![公告展示页](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/ggao.png)

后台展示：

![后台页面1](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin1.png)

![后台页面2](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin2.png)

![后台页面3](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin3.png)

![后台页面4](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin4.png)

![后台页面5](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin5.png)

![后台页面6](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin6.png)

![后台页面7](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/admin7.png)

论文目录：

![论文目录](https://raw.githubusercontent.com/ShiDuoBeiLi/part_time_job_system/master/jobImg/lunwen.png)

## 一些说明

- 系统和论文都可便宜出售，可帮助部署系统运行（v:zhou135431）




