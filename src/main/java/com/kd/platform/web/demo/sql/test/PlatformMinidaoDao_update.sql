UPDATE PLATFORM.platform_minidao 
SET
<#if platformMinidao.age ?exists && platformMinidao.age ?length gt 0>
	age=:platformMinidao.age,
</#if>
<#if platformMinidao.userName ?exists && platformMinidao.userName ?length gt 0>
	 userName=:platformMinidao.userName
</#if>
WHERE id=:platformMinidao.id