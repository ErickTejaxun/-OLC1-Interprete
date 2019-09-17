
cd C:\Users\erick\Documents\NetBeansProjects\OLC1_S2_2019\src\Analisis\
java -jar C:\libs\jflex-1.6.1\lib\jflex-1.6.1.jar scanner.l
pause  


SET CUP_HOME= C:\libs\java-cup-11b
cd C:\Users\erick\Documents\NetBeansProjects\OLC1_S2_2019\src\Analisis\
java -jar %CUP_HOME%\java-cup-11b.jar -parser parser parser.cup
pause
