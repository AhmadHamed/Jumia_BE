drop view if exists customerView;
create view customerView as
select id,
       phone,
       substr(phone, 2, 3)
           as countryCode,
       case
           when phone like '(237)%' then 'Cameroon'
           when phone like '(251)%' then 'Ethiopia'
           when phone like '(212)%' then 'Morocco'
           when phone like '(258)%' then 'Mozambique'
           when phone like '(256)%' then 'Uganda'
           end
           as country
from customer;