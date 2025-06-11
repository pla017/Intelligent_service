# 幸福管理系统

## 环境要求


### 基础环境
- JDK 1.8+
- Maven 3.0+
- MySQL 5.7+
- Redis 6.0+
- Node.js 16+

### 开发环境配置

#### 1. JDK配置
```bash
# 检查JDK版本
java -version

# 配置JAVA_HOME环境变量
export JAVA_HOME=/path/to/your/jdk
export PATH=$JAVA_HOME/bin:$PATH
```

#### 2. MySQL配置
```bash
# 启动MySQL服务
# MacOS
brew services start mysql

# 创建数据库
mysql -u root -p
CREATE DATABASE ruoyi DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

# 导入数据库脚本
mysql -u root -p ruoyi < sql/ry-vue.sql
```

#### 3. Redis配置
```bash
# 启动Redis服务
# MacOS
brew services start redis

# 检查Redis状态
redis-cli ping
```

## 项目启动

### 后端启动
```bash
# 进入项目根目录
cd /path/to/project

# 编译项目
mvn clean install

# 启动项目
mvn spring-boot:run -pl ruoyi-admin
```

### 前端启动
```bash
# 进入前端项目目录
cd RuoYi-Vue3

# 安装依赖
yarn --registry=https://registry.npmmirror.com

# 启动服务
yarn dev
```

## 访问地址
- 前端访问地址：http://localhost:80
- 后端接口地址：http://localhost:8080

## 默认账号
- 管理员账号：admin
- 管理员密码：admin123
