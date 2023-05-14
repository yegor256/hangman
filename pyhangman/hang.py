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

import random
from typing import List

WORDS = [
    "simplicity", "equality", "grandmother",
    "neighborhood", "relationship", "mathematics",
    "university", "explanation"
]


class Word:
    syllable: str
    visible: List[bool]

    def __init__(self) -> None:
        self.syllable = random.choice(WORDS)
        self.visible = [False for _ in self.syllable]

    @property
    def is_done(self) -> bool:
        return all(self.visible)

    def try_guess(self, guess: str) -> bool:
        hit = False
        for i, letter in enumerate(self.syllable):
            if letter == guess and not self.visible[i]:
                self.visible[i] = True
                hit = True
        return hit

    def __str__(self) -> str:
        appearance = ''.join([letter if vis else '?' for letter, vis in zip(self.syllable, self.visible)])
        return f'The word: {appearance}'


class Hangman:
    def __init__(self, max_mistakes: int = 5) -> None:
        self.mistakes = 0
        self.max_mistakes = max_mistakes
        self.word = Word()

    @staticmethod
    def read_guess() -> str:
        return input('Guess a letter: ')[0].lower()

    def update_mistakes(self, hit: bool) -> None:
        if hit:
            print('Hit!')
        else:
            self.mistakes += 1
            print(f"Missed, mistake {self.mistakes} out of {self.max_mistakes}")

    def play(self) -> None:
        while self.mistakes < self.max_mistakes and not self.word.is_done:
            guess = self.read_guess()
            hit = self.word.try_guess(guess)
            self.update_mistakes(hit)
            print(self.word, end='\n\n')
        if self.word.is_done:
            print('You won!')
        else:
            print('You lost.')


if __name__ == '__main__':
    game = Hangman()
    game.play()
