Swagger url :
http://localhost:8080/swagger-ui/index.html

You can test all the endpoints there.

The file in resources called Data.sql, has initial data to application:

```
insert into car values (1001,0, 'BMW', false, null);
insert into car values (1002, 1, 'Kia Sorento', false, null);
insert into car values (1003, 1, 'Nissan Juke', false, null);
insert into car values (1004, 2, 'Seat Ibiza', false, null);
insert into users values(1002, 'testuser');
```