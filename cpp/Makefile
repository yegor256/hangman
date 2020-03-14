TARGETS=hangman
CC=g++
FLAGS=--std=c++11


all: $(TARGETS)

%: %.cpp
	$(CC) -o $@ $< $(FLAGS)

clean:
	rm -f $(TARGETS)

