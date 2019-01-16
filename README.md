* 编写自己的starter说明

```
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure</artifactId>
 </dependency>
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-configuration-processor</artifactId>
      <optional>true</optional>
</dependency>   
 ```
 
 >spring-boot-configuration-processor 的作用是编译时生成 spring-configuration-metadata.json ，此文件主要给IDE使用，用于提示使用，即可以用ctlr+鼠标左键，IDE会跳转到你配置此属性的类中。
 
 * 注意点
 
     * @ConditionalOnMissingBean 、ConditionalOnClass 其实者2注解不加也可以在springBoot里面自动装配，主要是加了这2个注解，防止人为在代码里已经实例化了所需要的类，再让spring来装配它会产生错误/重复。
     
     * META-INF 下面的spring.factories 配置很重要，springBoot在启动的时候会读取这里面需要自动装配的类
     
     * 实例化类，具体的内容也可以不用写在配置文件里面，自己在代码里面写死属性值也是可以的
     
     * 在pom里面不需要springBoot的maven插件，因为这个插件的作用是将普通的jar变成可以执行的jar，这样在引用的时候会报错，有2个启动类。
     
 ```
 <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
  </plugin>
  
 ```
    
 * 执行 mvn clean install -Dmaven.test.skip 打包到本地maven仓库，在需要的地方执行引用此打包好的jar就ok了。 
 
 * 后续我会将这个starter改写为zk锁的服务