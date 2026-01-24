# SOA_Lab2Spring - Multi-Module EJB Application

## Структура проекта

Проект разделен на два модуля:
- **ejb-module**: Содержит Stateless EJB с Remote интерфейсом и бизнес-логику
- **web-module**: Содержит JAX-RS веб-сервис, который вызывает методы EJB

## Сборка проекта

```bash
mvn clean install
```

## Развертывание

### Экземпляр 1 (порт 8080)
1. Скопируйте `web-module/target/Lab2Spring.war` в `$WILDFLY_HOME/standalone/deployments/`
2. Запустите WildFly: `./standalone.sh`

### Экземпляр 2 (порт 8081)
1. Скопируйте `web-module/target/Lab2Spring.war` в `$WILDFLY_HOME/standalone/deployments/`
2. Запустите WildFly с offset: `./standalone.sh -Djboss.socket.binding.port-offset=100`

## Настройка пула EJB

Пул EJB настраивается в файлах:
- `ejb-module/src/main/resources/META-INF/ejb-jar.xml`
- `ejb-module/src/main/resources/META-INF/jboss-ejb3.xml`

Также необходимо настроить пул в `standalone.xml`:
```xml
<strict-max-bean-instance-pools>
    <slsb-strict-max-pool name="slsb-strict-max-pool" 
                          max-pool-size="20" 
                          instance-acquisition-timeout="5" 
                          instance-acquisition-timeout-unit="MINUTES"/>
</strict-max-bean-instance-pools>
```

## HAProxy

Конфигурация HAProxy находится в файле `haproxy.cfg`.

Запуск HAProxy:
```bash
haproxy -f haproxy.cfg
```

HAProxy будет слушать на порту 8444 и балансировать нагрузку между:
- localhost:8080 (экземпляр 1)
- localhost:8081 (экземпляр 2)
