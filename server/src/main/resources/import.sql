-- password == username
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('ADMINFAN', 'Novi Sad', 'adminfan@adminfan', 'Ivan', '0635569989', '$2a$10$2z.t0mwY4P0/k7cHSQwMzu5Cj9usMkPLEN7ZHXbzNT7U4CEQk5vP2', 'Vukasinovic', 'adminfan',245, false ,true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('ADMINFAN', 'Beograd', 'adminfan2@adminfan2','Jovan', '0641569989', '$2a$10$ujoKDHyPmfaI.fQp1hCUo.hOY69jcjhPKiIRZbBnJhCY59aOohCIm', 'Jovic', 'adminfan2',100, false, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('ADMINSYS', 'Novi Sad', 'adminsys@adminsys', 'Vladimir', '063429989', '$2a$10$RO7l/vTjVfhh12dl5ax40uni/DuHzB/53kVxov/F6bM6hKzoIAxlC', 'Jovicic', 'adminsys',314, false, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('ADMINSHOW','Novi Sad', 'adminshow@adminshow', 'Marko', '0635565239', '$2a$10$CW3M.a.ikZbsvDVkwcTQfOKmluBCFM6oUjglbAWQIXYRplm0d/XIC', 'Krajinovic', 'adminshow',2, false, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('USER','Beograd', 'dejan@dejan', 'Dejan', '0615565239', '$2a$10$RiHre9rM0U19KWXUukNyWeNITpwVwPV98WyGpbHm4YqwGPpLE.VWy', 'Stojkic', 'dejan',22, false, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('USER','Novi Sad', 'milan@milan', 'Milan', '0645565239', '$2a$10$fbc8Mb9ec0Ig1M5D0R8zT.xMgF0E1r6li04ynzi/CKY3eev/vezH2', 'Stankovic', 'milan',45, false, true);
INSERT INTO user (role, city, email, name, number, password_hash, surname, username, points, changed_password,activated) VALUES ('ADMINSYS','Novi Grad', 'grad@milan', 'Grad', '0644565239', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'Stankovic', 'admin',567, false, true);

INSERT INTO friendship (prijatelj1,prijatelj2) VALUES('milan' , 'dejan');
INSERT INTO friendship (prijatelj1,prijatelj2) VALUES('dejan' , 'admin');
INSERT INTO friendship (prijatelj1,prijatelj2) VALUES('dejan' , 'adminfan');

INSERT INTO show_ct (name, type, address, description) VALUES ('Arena Cineplex', 'CINEMA', 'Bulevar Mihajla Pupina 3, 21000 Novi Sad', 'opis');
INSERT INTO show_ct (name, type, address, description) VALUES ('Narodno pozoriste', 'THEATRE', 'Pozorisni trg 1, 21000 Novi Sad', 'opis');
INSERT INTO show_ct (name, type, address, description) VALUES ('Narodni bioskop', 'CINEMA', 'Kralja Petra I, 25000 Sombor', 'opis');
INSERT INTO show_ct (name, type, address, description) VALUES ('Sinestar', 'CINEMA', 'Sentandrejski put 11, 21000 Novi Sad', 'opis');
INSERT INTO show_ct (name, type, address, description) VALUES ('Fontana', 'CINEMA', 'Pariske komune 13, 11000 Beograd', 'opis');
INSERT INTO show_ct (name, type, address, description) VALUES ('Krstarica', 'THEATRE', 'Trg Republike 1, 11000 Beograd', 'opis');
INSERT INTO show_ct (name, type, address, description) VALUES ('Narodno pozoriste', 'THEATRE', 'Francuska 3, 11000 Beograd', 'opis');

INSERT INTO playfilm_ct (name, actors, genre, director, duration, image_url, description, average_score, show_id) VALUES('The Departed', 'Leonadrdo DiCaprio, Matt Damon, Jack Nicholson', 'Crime, Drama', 'Martin Scorsese', '02:31', 'https://images-na.ssl-images-amazon.com/images/I/91yxj4w7jFL._RI_SX200_.jpg', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.', 0, 1);
INSERT INTO playfilm_ct (name, actors, genre, director, duration, image_url, description, average_score, show_id) VALUES('Fight Club', 'Bradd Pitt, Edward Norton', 'Drama', 'David Fincher', '02:19', 'https://i.ytimg.com/vi/amiyHvl0I4s/movieposter.jpg', 'An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soapmaker, forming an underground fight club that evolves into something much, much more.', 0, 1);

INSERT INTO auditorium (number, show_id) VALUES (1, 1);
INSERT INTO auditorium (number, show_id) VALUES (2, 1);

INSERT INTO seat (number, auditorium_id, segment) VALUES (1, 1, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (2, 1, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (3, 1, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (4, 1, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (5, 1, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (6, 1, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (1, 2, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (2, 2, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (3, 2, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (4, 2, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (5, 2, 'NORMAL');
INSERT INTO seat (number, auditorium_id, segment) VALUES (6, 2, 'NORMAL');


INSERT INTO repertoire (date, show_id) VALUES ('2018-04-01', 1);

INSERT INTO projection (price, time, auditorium_id, playfilm_id, repertoire_date, repertoire_show_id) VALUES (380, '15:30', 1, 1, '2018-04-01', 1);
INSERT INTO projection (price, time, auditorium_id, playfilm_id, repertoire_date, repertoire_show_id) VALUES (260, '15:30', 2, 1, '2018-04-01', 1);

INSERT INTO ticket (discount, projection_id, seat_id) VALUES (15, 1, 1);
INSERT INTO ticket (discount, projection_id, seat_id) VALUES (15, 1, 3);
INSERT INTO ticket (discount, projection_id, seat_id) VALUES (0, 2, 5);
INSERT INTO ticket (discount, projection_id, seat_id) VALUES (25, 2, 10);
INSERT INTO ticket (discount, projection_id, seat_id) VALUES (25, 2, 12);


INSERT INTO new_prop (id, version, date_created, description, title, price, fan_admin_fk,show_fk,image) VALUES (4, 0, '2018-01-29 00:55:56', 'Veoma glasna sirena', 'Sirena', 500, 1, 1,'https://www.hartsport.com.au/images/ProductImages/500/9-740.jpg');
INSERT INTO new_prop (id, version, date_created, description, title, price, fan_admin_fk,show_fk,image) VALUES (2, 0, '2018-01-24 03:55:56', 'Vise rekvizita po izboru', 'Sesir,naocare', 150, 1,1,'https://img1.etsystatic.com/000/0/6335667/il_fullxfull.301526529.jpg');

INSERT INTO used_prop (id, version, date_created, description, title, active_until, status, user_fk,image, accesstime) VALUES (1, 0, '2018-01-29 02:32:40', 'Polovne naocare Star Wars', 'Naocare Star Wars', '2018-05-29 02:32:45', 'WAITING', 5,'http://www.3dom3deyewear.com/wp-content/uploads/2012/07/LK3DSWEP1Angle.jpg', 0);
INSERT INTO used_prop (id, version, date_created, description, title, active_until, status, user_fk,fan_admin_fk,image, accesstime) VALUES (2, 0, '2018-01-29 02:32:40', 'Polovna plisana casa, pivo got.', 'Game of Thrones pivo ', '2018-4-29 02:32:45', 'APPROVED', 5,1,'https://pimg.tradeindia.com/02485272/b/2/Party-Prop-Got-Beer-Hat.jpg', 0);
INSERT INTO used_prop (id, version, date_created, description, title, active_until, status, user_fk,fan_admin_fk,image, accesstime) VALUES (3, 0, '2018-01-27 02:32:40', 'Polovna puska star wars.', 'Puska SW', '2018-05-15 02:32:45', 'APPROVED', 6,2,'http://www.volpinprops.com/wp-content/uploads/2012/07/AER9_3.jpg', 0);

INSERT INTO bid (version, accepted, date_created, price, used_prop_fk, user_fk) VALUES (0, 0, '2018-01-29 03:25:24', 250, 2, 4);
INSERT INTO bid (version, accepted, date_created, price, used_prop_fk, user_fk) VALUES (0, 0, '2018-02-01 17:25:24', 260, 2, 6);

INSERT INTO rating (date, bronze, silver, gold) VALUES ('2018-04-17 09:14:47', 100, 200, 400);