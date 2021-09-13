[TOC]

# Spring Bean装配
## 一、Beans配置方式
|配置方式|描述|
|:--|:--|
|XML|使用 XML 配置文件中的定义的bean和元素来注入 。|
|Annotation|通过代码中注解的方式来注入|

## 二、Beans自动装配
Spring可以通过XML配置文件来注入Beans，也可以通过Annotation(注解)的方式来实现注入，这种注入方式就是自动装配。自动装配的四种模式如下：
|模式|描述|
|:--|:--|
|no|no表示关闭自动装配选项，必须通过显示的设置才能确认依赖关系。这也是采用xml配置的默认选项。|
|byName|基于bean的名称name进行注入，在进行Bean的自动装配时，将属性的name在配置文件中搜索匹配的Bean,如果找到name一致的bean,则进行注入，如果找不打到，则会抛出异常。|
|byType||
|constructor||

### 1、基于XML配置实现装配
定义POJO:
用户 User.java
角色 Role.java
用户角色关系 UserRole.java
#### 1.1、XML配置
配置：week5-case1-1.xml

加载：XmlTest1.java

|属性|描述|
|:--|:--|
|constructor-arg|通过构造函数注入。|
|property|通过setter对应的方法注入。|

这种方式需要在xml中对每一个属性进行配置，首先通过constructor-arg装配了User，通过property装配Role。
UserRole对象的两个属性role和user通过property进行关联。这样就能实现spring中最基本的一种装配方式。 可以通过XmlTest1类进行测试，确认装配的正确性。

> UserRole(user=User(id=1, name=Java), role=Role(id=1, name=管理员))

#### 1.2、xml通过byName实现自动装配
配置：week5-case1-2.xml

加载：XmlTest2.java

这种装配方式不用在UserRole中指定user和role对应的具体类，需要增加一个属性：autowire="byName"，就能在自动装配的过程中。
将根据UserRole的属性的name查找context中name与之对应的bean进行装配。 测试结果如下：

> UserRole(user=null, role=Role(id=1, name=管理员))
> UserRole(user=User(id=1, name=Java), role=Role(id=1, name=管理员))

#### 1.3、xml通过byType实现自动装配
配置：week5-case1-3.xml

加载：XmlTest3.java

这种装配方式同样不用在UserRole中指定user和role对应的具体类，只需要增加一个属性：autowire="byType"，就能在自动装配的过程.
将根据UserRole成员变量的类型查找context中类型与之对应的bean进行装配。 需要注意的是，byName方式可以确保bean的唯一性，但是byType方式，无法确保bean的唯一性，如果出现多个bean的类型相同，则会报错。 测试结果如下：

> UserRole(user=User(id=1, name=Java), role=Role(id=1, name=管理员))

#### 1.4、xml通过constructor实现自动装配
配置：week5-case1-4.xml

加载：XmlTest4.java

这种装配方式同样不用在UserRole中指定user和role对应的具体类，只需要增加一个属性：autowire="constructor"，并配置constructor-arg，就能在自动装配的过程.
将根据UserRole构造函数参数表constructor-arg配置的name查找context中name与之对应的bean进行装配。 测试结果如下
> UserRole(user=User(id=1, name=Java), role=Role(id=1, name=管理员))
>
>
### 2、基于注解的配置装配

从 Spring 2.5 开始就可以使用注解来配置依赖注入。
而不是采用XML来描述一个bean依赖，你可以使用相关类，方法或字段声明的注解，将 bean 配置移动到组件类本身。
在XML注入之前进行注解注入，因此后者的配置将通过两种方式的属性连线被前者重写。
注解依赖在默认情况下在Spring容器中不打开。因此，在可以使用基于注解的连线之前，我们将需要在我们的 Spring 配置文件中启用它。
所以如果你想在 Spring 应用程序中使用的任何注解，可以考虑到下面的配置文件。
```java
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">

   <context:annotation-config/>
   <!-- bean definitions go here -->

</beans>
```

一旦 被配置后，你就可以开始注解你的代码，表明 Spring 应该自动连接值到属性，方法和构造函数。让我们来看看几个重要的注解，并且了解它们是如何工作的。

|注解|描述|
|:--|:--|
|@Required|@Required 注解应用于 bean 属性的 setter 方法。|
|@Autowired|@Autowired 注解可以应用到 bean 属性的 setter 方法，非 setter 方法，构造函数和属性。|
|@Qualifier|通过指定确切的将被连线的 bean，@Autowired 和 @Qualifier 注解可以用来删除混乱。|
|JSR-250 Annotations|Spring 支持 JSR-250 的基础的注解，其中包括了 @Resource，@PostConstruct 和 @PreDestroy 注解。|

##### 2.1、@Required注解
@Required 注释应用于 bean 属性的 setter 方法，它表明受影响的 bean 属性在配置时必须放在 XML 配置文件中，否则容器就会抛出一个 BeanInitializationException 异常

配置：week5-case2.xml

加载：BeanDemo.java

用户：User.java

经过实际测试，User bean里这个setter方法的@Required注解，加或不加，结果都一致。

>User(id=null, name=Java)

##### 2.2、@Autowired注解

@Autowired 注释对在哪里和如何完成自动连接提供了更多的细微的控制。

@Autowired 注释可以在 setter 方法中被用于自动连接 bean，就像 @Autowired 注释，容器，一个属性或者任意命名的可能带有多个参数的方法。

Setter 方法中的 @Autowired

你可以在 XML 文件中的 setter 方法中使用 @Autowired 注释来除去元素。

当 Spring遇到一个在 setter 方法中使用的 @Autowired 注释，它会在方法中视图执行 byType 自动连接。


配置：week5-case2.xml<br/>
加载：BeanDemo.java<br/>
用户：User.java<br/>
角色：Role.java<br/>
用户角色：UserRole.java<br/>

**属性中的 @Autowired**
<br/>
你可以在属性中使用 @Autowired 注释来除去 setter 方法。当时使用 为自动连接属性传递的时候，Spring 会将这些传递过来的值或者引用自动分配给那些属性。<br/>
所以利用在属性中 @Autowired 的用法，你的 UserRole.java 文件将变成如下所示：<br/>
```java
package com.chg.geekbang.study.week5.springbean.case2;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRole {
    @Autowired
    private User user;
    
    @Autowired
    private Role role;
}
```

**构造函数中的 @Autowired**
<br/>
你也可以在构造函数中使用 @Autowired。一个构造函数 @Autowired 说明当创建 bean 时，即使在 XML 文件中没有使用 元素配置 bean ，

```java
package com.chg.geekbang.study.week5.springbean.case2;
import org.springframework.beans.factory.annotation.Autowired;
public class UserRole {
    private User user;
    private Role role;

    @Autowired
    public UserRole(User user,Role role){
        this.role = role;
        this.user = user;
    }
}
```

输出：
```java
User(id=1, name=java)
com.chg.geekbang.study.week5.springbean.case2.UserRole@25a65b77
```

**@Autowired 的（required=false）选项**
<br/>
默认情况下，@Autowired 注释意味着依赖是必须的，它类似于 @Required 注释，然而，你可以使用 @Autowired 的 （required=false） 选项关闭默认行为。<br/>
即使你不为 age 属性传递任何参数，下面的示例也会成功运行，但是对于 name 属性则需要一个参数。你可以自己尝试一下这个示例，因为除了只有 User.java 文件被修改以外，它和 @Required 注释示例是相似的。

##### 2.3 @Resource实现装配
