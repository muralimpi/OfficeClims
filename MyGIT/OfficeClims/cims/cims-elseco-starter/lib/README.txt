**********************************************************************************************************
				P L E A S E    D O    N O T     R E M O V E   T H E S E     F I L E S
**********************************************************************************************************
Note:  These are used for the SAP JCP RFC integration.
libsapjco3.so
sapjco3.dll
sapjco3.jar



----------------I N S T A L L I N G    SAPJCO   L I B R A R Y     I N    L I B   P A T H   --------------
1) On Linux, go to  /lib  folder
2) Copy the   attached file    " libsapjco3.so "  to the /lib folder
3) Go to /etc folder and update the  " bash.bashrc "  file with the following entry --

## Adding libsapjco3.so to lib folder and configuring it here 
SAPJCO_LIBFILE_PATH=/lib/libsapjco3.so
export SAPJCO_LIBFILE_PATH

4) Save the file and restart the server/application to take effect.




----------------I N S T A L L I N G    SAPJCO   J A R    T O      L O C A L    M A V E N   ---------------
Please install the sapjco3.jar into your local maven by running below command from the directory where the sapjco3.jar is present.
	
mvn install:install-file -DgroupId=org.hibersap -DartifactId=com.sap.conn.jco.sapjco3 -Dversion=3.0.18 -Dpackaging=jar -Dfile=sapjco3.jar -DfinalName=sapjco3




**********************************************************************************************************