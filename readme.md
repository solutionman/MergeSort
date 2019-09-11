
mvn clean install

cd target/

java -jar MergeSort.jar

for merging files enter arguments:
[type of sort (-a -d)] [type of data (-s -i)] [output file(name)] [input files(names)]

for example:
java -jar MergeSort.jar -a -i out.txt in.txt in2.txt in3.txt



