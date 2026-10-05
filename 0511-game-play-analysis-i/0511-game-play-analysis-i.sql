# Write your MySQL query statement below
-- select player_id, event_date as first_login from (
--     select *, dense_rank() over(
--         partition by player_id order by event_date asc
--     ) as rk
--     from Activity
-- ) as nt
-- where rk = 1;

select player_id, min(event_date) as first_login from Activity
group by player_id;