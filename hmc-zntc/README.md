## 智能停车项目介绍

**项目需要环境：**

- Spring Boot 2.0.6.RELEASE
- Spring Cloud Finchley版本
- Rabbit MQ
- Redis



**项目结构：**

- zntc-eureka --------- 服务注册中心
- zntc-gateway -------- 网关路由器
- zntc-config-service - 统一的配置中心
- zntc-admin ---------- 后台管理系统基本框架，基础业务
    - admin ----------- 后台管理系统核心业务代码
    - api ---------------- 对外开放接口
    - common ------- 通用组件、工具类等
    - doc --------------- 后台框架初始化sql文件
    - generator ------ 代码生成器
    - service ---------- 实体bean、mapper文件、service接口

- zntc-user ------------- 用户服务
- zntc-car --------------- 车位服务
- zntc-charger -------- 电桩，充电服务
- zntc-order ----------- 订单服务
- zntc-finance -------- 财务服务



**后台管理系统启动流程**

1. 创建数据库名称为`hmc-zntc`，执行`doc` -> `hmc-zntc.sql` 文件。
2. 修改`zntc-admin` -> `common` -> `application-dev.yml`文件中的数据库链接账号密码。
3. 启动`zntc-eureka`服务注册中心，运行`ZNTCEurekaApplication`类`main`方法即可。
4. 启动`zntc-zuul`智能路由，运行`ZNTCZuulApplication`类`main`方法即可。
5. 启动`zntc-config-service`配置中心，运行`ZNTCConfigApplication`类`main`方法。
5. 启动后台管理系统`zntc-admin` -> `admin`模块，运行`ZNTCAdminApplication`类`main`方法即可。
