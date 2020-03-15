# Copyright 2020 (c) Fedor Ignatov
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import unittest
from io import StringIO
from string import ascii_lowercase
from unittest.mock import patch

from hang import Word, Hangman


class TestWord(unittest.TestCase):
    def setUp(self):
        self.word = Word()

    def test_all_letters(self):
        for letter in ascii_lowercase:
            _ = self.word.try_guess(letter)
        self.assertEqual(self.word.is_done, True)

    def test_one_letter_twice(self):
        _ = self.word.try_guess('z')
        self.assertEqual(self.word.try_guess('z'), False)


class TestHangman(unittest.TestCase):
    @patch('builtins.input', side_effect=['z\n'] * 10)
    @patch('sys.stdout', new_callable=StringIO)
    def test_loss(self, out: StringIO, _):
        hangman = Hangman()
        hangman.play()
        self.assertEqual('You lost' in out.getvalue(), True)

    @patch('builtins.input', side_effect=[f'{l}\n' for l in ascii_lowercase])
    @patch('sys.stdout', new_callable=StringIO)
    def test_win(self, out: StringIO, _):
        hangman = Hangman(30)
        hangman.play()
        output = out.getvalue()
        self.assertEqual('You won!' in output, True)
        self.assertEqual('Hit!' in output, True)
        self.assertEqual('Missed' in output, True)


if __name__ == '__main__':
    unittest.main()
