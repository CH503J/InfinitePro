# InfinitePro配置

## 一、Nacos配置中心设置

   在项目中使用Nacos作为配置中心，需要进行以下配置：

   a. 添加依赖：
      在pom.xml中添加Spring Cloud Alibaba Nacos Config依赖：
      ```xml
      <dependency>
          <groupId>com.alibaba.cloud</groupId>
          <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
      </dependency>
      ```

   b. 配置文件设置：
      在bootstrap.yml中添加Nacos配置中心相关配置：
      ```yaml
      spring:
        application:
          name: infinitepro-service  # 应用名称
        cloud:
          nacos:
            config:
              server-addr: 127.0.0.1:8848  # Nacos服务器地址
              file-extension: yaml  # 配置文件格式，支持yaml和properties
              group: DEFAULT_GROUP  # 配置分组
              namespace:  # 命名空间，用于环境隔离
      ```

2. 配置密钥和值的管理

   Nacos中的配置可以以密钥-值（Key-Value）的形式存储，这些配置可以在Nacos的配置管理界面中直接编辑，也可以通过配置文件进行管理：

   a. 在Nacos配置中心界面中配置：
      - 登录Nacos控制台
      - 进入"配置管理"->"配置列表"
      - 点击"＋"号添加配置或编辑现有配置
      - 在"data ID"中输入配置标识，如：infinitepro-service.yaml
      - 在"配置格式"中选择对应的格式（YAML/Properties）
      - 在配置内容区域添加配置项，例如：
        ```yaml
        app:
          name: InfinitePro
          version: 1.0.0
        datasource:
          url: jdbc:mysql://localhost:3306/infinitepro
          username: root
          password: password
        ```

   b. 通过conf目录中的properties文件配置：
      除了在Nacos界面中配置，也可以在本地conf目录下创建properties文件进行配置管理：
      - 在项目根目录下创建conf文件夹
      - 在conf目录下创建配置文件，如application.properties：
        ```properties
        # 应用配置
        app.name=InfinitePro
        app.version=1.0.0
        
        # 数据源配置
        datasource.url=jdbc:mysql://localhost:3306/infinitepro
        datasource.username=root
        datasource.password=password
        
        # Nacos配置
        spring.cloud.nacos.config.server-addr=127.0.0.1:8848
        spring.cloud.nacos.config.file-extension=properties
        ```
      - 这些配置文件可以在应用启动时加载，也可以在运行时动态更新

3. 使用配置

   在代码中使用Nacos配置中心的值：
   ```java
   @Component
   public class ConfigService {
       
       @Value("${app.name}")
       private String appName;
       
       @Value("${app.version}")
       private String appVersion;
       
       // 使用配置...
   }
   ```

   或者通过@ConfigurationProperties注解批量注入配置：
   ```java
   @Component
   @ConfigurationProperties(prefix = "app")
   public class AppProperties {
       private String name;
       private String version;
       
       // getters and setters...
   }
   ```