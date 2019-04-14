# 第二次作业第二阶段简述
## 流程
### 1、添加Springboot-
    在原有的pom.xml中增加依赖spring-boot-starter-actuator和spring-boot-starter-web（顺便还把spring-boot-starter-parent升到了2.1.4），然后使用Update Project Configuration更新依赖库。
### 2、添加info信息
    在application.properties添加info.author和info.version。运行java程序后打开localhost：8080/actuator/info，看到{"author":"WangYilin","version":"v1.0"}的输出，info信息添加成功。
### 3、查看health信息并自定义HealthIndicator
    在application.properties设置
    management.endpoints.web.exposure.include=*
    management.endpoint.health.show-details=always
    然后打开localhost：8080/actuator/health，会看到原始health信息，包含了db和dickspace的信息。新建java文件MyHealthIndicator并实现HealthIndicator端口，设置自己的HealthIndicator格式。然后打开/health，会看见除了原有信息以外多了MyHealthStyle的细节信息。
### 4、设置自定义节点
    新建java文件MyEndPoint，设置@Endpoint注释和@ReadOperation注释，编写节点内容。然后在AppConfig.java中将MyEndPoint加入Bean。运行程序后打开localhost：8080/actuator/myEndPoint1，会看到自己在MyEndPoint.java中设置的参数。
### 5、测试
    新建SpringActuatorTest.java，编写test1_Info()，test2_Health()，test3_EndPoint()，利用body()函数来检验info信息，自定义health节点信息和自定义节点的输出是否正确。