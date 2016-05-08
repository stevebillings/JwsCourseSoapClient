set JAXB_PATH=.\lib\jaxb-ri-2.2.7\lib
set JAXB_LIB=%JAXB_PATH%\jaxb-api.jar;%JAXB_PATH%\jaxb-core.jar;%JAXB_PATH%\jaxb-impl.jar;%JAXB_PATH%\jaxb-jxc.jar;%JAXB_PATH%\jaxb-xjc.jar

set JAXWS_PATH=.\lib\jaxws-ri-2.2.8\lib
set JAXWS_LIB=%JAXWS_PATH%\javax.xml.soap-api.jar;%JAXWS_PATH%\jaxws-api.jar;%JAXWS_PATH%\jaxws-rt.jar

javac -classpath %JAXB_LIB%;%JAXWS_LIB%;.\classes;. -d classes .\src\com\uciext\ws\hw4\util\*.java  .\src\com\uciext\ws\hw4\service\inventory\*.java .\src\com\uciext\ws\hw4\client\*.java

