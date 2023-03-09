<img src="https://raw.githubusercontent.com/yegor256/hangman/master/images/logo.png" width="100px"/>

[![mvn](https://github.com/yegor256/hangman/actions/workflows/mvn.yml/badge.svg)](https://github.com/yegor256/hangman/actions/workflows/mvn.yml)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/yegor256/hangman/blob/master/LICENSE.txt)

[Hangman](https://en.wikipedia.org/wiki/Hangman_%28game%29) is a words
guessing game for one player. The computer guesses a word and the user
has to suggest letters one by one. Every time the word contains a letter,
the computer opens it (all of them, if there are a few). Every time the
word doesn't contain a letter, the computer gives a penalty point for
the user. If there are five penalty points, the user looses. If there
are no hidden letters anymore, the computer looses.

First, build it:

```
$ mvn clean package
```

Then, run:

```
$ java -classpath target/classes hangman.Main
```

This Java code is very procedural, imperative, and not elegant at all.
Read about [Elegant Objects](https://www.elegantobjects.org) 
and then try to refactor it and improve. You're welcome to create new classes,
new methods, anything. Just make sure it still builds.
When ready, please submit a pull request.

