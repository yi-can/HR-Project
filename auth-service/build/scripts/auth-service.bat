@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  auth-service startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and AUTH_SERVICE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\auth-service-v.0.0.1-plain.jar;%APP_HOME%\lib\spring-boot-starter-web-2.7.14.jar;%APP_HOME%\lib\lombok-1.18.28.jar;%APP_HOME%\lib\mapstruct-1.5.5.Final.jar;%APP_HOME%\lib\springdoc-openapi-ui-1.6.15.jar;%APP_HOME%\lib\spring-boot-starter-validation-2.7.14.jar;%APP_HOME%\lib\java-jwt-4.4.0.jar;%APP_HOME%\lib\spring-cloud-starter-openfeign-3.1.8.jar;%APP_HOME%\lib\spring-cloud-starter-sleuth-3.1.8.jar;%APP_HOME%\lib\spring-boot-starter-amqp-2.7.14.jar;%APP_HOME%\lib\spring-boot-starter-data-redis-2.7.14.jar;%APP_HOME%\lib\postgresql-42.6.0.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-2.7.14.jar;%APP_HOME%\lib\spring-boot-starter-json-2.7.12.jar;%APP_HOME%\lib\spring-cloud-starter-3.1.7.jar;%APP_HOME%\lib\spring-cloud-openfeign-core-3.1.8.jar;%APP_HOME%\lib\spring-boot-starter-aop-2.7.12.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-2.7.12.jar;%APP_HOME%\lib\spring-boot-starter-2.7.12.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.7.12.jar;%APP_HOME%\lib\springdoc-openapi-webmvc-core-1.6.15.jar;%APP_HOME%\lib\spring-webmvc-5.3.27.jar;%APP_HOME%\lib\springdoc-openapi-common-1.6.15.jar;%APP_HOME%\lib\feign-form-spring-3.8.0.jar;%APP_HOME%\lib\spring-web-5.3.27.jar;%APP_HOME%\lib\swagger-ui-4.17.1.jar;%APP_HOME%\lib\webjars-locator-core-0.50.jar;%APP_HOME%\lib\classgraph-4.8.149.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.75.jar;%APP_HOME%\lib\hibernate-validator-6.2.5.Final.jar;%APP_HOME%\lib\swagger-core-2.2.8.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.5.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.13.5.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.13.5.jar;%APP_HOME%\lib\jackson-core-2.13.5.jar;%APP_HOME%\lib\swagger-models-2.2.8.jar;%APP_HOME%\lib\jackson-annotations-2.13.5.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.13.5.jar;%APP_HOME%\lib\jackson-databind-2.13.5.jar;%APP_HOME%\lib\spring-cloud-sleuth-autoconfigure-3.1.8.jar;%APP_HOME%\lib\spring-cloud-sleuth-brave-3.1.8.jar;%APP_HOME%\lib\spring-cloud-sleuth-instrumentation-3.1.8.jar;%APP_HOME%\lib\spring-cloud-commons-3.1.7.jar;%APP_HOME%\lib\feign-slf4j-11.10.jar;%APP_HOME%\lib\feign-core-11.10.jar;%APP_HOME%\lib\spring-rabbit-2.4.12.jar;%APP_HOME%\lib\spring-messaging-5.3.27.jar;%APP_HOME%\lib\spring-data-redis-2.7.12.jar;%APP_HOME%\lib\lettuce-core-6.1.10.RELEASE.jar;%APP_HOME%\lib\checker-qual-3.31.0.jar;%APP_HOME%\lib\jakarta.transaction-api-1.3.3.jar;%APP_HOME%\lib\jakarta.persistence-api-2.2.3.jar;%APP_HOME%\lib\hibernate-core-5.6.15.Final.jar;%APP_HOME%\lib\spring-data-jpa-2.7.12.jar;%APP_HOME%\lib\spring-aspects-5.3.27.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.7.12.jar;%APP_HOME%\lib\spring-boot-2.7.12.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.7.12.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.5.jar;%APP_HOME%\lib\spring-data-keyvalue-2.7.12.jar;%APP_HOME%\lib\spring-context-support-5.3.27.jar;%APP_HOME%\lib\spring-context-5.3.27.jar;%APP_HOME%\lib\spring-aop-5.3.27.jar;%APP_HOME%\lib\spring-orm-5.3.27.jar;%APP_HOME%\lib\spring-jdbc-5.3.27.jar;%APP_HOME%\lib\spring-tx-5.3.27.jar;%APP_HOME%\lib\spring-oxm-5.3.27.jar;%APP_HOME%\lib\spring-data-commons-2.7.12.jar;%APP_HOME%\lib\spring-beans-5.3.27.jar;%APP_HOME%\lib\spring-expression-5.3.27.jar;%APP_HOME%\lib\spring-amqp-2.4.12.jar;%APP_HOME%\lib\spring-core-5.3.27.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.75.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.75.jar;%APP_HOME%\lib\amqp-client-5.14.2.jar;%APP_HOME%\lib\HikariCP-4.0.3.jar;%APP_HOME%\lib\logback-classic-1.2.12.jar;%APP_HOME%\lib\log4j-to-slf4j-2.17.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.36.jar;%APP_HOME%\lib\feign-form-3.8.0.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\hibernate-commons-annotations-5.1.2.Final.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\spring-cloud-context-3.1.7.jar;%APP_HOME%\lib\spring-security-rsa-1.0.11.RELEASE.jar;%APP_HOME%\lib\commons-fileupload-1.5.jar;%APP_HOME%\lib\spring-security-crypto-5.7.8.jar;%APP_HOME%\lib\aspectjweaver-1.9.7.jar;%APP_HOME%\lib\aspectjrt-1.9.7.jar;%APP_HOME%\lib\brave-context-slf4j-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-spring-rabbit-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-kafka-streams-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-kafka-clients-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-jms-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-messaging-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-rpc-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-httpclient-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-httpasyncclient-5.13.9.jar;%APP_HOME%\lib\brave-instrumentation-mongodb-5.13.9.jar;%APP_HOME%\lib\brave-propagation-aws-0.21.3.jar;%APP_HOME%\lib\brave-instrumentation-http-5.13.9.jar;%APP_HOME%\lib\brave-5.13.9.jar;%APP_HOME%\lib\zipkin-reporter-metrics-micrometer-2.16.3.jar;%APP_HOME%\lib\netty-handler-4.1.92.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.92.Final.jar;%APP_HOME%\lib\netty-codec-4.1.92.Final.jar;%APP_HOME%\lib\netty-transport-4.1.92.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.92.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.92.Final.jar;%APP_HOME%\lib\netty-common-4.1.92.Final.jar;%APP_HOME%\lib\reactor-core-3.4.29.jar;%APP_HOME%\lib\byte-buddy-1.12.23.jar;%APP_HOME%\lib\antlr-2.7.7.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\jaxb-runtime-2.3.8.jar;%APP_HOME%\lib\spring-jcl-5.3.27.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.69.jar;%APP_HOME%\lib\commons-io-2.11.0.jar;%APP_HOME%\lib\spring-cloud-sleuth-api-3.1.8.jar;%APP_HOME%\lib\zipkin-reporter-2.16.3.jar;%APP_HOME%\lib\spring-retry-1.3.4.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.3.jar;%APP_HOME%\lib\txw2-2.3.8.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.12.jar;%APP_HOME%\lib\jakarta.activation-1.2.2.jar;%APP_HOME%\lib\logback-core-1.2.12.jar;%APP_HOME%\lib\log4j-api-2.17.2.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\swagger-annotations-2.2.8.jar;%APP_HOME%\lib\bcutil-jdk15on-1.69.jar;%APP_HOME%\lib\bcprov-jdk15on-1.69.jar;%APP_HOME%\lib\zipkin-2.23.2.jar


@rem Execute auth-service
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %AUTH_SERVICE_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable AUTH_SERVICE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%AUTH_SERVICE_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
