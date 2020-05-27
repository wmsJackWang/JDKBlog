# JDKBlog
博客网站系统的搭建

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
  
  
- 前端效果图

  - 前端首页
  
  
  - 后端首页
  
  

我的博客网站演示，请点击查看：
<a href="http://bittechblog.com/" size = 4>比特科技</a>

