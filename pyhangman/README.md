<img src="https://raw.githubusercontent.com/yegor256/hangman/master/images/logo.png" width="100px"/>

[Hangman](https://en.wikipedia.org/wiki/Hangman_%28game%29) is a words
guessing game for one player. The computer guesses a word and the user
has to suggest letters one by one. Every time the word contains a letter,
the computer opens it (all of them, if there are a few). Every time the
word doesn't contain a letter, the computer gives a penalty point for
the user. If there are five penalty points, the user looses. If there
are no hidden letters anymore, the computer looses.

PyHangman supports Python 3.6 or greater.

To start game, `cd` to `pyhangman` directory and run:

```
$ python3 hang.py
```

To start tests, run:
```bash
$ virtualenv --python=python3 venv
$ . venv/bin/activate
$ pip install mock==4.0.2
$ python tests.py -v
```

## License

Copyright 2020 (c) Fedor Ignatov

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
