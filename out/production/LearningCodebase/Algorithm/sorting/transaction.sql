
--| id | merchant_id | amount | status | payment_reference | created_at |


select * from transaction where status = 'FAILED' and merchant_id = 5 and created_at >= now() - Inter order by created_at desc;
