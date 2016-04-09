Cobble
======
Basic building blocks for Bukkit plugins.


Building
--------
```
git clone https://github.com/totemo/Cobble
cd Cobble
mvn
```


Installing In A Local Maven Repository
----------------------------------------
```
mvn install:install-file -Dfile=target/Cobble-1.0.0.jar -DgroupId=io.totemo \
    -DartifactId=cobble -Dversion=1.0.0 -Dpackaging=jar
```


Referencing As A Dependency
---------------------------

pom.xml:

```
	<dependencies>
		<dependency>
			<groupId>io.totemo</groupId>
			<artifactId>cobble</artifactId>
			<version>1.0.0</version>
	        </dependency>
	</dependencies>
```