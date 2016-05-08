REM Generate WSDL and xsd

wsgen -verbose -keep -cp ./classes -d ./classes -s ./src com.uciext.ws.hw4.service.impl.OrderServiceWSImpl
