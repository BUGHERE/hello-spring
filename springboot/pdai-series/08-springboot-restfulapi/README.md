## 08-springboot-restfulapi

### 统一封装接口

RESTful API接口?

什么是 REST？Representational State Transfer，翻译是“表现层状态转化”。可以总结为一句话：REST 是所有 Web 应用都应该遵守的架构设计指导原则。面向资源是 REST 最明显的特征，对于同一个资源的一组不同的操作。资源是服务器上一个可命名的抽象概念，资源是以名词为核心来组织的，首先关注的是名词。REST 要求，必须通过统一的接口来对资源执行各种操作。对于每个资源只能执行一组有限的操作。

什么是 RESTful API？

符合 REST 设计标准的 API，即 RESTful API。REST 架构设计，遵循的各项标准和准则，就是 HTTP 协议的表现，换句话说，HTTP 协议就是属于 REST 架构的设计模式。比如，无状态，请求-响应。

```java
SUCCESS("200", "success"),
FAIL("500", "failed"),

HTTP_STATUS_200("200", "ok"),
HTTP_STATUS_400("400", "request error"),
HTTP_STATUS_401("401", "no authentication"),
HTTP_STATUS_403("403", "no authorities"),
HTTP_STATUS_500("500", "server error");
```