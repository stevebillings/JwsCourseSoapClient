SET TOMCAT_PATH=C:\apps\apache-tomcat-7.0.50

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



