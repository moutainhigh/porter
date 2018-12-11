@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  porter-node-boot startup script for Windows
@rem
@rem ##########################################################################

set bash=%DIRNAME%..

set CLASSPATH=%bash%\lib\porter-node-boot-master.jar

setlocal enabledelayedexpansion
for %%j in (%bash%\lib\*.jar) do (
set CLASSPATH=!CLASSPATH!;%cd%\%%j
echo current jar is %%j.)

set class_path=%CLASSPATH%;

java -classpath %class_path%  cn.vbill.middleware.porter.boot.NodeBootApplication