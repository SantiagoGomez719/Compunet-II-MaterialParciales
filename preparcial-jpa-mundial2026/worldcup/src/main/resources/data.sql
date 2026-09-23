-- Datos de PRUEBA que reproducen los ejemplos del enunciado (los puntajes FIFA son inventados)

INSERT INTO country (id, name, code, confederation) VALUES (1, 'Argentina', 'ARG', 'CONMEBOL');
INSERT INTO country (id, name, code, confederation) VALUES (2, 'Francia', 'FRA', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (3, 'Noruega', 'NOR', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (4, 'Bélgica', 'BEL', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (5, 'Inglaterra', 'ENG', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (6, 'Portugal', 'POR', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (7, 'Colombia', 'COL', 'CONMEBOL');
INSERT INTO country (id, name, code, confederation) VALUES (8, 'Croacia', 'CRO', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (9, 'Ghana', 'GHA', 'CAF');
INSERT INTO country (id, name, code, confederation) VALUES (10, 'RD Congo', 'COD', 'CAF');
INSERT INTO country (id, name, code, confederation) VALUES (11, 'Brasil', 'BRA', 'CONMEBOL');
INSERT INTO country (id, name, code, confederation) VALUES (12, 'Uruguay', 'URU', 'CONMEBOL');
INSERT INTO country (id, name, code, confederation) VALUES (13, 'España', 'ESP', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (14, 'Alemania', 'GER', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (15, 'Italia', 'ITA', 'UEFA');
INSERT INTO country (id, name, code, confederation) VALUES (16, 'Arabia Saudita', 'KSA', 'AFC');
INSERT INTO country (id, name, code, confederation) VALUES (17, 'Estados Unidos', 'USA', 'CONCACAF');

INSERT INTO club (id, name, city, founded, country_id) VALUES (1, 'Real Madrid', 'Madrid', '1902-03-06', 13);
INSERT INTO club (id, name, city, founded, country_id) VALUES (2, 'Manchester United', 'Manchester', '1878-01-01', 5);
INSERT INTO club (id, name, city, founded, country_id) VALUES (3, 'Liverpool', 'Liverpool', '1892-06-03', 5);
INSERT INTO club (id, name, city, founded, country_id) VALUES (4, 'Bayern Munich', 'Munich', '1900-02-27', 14);
INSERT INTO club (id, name, city, founded, country_id) VALUES (5, 'Juventus', 'Turin', '1897-11-01', 15);
INSERT INTO club (id, name, city, founded, country_id) VALUES (6, 'Porto', 'Porto', '1893-09-28', 6);
INSERT INTO club (id, name, city, founded, country_id) VALUES (7, 'Al Nassr', 'Riyadh', '1955-10-14', 16);
INSERT INTO club (id, name, city, founded, country_id) VALUES (8, 'Minnesota United', 'Saint Paul', '2007-01-01', 17);
INSERT INTO club (id, name, city, founded, country_id) VALUES (9, 'Manchester City', 'Manchester', '1880-01-01', 5);
INSERT INTO club (id, name, city, founded, country_id) VALUES (10, 'Inter Miami', 'Miami', '2018-01-29', 17);
INSERT INTO club (id, name, city, founded, country_id) VALUES (11, 'Napoli', 'Naples', '1926-08-01', 15);

INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (1, 'Lionel Messi', '1987-06-24', 'Delantero', 92, 1);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (2, 'Kylian Mbappe', '1998-12-20', 'Delantero', 91, 2);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (3, 'Erling Haaland', '2000-07-21', 'Delantero', 90, 3);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (4, 'Kevin De Bruyne', '1991-06-28', 'Mediocampista', 89, 4);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (5, 'Jude Bellingham', '2003-06-29', 'Mediocampista', 88, 5);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (6, 'Harry Kane', '1993-07-28', 'Delantero', 87, 5);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (7, 'Cristiano Ronaldo', '1985-02-05', 'Delantero', 86, 6);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (8, 'Diogo Costa', '1999-09-19', 'Portero', 83, 6);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (9, 'Luis Diaz', '1997-01-13', 'Delantero', 84, 7);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (10, 'James Rodriguez', '1991-07-12', 'Mediocampista', 78, 7);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (11, 'Vinicius Jr', '2000-07-12', 'Delantero', 85, 11);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (12, 'Rodrygo Goes', '2001-01-09', 'Delantero', 82, 11);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (13, 'Federico Valverde', '1998-07-22', 'Mediocampista', 84, 12);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (14, 'Luka Modric', '1985-09-09', 'Mediocampista', 83, 8);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (15, 'Mohammed Kudus', '2000-08-02', 'Mediocampista', 80, 9);
INSERT INTO player (id, name, birth_date, position, fifa_score, country_id) VALUES (16, 'Yoane Wissa', '1996-09-03', 'Delantero', 75, 10);

-- end_date NULL = pertenece actualmente al club
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (1, 10, '2023-07-15', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (2, 1, '2024-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (3, 9, '2022-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (4, 9, '2015-08-30', '2025-06-30');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (4, 11, '2025-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (5, 1, '2023-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (6, 4, '2023-08-12', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (7, 2, '2003-08-12', '2009-07-01');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (7, 1, '2009-07-01', '2018-07-10');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (7, 5, '2018-07-10', '2021-08-31');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (7, 2, '2021-08-31', '2022-11-22');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (7, 7, '2023-01-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (8, 6, '2019-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (9, 3, '2022-01-30', '2025-07-01');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (9, 4, '2025-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (10, 1, '2014-07-22', '2020-09-04');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (10, 4, '2017-07-11', '2019-06-30');
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (10, 8, '2025-08-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (11, 1, '2018-07-12', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (12, 1, '2019-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (13, 1, '2016-07-01', NULL);
INSERT INTO player_club (player_id, club_id, start_date, end_date) VALUES (14, 1, '2012-08-27', NULL);

INSERT INTO match (id, match_date, home_country_id, away_country_id, stadium) VALUES (1, '2026-06-17', 5, 8, 'AT&T Stadium');
INSERT INTO match (id, match_date, home_country_id, away_country_id, stadium) VALUES (2, '2026-06-23', 5, 9, 'Gillette Stadium');
INSERT INTO match (id, match_date, home_country_id, away_country_id, stadium) VALUES (3, '2026-06-17', 7, 10, 'Estadio Akron');
INSERT INTO match (id, match_date, home_country_id, away_country_id, stadium) VALUES (4, '2026-06-23', 7, 6, 'Estadio Azteca');
INSERT INTO match (id, match_date, home_country_id, away_country_id, stadium) VALUES (70, '2026-06-27', 6, 7, 'Hard Rock Stadium');
