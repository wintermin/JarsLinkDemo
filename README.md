# JarsLinkDemo演示

## 模块

> JarApi 用于加载模块JAR包，对外提供服务

> JarService 获取index信息Action


## 类说明

|类名|说明|
|-----|--------|
|com.winermin.jarslink.IndexController|接收外部HTTP请求并将请求转发到具体模块|
|com.winermin.jarslink.ModuleConfiguration|Bean配置|
|om.winermin.jarslink.ModuelRefreshSchedulerImpl|模块加载器配置|
|com.wintermin.jarslink.action.IndexAction|获取信息Action|


## 使用说明
1. 将JarService打成jar包
2. ModuleRefreshSchedulerImpl类中的`PATH`参数值换成你本地路径
3. 启动App的main方法
4. 浏览器请求`http://ip:8999/jarslink/JarService/index/*your-param*`获取信息
5. JarService,修改IndexAction返回内容，修改pom文件版本号，修改version.config版本号
6. 重新打包JarService,浏览器请求上一步路径，发现已经热更新成功，阿里大法666
