## springboot-mapstruct:
1. 查看官方文档后，修改成正确的pom配置，下载问题解决
2. `lombok`和`mapstruct`都是利用`Annotation
Processor`在程序编译时生成代码，而默认的`mapstruct`的`maven-compiler-plugin`插件配置中并没有`lombok`，所以还需要在`mapstruct`前加入`lombok`的编译生成代码逻辑