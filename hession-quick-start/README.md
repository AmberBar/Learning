# Hession
HessianServiceExporter 暴露服务接口
* 设置服务端
service 真实调用的服务
* 设置服务接口(泛型)
SayHelloHessian.class
* 暴露接口
@Bean("/url")

## client
客户端client通过HessionProxyFactory创建出一个代理SayHelloHessian.class对象
```
public static <T> T getHessianClientBean(Class<T> clazz,String url) throws Exception
{
    // 客户端连接工厂,这里只是做了最简单的实例化，还可以设置超时时间，密码等安全参数
    HessianProxyFactory factory = new HessianProxyFactory();

    return (T)factory.create(clazz,url);
} 
```