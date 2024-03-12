show user;

select *
from tbl_member
order by userseq desc;

update tbl_member set status = 1;
commit;