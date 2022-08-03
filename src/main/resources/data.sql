--insert into Article(id,title,content) values(1,'aaaa','1111');
--insert into Article(id,title,content) values(2,'bbbb','2222');
--insert into Article(id,title,content) values(3,'cccc','3333');
---- 22강: article 더미 데이터
--INSERT INTO article(id, title, content) VALUES(4, 'what is your favorite movie?', 'please comment');
--INSERT INTO article(id, title, content) VALUES(5, 'what is your favorite food?', 'please comment!');
--INSERT INTO article(id, title, content) VALUES(6, 'what is your hobby?', 'please comment!!!');
---- 22강: comment 더미 데이터
------ 4번 게시글의 댓글들
--INSERT INTO comment(id, article_id, nickname, body) VALUES(1, 4, 'Park', 'Good will hunting');
--INSERT INTO comment(id, article_id, nickname, body) VALUES(2, 4, 'Kim', 'I am sam');
--INSERT INTO comment(id, article_id, nickname, body) VALUES(3, 4, 'Choi', 'Shawshank Redemption');
------ 5번 게시글의 댓글들
--INSERT INTO comment(id, article_id, nickname, body) VALUES(4, 5, 'Park', 'chicken');
--INSERT INTO comment(id, article_id, nickname, body) VALUES(5, 5, 'Kim', 'sushi');
--INSERT INTO comment(id, article_id, nickname, body) VALUES(6, 5, 'Choi', 'hot pot');
------ 6번 게시글의 댓글들
--INSERT INTO comment(id, article_id, nickname, body) VALUES(7, 6, 'Park', 'jogging');
--INSERT INTO comment(id, article_id, nickname, body) VALUES(8, 6, 'Kim', 'youtube');
--INSERT INTO comment(id, article_id, nickname, body) VALUES(9, 6, 'Choi', 'reading');

insert into Article(title,content) values('aaaa','1111');
insert into Article(title,content) values('bbbb','2222');
insert into Article(title,content) values('cccc','3333');
INSERT INTO article(title, content) VALUES( 'what is your favorite movie?', 'please comment');
INSERT INTO article(title, content) VALUES( 'what is your favorite food?', 'please comment!');
INSERT INTO article(title, content) VALUES( 'what is your hobby?', 'please comment!!!');
-- 4번 게시글의 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', 'Good will hunting');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', 'I am sam');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', 'Shawshank Redemption');
---- 5번 게시글의 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', 'chicken');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', 'sushi');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', 'hot pot');
---- 6번 게시글의 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', 'jogging');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', 'youtube');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', 'reading');
