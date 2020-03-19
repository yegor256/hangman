#include "guessed_word.hpp"
#include <string>
#include <cstdlib>

static const std::vector<std::string> WORDS = {
  "simplicity", "equality", "grandmother",
  "neighborhood", "relationship", "mathematics",
  "university", "explanation"
};

GuessedWord::GuessedWord()
  : m_word(WORDS[std::rand() % WORDS.size()])
  , m_guessed_amount(0)
  , m_already_guessed() {
}

GuessedVec GuessedWord::Guess(char letter) {
  GuessedVec result;

  for (size_t pos = 0; pos < m_word.size(); ++pos) {
    if (m_word[pos] == letter) {
      result.push_back(pos);
    }
  }

  if (m_already_guessed.count(letter) == 0) {
    m_already_guessed.insert(letter);
    m_guessed_amount += result.size();
  }

  return result;
}

size_t GuessedWord::GetSize() const {
  return m_word.size();
}

bool GuessedWord::IsGuessed() const {
  return m_guessed_amount == m_word.size();
}
