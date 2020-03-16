//
// Created by zeronsix on 16.03.2020.
//

#include "game.hpp"

constexpr size_t MAX_MISTAKES = 5;

Game::Game()
	: m_guessed_word()
	, m_mistakes(MAX_MISTAKES)
	, m_word_display(m_guessed_word.GetSize())
	, m_user_input()
	, m_progress_display(m_mistakes) {
}

void Game::Play() {
	while (!IsOver()) {
		char letter = m_user_input.InputLetter();
		auto guessed = m_guessed_word.Guess(letter);
		if (guessed.empty()) {
			m_mistakes.MakeOne();
			m_progress_display.ShowMiss();
		} else {
			m_progress_display.ShowHit();
		}

		m_word_display.Reveal(letter, guessed);
		m_word_display.Show();
	}
	if (IsWon()) {
		m_progress_display.ShowWin();
	} else {
		m_progress_display.ShowLoss();
	}
}

bool Game::IsOver() const {
	return IsWon() || IsLost();
}

bool Game::IsWon() const {
	return m_guessed_word.IsGuessed();
}

bool Game::IsLost() const {
	return m_mistakes.IsMaxAmountReached();
}

