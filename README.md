# JDKBlog
博客网站系统的搭建,如果你喜欢的话 请点个赞吧。

我会定期发布更多样例项目，follow我，第一时间获取资源。

- 贡献者
  - <a href="https://github.com/sccotJiang">sccotJiang</a>
    - 博客系统首页置顶功能前端实现
    - 后台管理系统置顶操作功能实现

  - <a href="http://bittechblog.com/">空白</a>
    - 置顶功能后端排序实现

项目总体设计

- 本项目用到的技术和框架
  - 项目构建： maven
  - web框架：spring boot
  - 数据库ORM：mybatis
  - 数据库连接池：Druid
  - 分页插件：PageHelper
  - 数据库：mysql
  - 缓存NOSQL：redis
  - 前端模板：thymeleaf
  - 文章展示：使用commonmark，将markdown转成html页面

- 环境

工具| 名称 
------- | ------- 
开发工具	| IDEA
语言| JDK1.8, JS, HTML
数据库| mysql5.6
缓存NOSQL| redis
项目构建| Maven
运行环境| Centos7,windows10

- 本项目的重要实现
  - 文章缓存到redis，加快博文加载速度
  - 前后端模式，前端展示博客内容，后端管理博文。
- 新增前后台功能
  - 首页文章列表展示，后台设置置顶的文章会在列表首页展示
  - 后台设置可控制文章是否在首页置顶展示
  
- 博客网站效果图

  - 前端首页
  ![alt](http://bittechblog.com/upload/2020/06/svaqtus2meio2r5dhecq8jo7h2.png)
  
  - 后端首页
  ![alt](http://bittechblog.com/upload/2020/05/0jrq2g6ho4jn3qjehj6j73cfcq.png)
  
  - 后端文章管理(发布出去的文章以及未发布的草稿)
  ![alt](http://bittechblog.com/upload/2020/06/1f2vimn8bmjocpajuk7esc4qqo.jpg)
  
  - 后端知识文档模板管理(基于该博客网站，建立自己的知识网络，无论在哪儿，用手机就能随时复习，这是私有的文档，不对外展示)
  ![alt](http://bittechblog.com/upload/2020/06/t1okb6f7mkhurr6q3cfdda8gf2.jpg)
  
  - 手机查看私有的文档，随时复习知识
  ![alt](http://bittechblog.com/upload/2020/06/66rldgn7nchj4qsa23d6o0iugv.jpg)
  
  - 文章页面
  ![alt](http://bittechblog.com/upload/2020/05/1po1n8djeagogq5mtvucb4g56t.jpg)

我的博客网站演示，请点击查看：
<a href="http://bittechblog.com/" size = 4>比特科技</a>

- TODO List
  - 多用户平台，增加权限模块，开放后台管理，用户基于平台创建自己的知识网络。
  - 网站pv统计模块
  - 第三方登入(QQ,Github,支付宝)
  - 接入GitTalk
  - 功能需求由你来定
  
- 参加本开源项目,你会有的收获
  - 熟悉互联网公司常用orm框架mybatis开发
  - 熟悉redis的开发,大厂常见的缓存设计解决方案
  - 掌握spring的切面编程技术
  - 掌握自定义注解开发技术(架构知识基础点)
  - 掌握spring系列的拦截器技术
  - 掌握基本的文件上传技术
  - 掌握web常见的全局异常处理技术
  - 掌握spring自带的定时任务组件
  - 掌握redis的集群开发模式
  - 掌握互联网常用的springboot+Javamail实现邮件报警技术
  - 最最最最最重要的是：你对本开源项目的贡献，我会放在贡献者列表里，可将你的贡献经历写入简历。
