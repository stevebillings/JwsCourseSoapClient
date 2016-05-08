SET TOMCAT_PATH=C:\Apps\apache-tomcat-7.0.42

REM copy classes
cd webapp\inventoryWS\WEB-INF
rd classes /S /Q
md classes
xcopy ..\..\..\classes .\classes /S /Q

REM create war
cd ..
jar -cvf inventoryWS.war WEB-INF

REM deploy
copy inventoryWS.war %TOMCAT_PATH%\webapps

cd ..\..



