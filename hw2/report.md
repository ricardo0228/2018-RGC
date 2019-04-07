# 第二次作业第一阶段简述
## 流程
### 1、新建Maven-Spring boot工程
    新建文件夹hw2，选择从Maven原型生成，选择spring-boot-blank-archetype，设置好groupID等参数后自动生成工程。将默认的主函数App改为Main，同时在pom.xml中将启动文件改为hw2.Main，删掉不必要的初始函数。
### 2、移植hw1程序
    新建WordLadder.java，Dictionary.java，将原本的代码分类，并编写额外的可能用到的接口函数。
### 3、设置AppController
    在AppController中设置主目录"/WordLadder"，以及"showDictionary","addWord","search"三个方法，其中"addWord"和"search"有输入参数。AppController中共用一个Dictionary，保证数据的暂时一致性。
### 4、测试
    编写测试函数"testRunning","testSearch","testShow","testAdd"并进行测试，然后在网页上通过8080端口进行更多测试，将WordLadder中的dict改成了深复制。