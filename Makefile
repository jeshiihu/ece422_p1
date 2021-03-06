CC = gcc
SOURCES = lib_insertionsort.c


all: main 

main: lib_insertionsort.c
	@echo '----- Compiling Code -----'
	javac *.java
	javah SecondaryInsertionSort
	
	@echo 
	@echo '----- Note: please ensure you are running correct gcc line in makefile -----'
	@echo 
	gcc -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -shared -fpic -o libinsertionsort.so lib_insertionsort.c
#	gcc -I$(JAVA_HOME)/include/ -I$(JAVA_HOME)/include/darwin/ -dynamiclib -o libinsertionsort.jnilib lib_insertionsort.c
	export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.
	@echo 
	

clean:
	-rm -f *.o *.so *.jnilib *.class main

run:
	./main