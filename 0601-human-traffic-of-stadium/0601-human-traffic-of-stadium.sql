# Write your MySQL query statement below
select id, visit_date, people from (
    select *, lag(id, 1) over(order by id) as prev_id,
              lag(id, 2) over(order by id) as prev2_id,
              lag(people, 1) over(order by id) as prev_ppl,
              lag(people, 2) over(order by id) as prev2_ppl,
              lead(id, 1) over(order by id) as next_id,
              lead(id, 2) over(order by id) as next2_id,
              lead(people, 1) over(order by id) as next_ppl,
              lead(people, 2) over(order by id) as next2_ppl
    from Stadium
) t
where people >= 100 and (
(prev_id = id-1 and prev2_id = id-2 and prev_ppl >= 100 and prev2_ppl >= 100)
or (prev_id = id-1 and next_id = id+1 and prev_ppl >= 100 and next_ppl >= 100)
or (next_id = id+1 and next2_id = id+2 and next_ppl >= 100 and next2_ppl >= 100)
);
