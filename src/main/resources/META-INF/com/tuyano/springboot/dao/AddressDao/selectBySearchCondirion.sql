select
  /*%expand*/*
from
  address
where
     BELONG_USER_EMAIL = /* belongUserEmail */1
and (
    LASTNAME_KANA  like CONCAT(/* searchCondition */'ア', '%')
or  FIRSTNAME_KANA like CONCAT(/* searchCondition */'ア', '%')
or  LASTNAME       like CONCAT(/* searchCondition */'ア', '%')
or  FIRSTNAME      like CONCAT(/* searchCondition */'ア', '%')
)
order by
    CONCAT(LASTNAME_KANA, FIRSTNAME_KANA, LASTNAME, FIRSTNAME)

