select
  /*%expand*/*
from
  address
where
     BELONG_USER_EMAIL = /* belongUserEmail */1
and LASTNAME_KANA like CONCAT(/* searchCondition */'ア', '%')
order by
    CONCAT(LASTNAME_KANA, FIRSTNAME_KANA, LASTNAME, FIRSTNAME)

