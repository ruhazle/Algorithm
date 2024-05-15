-- 코드를 입력하세요
select to_char(s.sales_date, 'YYYY') as YEAR
    , to_number(to_char(s.sales_date, 'MM')) as MONTH
    , count(distinct s.user_id) as PUCHASED_USERS
    , round(count(distinct s.user_id) / (
        select count(*)
        from user_info
        where to_char(joined, 'YYYY') = 2021
    ), 1) as PUCHASED_RATIO
from user_info i, online_sale s
where i.user_id = s.user_id
    and to_char(i.joined, 'YYYY') = 2021
group by to_char(sales_date, 'YYYY'), to_number(to_char(s.sales_date, 'MM'))
order by year, month