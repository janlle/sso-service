# sso-service

## OAuth

开放授权（OAuth）是一个开放标准，允许用户让第三方应用访问该用户在某一网站上存储的私密的资源（如照片，视频，联系人列表），而无需将用户名和密码提供给第三方应用。

OAuth允许用户提供一个令牌，而不是用户名和密码来访问他们存放在特定服务提供者的数据。每一个令牌授权一个特定的网站（例如，视频编辑网站)在特定的时段（例如，接下来的2小时内）内访问特定的资源（例如仅仅是某一相册中的视频）。这样，OAuth让用户可以授权第三方网站访问他们存储在另外服务提供者的某些特定信息，而非所有内容。OAuth是OpenID的一个补充，但是完全不同的服务。

## OAuth2.0

OAuth 2.0是OAuth协议的下一版本，但不向下兼容OAuth 1.0。OAuth 2.0关注客户端开发者的简易性，同时为Web应用、桌面应用、手机和智能设备提供专门的认证流程。

Facebook的新的Graph API只支持OAuth 2.0，Google在2011年3月也宣布Google API对OAuth 2.0的支持，Windows Live也支持OAuth 2.0。


**名词定义**

* 1、Third-party application：第三方应用程序，本文中又称"客户端"（client）。

* 2、HTTP service：HTTP服务提供商，本文中简称"服务提供商"。

* 3、Resource Owner：资源所有者，本文中又称"用户"（user）。

* 4、User Agent：用户代理，本文中就是指浏览器。

* 5、Authorization server：认证服务器，即服务提供商专门用来处理认证的服务器。

* 6、Resource server：资源服务器，即服务提供商存放用户生成的资源的服务器。它与认证服务器，可以是同一台服务器，也可以是不同的服务器。


**OAuth的思路**

OAuth在"客户端"与"服务提供商"之间，设置了一个授权层（authorization layer）。"客户端"不能直接登录"服务提供商"，只能登录授权层，以此将用户与客户端区分开来。"客户端"登录授权层所用的令牌（token），与用户的密码不同。用户可以在登录的时候，指定授权层令牌的权限范围和有效期。

"客户端"登录授权层以后，"服务提供商"根据令牌的权限范围和有效期，向"客户端"开放用户储存的资料。


**OAuth授权模式**

* 1、授权码模式（authorization code）

* 2、简化模式（implicit）

* 3、密码模式（resource owner password credentials）

* 4、客户端模式（client credentials）


## 授权码模式

授权码模式（authorization code）是功能最完整、流程最严密的授权模式。它的特点就是通过客户端的后台服务器，与"服务提供商"的认证服务器进行互动。

![授权码模式流程图](https://s2.ax1x.com/2019/04/26/Em12IP.md.png)


**授权步骤**

* 1、用户访问客户端，客户端将用户导向认证服务器。

* 2、用户选择是否给予客户端授权。

* 3、假设用户给予授权，认证服务器将用户导向客户端事先指定的"重定向URI"（redirection URI），同时附上一个授权码。

* 4、客户端收到授权码，附上早先的"重定向URI"，向认证服务器申请令牌。这一步是在客户端的后台的服务器上完成的，对用户不可见。

* 5、认证服务器核对了授权码和重定向URI，确认无误后，向客户端发送访问令牌（access token）和更新令牌（refresh token）。

下面是上面这些步骤所需要的参数，1步骤中，客户端申请认证的URI，包含以下参数：

response_type：表示授权类型，必选项，此处的值固定为"code"
client_id：表示客户端的ID，必选项
redirect_uri：表示重定向URI，可选项
scope：表示申请的权限范围，可选项
state：表示客户端的当前状态，可以指定任意值，认证服务器会原封不动地返回这个值。

spring security密码配置问题

secret密码配置从 Spring Security 5.0开始必须以 {加密方式}+加密后的密码 这种格式填写
当前版本5新增支持加密方式：
bcrypt - BCryptPasswordEncoder (Also used for encoding)

ldap - LdapShaPasswordEncoder

MD4 - Md4PasswordEncoder

MD5 - new MessageDigestPasswordEncoder(“MD5”)

noop - NoOpPasswordEncoder

pbkdf2 - Pbkdf2PasswordEncoder

scrypt - SCryptPasswordEncoder

SHA-1 - new MessageDigestPasswordEncoder(“SHA-1”)

SHA-256 - new MessageDigestPasswordEncoder(“SHA-256”)

sha256 - StandardPasswordEncoder
