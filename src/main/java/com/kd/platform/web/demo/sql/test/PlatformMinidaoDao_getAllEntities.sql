SELECT * FROM PLATFORM.platform_minidao WHERE
<#if platformMinidao.userName ?exists && platformMinidao.userName ?length gt 0>
	and user_name = :platformMinidao.userName
</#if>
<#if platformMinidao.mobilePhone ?exists && platformMinidao.mobilePhone ?length gt 0>
	and mobile_phone = :platformMinidao.mobilePhone
</#if>
<#if platformMinidao.officePhone ?exists && platformMinidao.officePhone ?length gt 0>
	and office_phone = :platformMinidao.officePhone
</#if>
<#if platformMinidao.email ?exists && platformMinidao.email ?length gt 0>
	and email = :platformMinidao.email
</#if>
<#if platformMinidao.age ?exists && platformMinidao.age ?length gt 0>
	and age = :platformMinidao.age
</#if>
<#if platformMinidao.salary ?exists && platformMinidao.salary ?length gt 0>
	and salary = :platformMinidao.salary
</#if>
<#if platformMinidao.sex ?exists && platformMinidao.sex ?length gt 0>
	and sex = :platformMinidao.sex
</#if>
<#if platformMinidao.status ?exists && platformMinidao.status ?length gt 0>
	and status = :platformMinidao.status
</#if>
