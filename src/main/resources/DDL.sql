--APPLICATION_FILM_SQL.sql

-- CANCELLAZIONE E CREAZIONE TABELLA FILM
drop table film cascade;

CREATE TABLE film (
	id_film serial,
	titolo varchar,
	anno_produzione INTEGER,
	id_regista INTEGER
);

ALTER TABLE film ADD PRIMARY KEY (id_film);

ALTER TABLE film 
ADD CONSTRAINT fk_film_actor 
FOREIGN KEY (id_film) REFERENCES film_attori (id_film);