select DISTINCT TYPECODE as TYPECODE,  TYPENAME  as TYPENAME 
from PLATFORM.t_s_type t,PLATFORM.t_s_typegroup  g 
where  g.typegroupcode = '${dicCode}' 
and t.typegroupid =  g.id