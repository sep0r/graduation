## Выпускной проект
Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it.

----------
#### Votes cURL commands:

### *Get result for curent day
* `curl -s http://localhost:8080/graduation/rest/profile/votes/result --user user1@yandex.ru:password`

### *Get number Of votes for restaurants by date
* `curl -s http://localhost:8080/graduation/rest/admin/votes/?date=2020-05-20 --user admin@gmail.com:admin`

### *Get result for date
* `curl -s http://localhost:8080/graduation/rest/admin/votes/result?date=2020-05-21 --user admin@gmail.com:admin`

### *Create vote for the restaurant with id 100005
* `curl -s -X POST -d http://localhost:8080/graduation/rest/profile/votes/100005 --user user1@yandex.ru:password`

### *Delete vote
* `curl -s -X DELETE http://localhost:8080/graduation/rest/admin/votes/100029/users/100000 --user admin@gmail.com:admin`
----------

#### Users cURL commands:

### register Users

`curl -s -i -X POST -d '{"name":"New User","email":"test@mail.ru","password":"test-password"}' -H 'Content-Type:application/json' http://localhost:8080/graduation/rest/profile/register`

###Admin cURL commands:

- get all Users:
    
> `curl -s http://localhost:8080/graduation/rest/admin/users --user admin@gmail.com:admin`

- get user 100000:
    
> `curl -s http://localhost:8080/graduation/rest/admin/users/100000 --user admin@gmail.com:admin`

- create user:
    
> `curl -s -X POST -d '{"name":"New User3","email":"test3@mail.ru","password":"test-password"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/graduation/rest/admin/users/ --user admin@gmail.com:admin`

- get user 100000 with-votes:
    
> `curl -s http://localhost:8080/graduation/rest/admin/users/100000/with-votes --user admin@gmail.com:admin`

- delete user 100002:

> `curl -s -X DELETE http://localhost:8080/graduation/rest/admin/users/100002 --user admin@gmail.com:admin`

###Profile cURL commands:

- get profile of authorized user:
    
> `curl -s http://localhost:8080/graduation/rest/profile/ --user user1@yandex.ru:password1`

- delete profile:

> `curl -s -X DELETE http://localhost:8080/graduation/rest/profile --user user1@yandex.ru:password1`

-  update profile:

> `curl -s -X PUT -d '{"name":"user1","email":"test1@mail.ru","password":"test-password"}' -H 'Content-Type: application/json' http://localhost:8080/graduation/rest/profile/ --user user1@yandex.ru:password1`
----------

#### Restaurant cURL commands:

###Admin cURL commands:

- create restaurant:
    
> `curl -s -X POST -d '{"name": "New Restaurant3","description": "description new"}' -H 'Content-Type:application/json' http://localhost:8080/graduation/rest/admin/restaurants/ --user  admin@gmail.com:admin`

-  update restaurant 100004

> `curl -s -X PUT -d '{"name": "updated restaurant","description": "description of updated restaurant"}' -H 'Content-Type: application/json' http://localhost:8080/graduation/rest/admin/restaurants/100004 --user admin@gmail.com:admin`

- delete restaurant 100004:

> `curl -s -X DELETE http://localhost:8080/graduation/rest/admin/restaurants/100004 --user admin@gmail.com:admin`

###Profile cURL commands:

- get all restaurants:
    
> `curl -s http://localhost:8080/graduation/rest/profile/restaurants --user1@yandex.ru:password1`

- get restaurant 100005:
    
> `curl -s http://localhost:8080/graduation/rest/profile/restaurants/100005 --user1@yandex.ru:password1`

- get restaurant 100005 with menu:
    
> `curl -s http://localhost:8080/graduation/rest/profile/restaurants/100005/with-menu --user1@yandex.ru:password1`

- get all restaurants with menu:
    
> `curl -s http://localhost:8080/graduation/rest/profile/restaurants/with-menu --user1@yandex.ru:password1`
----------

#### Menu cURL commands:

###Admin cURL commands:

- get all menu for the restaurant 100005

> `curl -s http://localhost:8080/graduation/rest/admin/restaurants/menu/100005 --user admin@gmail.com:admin`

- delete menu 100010

> `curl -s -X DELETE http://localhost:8080/graduation/rest/admin/restaurants/menu/100010 --user admin@gmail.com:admin`

- get all menu by date

> `curl -s http://localhost:8080/graduation/rest/admin/restaurants/menu/bydate?date=2020-05-21 --user admin@gmail.com:admin`

- create menu for restaurant 100004

> `curl -s -X POST -d '{"date": "2020-05-22"}' -H 'Content-Type:application' http://localhost:8080/graduation/rest/admin/restaurants/menu/100004 --user  admin@gmail.com:admin`

-  update menu 100004

> `curl -s -X PUT -d '{"date": "2020-05-20"}' -H 'Content-Type: application/json' http://localhost:8080/graduation/rest/admin/restaurants/menu/100004 --user admin@gmail.com:admin`

###Profile cURL commands:

- get menu 100009 of the restaurant 100004

> `curl -s http://localhost:8080/graduation/rest/admin/restaurants/menu/100009/for/100004 --user user1@yandex.ru:password1`

- get all menu today

> `curl -s http://localhost:8080/graduation/rest/profile/restaurants/menu/today --user user1@yandex.ru:password1`

- get all menu for the restaurant 100005

> `curl -s http://localhost:8080/graduation/rest/profile/restaurants/menu/for/100005 --user user1@yandex.ru:password1`
----------

#### Dish cURL commands:

###Admin cURL commands:

- create dish for menu 100009

> `curl -s -X POST -d '{"name": "New Salad", "price": 400}' -H 'Content-Type:application' http://localhost:8080/graduation/rest/admin/menu/100009/dishes/ --user  admin@gmail.com:admin`

- get dish 100020 from menu 100009

> `curl -s http://localhost:8080/graduation/rest/admin/menu/100009/dishes/100020 --user admin@gmail.com:admin`

- delete dish 100015 from menu 100010

> `curl -s -X DELETE http://localhost:8080/graduation/rest/admin/menu/100010/dishes/100015 --user admin@gmail.com:admin`

###Profile cURL commands:

- get all dishes from menu 100009

> `curl -s http://localhost:8080/graduation/rest/profile/menu/100009/dishes --user user1@yandex.ru:password1`
