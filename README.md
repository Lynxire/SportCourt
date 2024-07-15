
# SportCourt

Тестовое задание.


## Tech Stack
**Java:** 21+

**Spring:** Spring Boot - **version 3.3.1**, Spring Data, Spring Web

**Database:** Postgresql

**Builders:** Maven

**Libraries**: Mapstruct



## FAQ

#### Где можно посмотреть техническое задание ?
###### Техническое задание описано в файле "additions/Техническое задание.pdf"

#### Где скачать файл для импорта коллекции запросов в Postman?
###### Файл для импорта называется **"additions/SportCourt.postman_collection.json"**

#### Что за переменные в файле application.properties (DB_PASSWORD, DB_USERNAME, DB_HOST)?
###### Данные переменные используются для настройки подключения к БД вне локальной среды. Можно использовать для Docker, для описания к примеру в docker-compose

#### Как запустить проект локально?

###### В пункте **"Run Locally"** находится инструкция.


## Run Locally

Клонировать проект

```bash
  git clone https://github.com/Lynxire/SportCourt.git
```

Создать базу данных с названием **"sport"** в Posgresql

```sql
CREATE DATABASE sport;
```

Установить данные для подключения к БД: ```username = postgres, password = 1111``` или изменить в application.properties на своим данные

Открыть проект в **"IDEA"**

Запустить проект в **IDEA** через класс ``Main.class``


## Authors

- [@Lynxire](https://github.com/Lynxire)
## Contacts
- [Telegram](https://t.me/terabu)

