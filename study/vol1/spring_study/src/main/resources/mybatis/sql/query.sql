drop table t_board;

create table t_board (
                         board_seq IDENTITY NOT NULL PRIMARY KEY ,
                         title varchar,
                         contents varchar,
                         reg_date date
)

select * from t_board;